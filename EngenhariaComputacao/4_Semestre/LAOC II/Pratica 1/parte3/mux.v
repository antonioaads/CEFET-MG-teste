module mux_2_1_1_bit(s0,in0,in1,out);
	input in0,in1;
	input s0;
	output out;
	
	assign out =((in0 & ~s0) | 
					(in1 & s0));
endmodule

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

module mux_8_1_4_bits(s0,s1,s2,in0,in1,in2,in3,in4,in5,in6,in7,out);
	input [3:0]in0,in1,in2,in3,in4,in5,in6,in7;
	input s0,s1,s2;
	output [3:0]out;
	
	mux_8_1_1_bit m0(s0,s1,s2,in0[0],in1[0],in2[0],in3[0],in4[0],in5[0],in6[0],in7[0],out[0]);
	mux_8_1_1_bit m1(s0,s1,s2,in0[1],in1[1],in2[1],in3[1],in4[1],in5[1],in6[1],in7[1],out[1]);
	mux_8_1_1_bit m2(s0,s1,s2,in0[2],in1[2],in2[2],in3[2],in4[2],in5[2],in6[2],in7[2],out[2]);
	mux_8_1_1_bit m3(s0,s1,s2,in0[3],in1[3],in2[3],in3[3],in4[3],in5[3],in6[3],in7[3],out[3]);

endmodule

module mux_2_1_2_bits(s0,in0,in1,out);
	input [1:0]in0,in1;
	input s0;
	output [1:0]out;
	
	mux_2_1_1_bit m0(s0,in0[0],in1[0],out[0]);
	mux_2_1_1_bit m1(s0,in0[1],in1[1],out[1]);
	
endmodule

module mux_2_1_4bits(s0,in0,in1,out);
	input [3:0]in0,in1;
	input s0;
	output [3:0]out;
	
	mux_2_1_1_bit m0(s0,in0[0],in1[0],out[0]);
	mux_2_1_1_bit m1(s0,in0[1],in1[1],out[1]);
	mux_2_1_1_bit m2(s0,in0[2],in1[2],out[2]);
	mux_2_1_1_bit m3(s0,in0[3],in1[3],out[3]);
	
endmodule

module mux_2_1_17bits(s0,in0,in1,out);
	input [16:0]in0,in1;
	input s0;
	output [16:0]out;
	
	mux_2_1_4bits m0(s0,in0[16:13],in1[16:13],out[16:13]);
	mux_2_1_4bits m1(s0,in0[12:9],in1[12:9],out[12:9]);
	mux_2_1_4bits m2(s0,in0[8:5],in1[8:5],out[8:5]);
	mux_2_1_4bits m3(s0,in0[4:1],in1[4:1],out[4:1]);
	mux_2_1_1_bit m4(s0,in0[0],in1[0],out[0]);
	
endmodule