module registrador_16bits(clock,enable, din, dout);
	input clock, enable;
	input [15:0]din;
	output [15:0]dout;
	
	reg [15:0]reg1;
	
	assign dout = reg1[15:0];
	
	always @(posedge (clock&enable))
	begin
		reg1 = din;
	end
endmodule