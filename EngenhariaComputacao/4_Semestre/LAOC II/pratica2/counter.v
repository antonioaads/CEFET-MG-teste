module counter(clock,clear,out);
  input clock, clear;
  output [2:0]out;
  
  reg [2:0]count;
  assign out = count;
  
  always @(posedge clock,posedge clear)
  begin
    count = count + 1;
    if(clear)
      begin
        count = 0;
      end   
  end
	
endmodule
