module control_unit(run,          //aciona o módulo 1bit
                    resetn,       //reseta o módulo 1bit
                    counter,      //entrada da máquina de estados 3bits
                    counter_clear,//reset da máquina de estados 1bit
                    counter_run,  //habilita contagem do contador (máquina de estado)
                    ir,           //entrada de instrução 10bits
                    ir_act,       //Habilita nova instrução
                    mux_control,  //controle do multiplexador 4bits
                    done,         //Saída para mostrar que ta pronto 1bit
                    r_act,        //Habilite escrita nos registradores R[] 8bits
                    a_act,        //Habilita escrita no registrador A 1bit
                    g_act,        //Habilita escrita no registrador G 1bit
                    addr_act,     //Habilita escrita no registrador ADDR 1bit
                    dout_act,     //Habilita escrita no registrador DOUT 1bit
                    w_d,          //Write da memória 1bit
                    addsub,       //Comando da ULA 3bits
                    incr_pc);     //Incremento PC
  
  input run, resetn;
  input[2:0]counter;
  input[9:0]ir;
  output counter_clear, counter_run;
  output reg done, a_act,g_act,addr_act, dout_act, w_d, ir_act,incr_pc;
  output reg[7:0]r_act;
  output reg[3:0]mux_control;
  output reg[2:0]addsub;
  
  assign counter_clear = resetn;
  always @(posedge resetn) begin
    
  end

  assign counter_run = run;

  always @(counter)
    begin
      casex (ir[9:6])
        4'b0xxx : //Instrução que utiliza a ULA
          begin
            case (counter)
              3'd0:
                begin
                  a_act <= 0;
                  g_act <= 0;
                  r_act <= 0; 
                  addr_act <= 0;
                  dout_act <= 0;
                  done <= 0;
                  w_d <= 0;
                  ir_act <= 1;
                  mux_control<=0;
                  incr_pc <= 0;
                  addsub <= 3'b000;  //Comando da ULA
                end     //0001. 000. 000.
              3'd1:
                begin
                  ir_act <= 0;
                  addsub <= ir[8:6];  //Comando da ULA
                  mux_control <= ir[5:3];
                  a_act <= 1;
                end
              3'd2:
                begin
                  a_act <= 0;
                  mux_control <= ir[2:0];
                  g_act <= 1; 
                end
              3'd3:
                begin
                  g_act <= 0;
                  mux_control <= 4'b1000; //Configura saída do Mux para G
                  r_act[ir[5:3]] <= 1;
                end
              3'd4:
                begin
                  r_act[ir[5:3]] <= 0;  //Fim da instrução x;
                  incr_pc <= 1; // requisita incremento
                  mux_control <= 4'b0111; // seleciona PC para o bus
                end
              3'd5:
                begin
                  incr_pc <= 0;
                  addr_act <= 1; // salva endereço pra próxima instrução
                end
              3'd6:
                begin
                  addr_act <= 0;
                end
            endcase
          end
        4'b1000: //Instrução mv
          begin
            case (counter)
              3'd0:
                begin
                  a_act <= 0;
                  g_act <= 0;
                  r_act <= 0; 
                  addr_act <= 0;
                  dout_act <= 0;
                  done <= 0;
                  w_d <= 0;
                  ir_act <= 1;
                  mux_control<=0;
                  incr_pc <= 0;
                end
              3'd1:
                begin
                  mux_control <= ir[2:0];
                  r_act[ir[5:3]] <= 1;
                end
              3'd2:
                begin
                  r_act[ir[5:3]] <= 0;  //Fim da instrução mv;
                end
            endcase
          end
        4'b1001: //Instrução mvi
          begin
            case (counter)
              3'd0:
                begin
                  a_act <= 0;
                  g_act <= 0;
                  r_act <= 0; 
                  addr_act <= 0;
                  dout_act <= 0;
                  done <= 0;
                  w_d <= 0;
                  ir_act <= 1;
                  mux_control<=0;
                  incr_pc <= 0;
                end
              3'd1:
                begin
                  mux_control <= 4'b1001;
                  r_act[ir[5:3]] <= 1;
                end
              3'd2:
                begin
                  r_act[ir[5:3]] <= 0;  //Fim da instrução mvi;
                end
            endcase
          end
        /*4'd3: //4ª Instrução
          begin
          end
        4'd4: //5ª Instrução
          begin
          end
        4'd5: //6ª Instrução
          begin
          end
        4'd6: //7ª Instrução
          begin
          end
        4'd7: //8ª Instrução
          begin
          end*/
          default:
          begin
            a_act <= 0;
            g_act <= 0;
            r_act <= 0; 
            addr_act <= 0;
            dout_act <= 0;
            done <= 0;
            w_d <= 0;
            ir_act <= 1;
            mux_control<=0;
            incr_pc <= 0;
            addsub <= 3'b000;  //Comando da ULA
          end
      endcase
    end
endmodule