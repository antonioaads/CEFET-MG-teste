module compara_2_2_bits(in0,in1,out);
	input [1:0]in0,in1;
	output out;
	
	assign out = ((in0[0]==in1[0])&(in0[1]==in1[1]));
	
endmodule