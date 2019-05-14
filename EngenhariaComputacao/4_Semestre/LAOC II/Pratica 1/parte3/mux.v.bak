module mux_8_1_1_bit(s0,s1,s2,in0,in1,in2,in3,in4,in5,in6,in7,out);
	input in0,in1,in2,in3,in4,in5,in6,in7;
	input s0,s1,s2;
	output out;
	
	assign out =((in0 & ~s0 & ~s1 & ~s2) | 
					(in1 & ~s0 & ~s1 & s2) | 
					(in2 & ~s0 & s1 & ~s2) | 
					(in3 & ~s0 & s1 & s2) | 
					(in4 & s0 & ~s1 & ~s2) | 
					(in5 & s0 & ~s1 & s2) | 
					(in6 & s0 & s1 & ~s2) | 
					(in7 & s0 & s1 & s2));
endmodule