//module cache (data,rdaddress,rdclock,rden,wraddress,wrclock,wren,q);
/*
	data 		-> Entrada do valor a ser escrito 	-> 17 bits
	raddress -> Endereço da memória a ser lido	-> 3 bits
	rdclock	-> Clock de leitura						-> 1 bit
	rden		-> Habilita Leitura						-> 1 bit
	waddress -> Endereço da memória a ser lido	-> 3 bits
	wrclock	-> Clock de leitura						-> 1 bit
	wren		-> Habilita Leitura						-> 1 bit
	q			-> Valor lido da memória				-> 17 bits
*/ 

module top_parte3(KEY,SW,HEX0,HEX1,HEX2,HEX3,HEX4,HEX5,HEX6,HEX7,LEDR,LEDG);
	input [17:0]SW;
	input [3:0]KEY;
	
	output [6:0]HEX0,HEX1,HEX2,HEX3,HEX4,HEX5,HEX6,HEX7;
	output [17:0]LEDR;
	output [7:0]LEDG;
	
	assign HEX1 = 8'b11111111;
	assign HEX3 = 8'b11111111;
	assign HEX4 = 8'b11111111;
	assign HEX5 = 8'b11111111;
	
	reg [1:0]clock; //clock para controle dos estados
	
	//Wires auxiliares
	wire [3:0]zero;
	assign zero = 4'b0000;
	
	//Wires para controle da memoria
	wire rdclock, wrclock; //Fios do clock da cache
	wire rden,wren; //Fios para habilita e desabilita escrita e leitura da memoria
	wire [2:0]rdaddress,wraddress; //Endereço de escrita e leitura da memoria
	wire [16:0]linha_in,linha_out; //Dado para entrar e sair da memoria
	
	assign rdaddress = index;	//Mada index para a memória
	assign wraddress = index;
	
	//wires para controle das chaves de input
	wire [2:0]index;
	wire [1:0]tag_in;
	wire escrita,leitura;
	wire [3:0]dado_in;
	//wire clock_principal;
	wire clock_principal1;
	wire clock_principal2;
	
	assign index = SW[15:13];
	assign tag_in = SW[17:16];
	assign escrita = SW[12];
	assign leitura = SW[11];
	assign dado_in = SW[3:0];
	//assign clock_principal = ~KEY[0];
	assign clock_principal1 = ~KEY[0];
	assign clock_principal2 = ~clock_principal1;
	
	tradutor_4_bits_7_seguimentos display0(tag_in,HEX7[6:0]); //Mostra o valor da tag no display 7 seguimentos
	tradutor_4_bits_7_seguimentos display1(index,HEX6[6:0]); //Mostra o valor do index no display 7 seguimentos
	
	tradutor_4_bits_7_seguimentos display2(dado_in,HEX0[6:0]); //Mostra o valor de entrada no display 7 seguimentos
	
	//wires com separação da linha lida (linha_out)
	wire lru, val0,dirty0,val1,dirty1;
	wire [1:0] tag0,tag1;
	wire [3:0] dado0,dado1;
	
	assign lru = linha_out[16];	//LRU
	
	//Dados separados do primeiro conjunto
	assign val0 = linha_out[15];
	assign dirty0 = linha_out[14];
	assign tag0 = linha_out[13:12];
	assign dado0 = linha_out[11:8];
	
	//Dados separados do segundo conjunto
	assign val1 = linha_out[7];
	assign dirty1 = linha_out[6];
	assign tag1 = linha_out[5:4];
	assign dado1 = linha_out[3:0];
	
	//Wires para comparacao e manipulação
	wire resul_comp_0,resul_comp_1; //Para o resultado das comparações
	
	/********************************************************************************
	************************* ESCRITA ***********************************************
	*********************************************************************************/
	wire comando_escrita;
	wire [16:0]linha_escrita;
	
	assign linha_escrita[16] = ~comando_escrita; //Trata LRU
	
	assign linha_escrita[15] = ~comando_escrita & val0; //Trata validade 0
	assign linha_escrita[14] = ~comando_escrita & dirty0;//Trata dirty 0
	
	assign linha_escrita[7] = comando_escrita & val1;//Trata validade 1
	assign linha_escrita[6] = comando_escrita & dirty1;//Trata dirty 1

	
	mux_2_1_2_bits def_tag0(comando_escrita,tag_in,tag0,linha_escrita[13:12]); //Trata tag 0
	mux_2_1_2_bits def_tag1(~comando_escrita,tag_in,tag1,linha_escrita[5:4]); //Trata tag 1
	
	mux_2_1_4bits dado_0(comando_escrita,dado_in,dado0,linha_escrita[11:8]);
	mux_2_1_4bits dado_1(~comando_escrita,dado_in,dado1,linha_escrita[3:0]);
	
	mux_8_1_1_bit mux2(lru,val0,val1,0,0,1,0,1,0,1,1,comando_escrita); // Define comando_escrita (seletor)
	
	//Tratamento do aviso do dirty
	wire aviso_dirty;
	
	mux_2_1_2_bits dirty_alert(comando_escrita,dirty0,dirty1,aviso_dirty); //Avisa sobre o dirty na posição que será gravada
	assign LEDR[17] = aviso_dirty & escrita;
	/********************************************************************************
	************************* LEITURA ***********************************************
	*********************************************************************************/
	wire [3:0]leitura_out; //Colocar o resultado no display
	wire lru_out;
	wire [16:0]linha_leitura;
	
	
	//Comparações das tags
	compara_2_2_bits compara_tag0(tag_in,tag0,resul_comp_0);
	compara_2_2_bits compara_tag1(tag_in,tag1,resul_comp_1);
	
	//And com o resultado da comparação e o bit de validade
	wire A;
	wire B;
	
	assign A = val0 & resul_comp_0; //Parte do tratamento da validação das tags
	assign B = val1 & resul_comp_1;
	
	assign LEDR[0] = (~A & ~B)& leitura; //Aviso do miss
	
	mux_8_1_4_bits mux0(lru,A,B,zero,dado1,dado0,dado1,zero,dado1,dado0,dado0,leitura_out);
	mux_8_1_1_bit mux1(lru,A,B,0,0,1,0,1,0,1,1,lru_out);
	
	//Montando linha para atualizar memória
	assign linha_leitura[15:0] = linha_out[15:0];
	assign linha_leitura[16] = lru_out;
	
	cache c1(linha_in,rdaddress,rdclock,rden,wraddress,wrclock,wren,linha_out);
	
	
	//controle das maquinas de estado
	assign rdclock = clock_principal1;//~KEY[1];//clock_principal & ~clock[1] & ~clock[0];
	assign wrclock = clock_principal2;//~KEY[2];//clock_principal & clock[1] & ~clock[0];
	assign rden = 1;//SW[9];//~clock[1];
	assign wren = 1;//SW[10];//clock[1];
	
	//aviso validade
	wire aviso_validade;
	mux_8_1_1_bit validade_alert(lru,A,B,0,val1,val0,val1,0,val1,val0,val0,aviso_validade);
	assign LEDG[0] = aviso_validade & leitura;
	
	//mostrar no display
	tradutor_4_bits_7_seguimentos display3(leitura_out,HEX2[6:0]); //Mostra o valor de saida no display 7 seguimentos
	
	
	assign LEDR[8] = lru_out;
	/********************************************************************************
	************************* JUNÇÃO ************************************************
	*********************************************************************************/
	mux_2_1_17bits juncao_leitura_escrita(escrita,linha_leitura,linha_escrita,linha_in);
	
	
	//contador para auxiliar a máquina de estados
	/*always @(negedge clock_principal)
	begin
		if(~escrita & ~leitura)
		clock = 2'b00;
		else
		clock = clock + (leitura | escrita);
	end*/
	
endmodule