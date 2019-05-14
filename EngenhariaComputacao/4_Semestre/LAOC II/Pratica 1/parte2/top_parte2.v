//module ram_2_port (clock,data,rdaddress,wraddress,wren,q);
/*
	data 		-> Entrada do valor a ser escrito 	-> 8 bits
	raddress -> Endereço da memória a ser lido	-> 5 bits
	wraddress-> Endereço da memória a ser escrito-> 5 bits
	wren		-> Habilita escrita na memória		-> 1 bit
	q			-> Valor lido da memória				-> 8 bits
*/ 


module top_parte2(KEY,SW,HEX0,HEX1,HEX2,HEX3,HEX4,HEX5,HEX6,HEX7,CLOCK_50);
	input [17:0]SW;
	input [3:0]KEY;
	input CLOCK_50;
	
	output [6:0]HEX0,HEX1,HEX2,HEX3,HEX4,HEX5,HEX6,HEX7;
	
	wire clock, wren;
	wire [7:0]data,q;
	wire [4:0]rdaddress,wraddress;
	
	assign wren = ~KEY[0];
	assign clock = CLOCK_50;
	
	assign data = SW[7:0];
	assign rdaddress = SW[12:8];
	assign wraddress = SW[17:13];
	
	ram_2_port ram(clock,data,rdaddress,wraddress,wren,q);
	
	tradutor_4_7_seguimentos t0(data[3:0],HEX0[6:0]);
	tradutor_4_7_seguimentos t1(data[7:4],HEX1[6:0]);
	tradutor_4_7_seguimentos t2(q[3:0],HEX2[6:0]);
	tradutor_4_7_seguimentos t3(q[7:4],HEX3[6:0]);
	
	//Concatenar -> {<bits mais significativos>,<bits menos significativos>}
	tradutor_4_7_seguimentos t4(rdaddress[3:0],HEX4[6:0]);
	tradutor_4_7_seguimentos t5(rdaddress[4],HEX5[6:0]);	//AutoCompleta os bits faltantes com zero
	tradutor_4_7_seguimentos t6(wraddress[3:0],HEX6[6:0]);
	tradutor_4_7_seguimentos t7(wraddress[4],HEX7[6:0]);	//AutoCompleta os bits faltantes com zero
	
endmodule

module tradutor_4_7_seguimentos(data,display);
	input [3:0]data;
	output [6:0]display;
	
	assign display[0] = 	(~data[3] & ~data[2] & ~data[1] & data[0]) |
								(~data[3] & data[2] & ~data[1] & ~data[0]) |
								(data[3] & ~data[2] & data[1] & data[0]) |
								(data[3] & data[2] & ~data[1] & data[0]);
								
	assign display[1]	=	(~data[3] & data[2] & ~data[1] & data[0]) |
								(~data[3] & data[2] & data[1] & ~data[0]) |
								(data[3] & ~data[2] & data[1] & data[0]) |
								(data[3] & data[2] & ~data[1] & ~data[0]) |
								(data[3] & data[2] & data[1] & ~data[0]) |
								(data[3] & data[2] & data[1] & data[0]);
								
	assign display[2]	=	(~data[3] & ~data[2] & data[1] & ~data[0]) |
								(data[3] & data[2] & ~data[1] & ~data[0]) |
								(data[3] & data[2] & data[1] & ~data[0]) |
								(data[3] & data[2] & data[1] & data[0]);
								
	assign display[3]	=	(~data[3] & ~data[2] & ~data[1] & data[0]) |
								(~data[3] & data[2] & ~data[1] & ~data[0]) |
								(~data[3] & data[2] & data[1] & data[0]) |
								(data[3] & ~data[2] & data[1] & ~data[0]) |
								(data[3] & data[2] & data[1] & data[0]);
								
	assign display[4]	=	(~data[3] & ~data[2] & ~data[1] & data[0]) |
								(~data[3] & ~data[2] & data[1] & data[0]) |
								(~data[3] & data[2] & ~data[1] & ~data[0]) |
								(~data[3] & data[2] & ~data[1] & data[0]) |
								(~data[3] & data[2] & data[1] & data[0]) |
								(data[3] & ~data[2] & ~data[1] & data[0]);
								
	assign display[5]	=	(~data[3] & ~data[2] & ~data[1] & data[0]) |
								(~data[3] & ~data[2] & data[1] & ~data[0]) |
								(~data[3] & ~data[2] & data[1] & data[0]) |
								(~data[3] & data[2] & data[1] & data[0]) |
								(data[3] & data[2] & ~data[1] & data[0]);
								
	assign display[6]	=	(~data[3] & ~data[2] & ~data[1] & ~data[0]) |
								(~data[3] & ~data[2] & ~data[1] & data[0]) |
								(~data[3] & data[2] & data[1] & data[0]) |
								(data[3] & ~data[2] & data[1] & ~data[0]) |
								(data[3] & data[2] & ~data[1] & ~data[0]);

endmodule