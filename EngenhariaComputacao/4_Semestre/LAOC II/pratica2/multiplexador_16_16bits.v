module mux_16_1_1_bit(s3,s2,s1,s0,in0,in1,in2,in3,in4,in5,in6,in7,in8,in9,in10,in11,in12,in13,in14,in15,out);
	input in0,in1,in2,in3,in4,in5,in6,in7,in8,in9,in10,in11,in12,in13,in14,in15;
	input s0,s1,s2,s3;
	output out;
	
	assign out =((in0 & ~s0 & ~s1 & ~s2 & ~s3) | 
					(in1 & ~s0 & ~s1 & ~s2 & s3) |
					(in2 & ~s0 & ~s1 & s2 & ~s3) |
					(in3 & ~s0 & ~s1 & s2 & s3) |
					(in4 & ~s0 & s1 & ~s2 & ~s3) |
					(in5 & ~s0 & s1 & ~s2 & s3) |
					(in6 & ~s0 & s1 & s2 & ~s3) |
					(in7 & ~s0 & s1 & s2 & s3) |
					(in8 & s0 & ~s1 & ~s2 & ~s3) |
					(in9 & s0 & ~s1 & ~s2 & s3) |
					(in10 & s0 & ~s1 & s2 & ~s3) |
					(in11 & s0 & ~s1 & s2 & s3) |
					(in12 & s0 & s1 & ~s2 & ~s3) |
					(in13 & s0 & s1 & ~s2 & s3) |
					(in14 & s0 & s1 & s2 & ~s3) |
					(in15 & s0 & s1 & s2 & s3));
endmodule

module mux_16_1_16_bit(s,in0,in1,in2,in3,in4,in5,in6,in7,in8,in9,in10,in11,in12,in13,in14,in15,out);
	input [15:0]in0,in1,in2,in3,in4,in5,in6,in7,in8,in9,in10,in11,in12,in13,in14,in15;
	input [3:0]s;
	output [15:0]out;
	
	mux_16_1_1_bit m0(s[0],s[1],s[2],s[3],in0[0],in1[0],in2[0],in3[0],in4[0],in5[0],in6[0],in7[0],in8[0],in9[0],in10[0],in11[0],in12[0],in13[0],in14[0],in15[0],out[0]);
	mux_16_1_1_bit m1(s[0],s[1],s[2],s[3],in0[1],in1[1],in2[1],in3[1],in4[1],in5[1],in6[1],in7[1],in8[1],in9[1],in10[1],in11[1],in12[1],in13[1],in14[1],in15[1],out[1]);
	mux_16_1_1_bit m2(s[0],s[1],s[2],s[3],in0[2],in1[2],in2[2],in3[2],in4[2],in5[2],in6[2],in7[2],in8[2],in9[2],in10[2],in11[2],in12[2],in13[2],in14[2],in15[2],out[2]);
	mux_16_1_1_bit m3(s[0],s[1],s[2],s[3],in0[3],in1[3],in2[3],in3[3],in4[3],in5[3],in6[3],in7[3],in8[3],in9[3],in10[3],in11[3],in12[3],in13[3],in14[3],in15[3],out[3]);
	mux_16_1_1_bit m4(s[0],s[1],s[2],s[3],in0[4],in1[4],in2[4],in3[4],in4[4],in5[4],in6[4],in7[4],in8[4],in9[4],in10[4],in11[4],in12[4],in13[4],in14[4],in15[4],out[4]);
	mux_16_1_1_bit m5(s[0],s[1],s[2],s[3],in0[5],in1[5],in2[5],in3[5],in4[5],in5[5],in6[5],in7[5],in8[5],in9[5],in10[5],in11[5],in12[5],in13[5],in14[5],in15[5],out[5]);
	mux_16_1_1_bit m6(s[0],s[1],s[2],s[3],in0[6],in1[6],in2[6],in3[6],in4[6],in5[6],in6[6],in7[6],in8[6],in9[6],in10[6],in11[6],in12[6],in13[6],in14[6],in15[6],out[6]);
	mux_16_1_1_bit m7(s[0],s[1],s[2],s[3],in0[7],in1[7],in2[7],in3[7],in4[7],in5[7],in6[7],in7[7],in8[7],in9[7],in10[7],in11[7],in12[7],in13[7],in14[7],in15[7],out[7]);
	mux_16_1_1_bit m8(s[0],s[1],s[2],s[3],in0[8],in1[8],in2[8],in3[8],in4[8],in5[8],in6[8],in7[8],in8[8],in9[8],in10[8],in11[8],in12[8],in13[8],in14[8],in15[8],out[8]);
	mux_16_1_1_bit m9(s[0],s[1],s[2],s[3],in0[9],in1[9],in2[9],in3[9],in4[9],in5[9],in6[9],in7[9],in8[9],in9[9],in10[9],in11[9],in12[9],in13[9],in14[9],in15[9],out[9]);
	mux_16_1_1_bit m10(s[0],s[1],s[2],s[3],in0[10],in1[10],in2[10],in3[10],in4[10],in5[10],in6[10],in7[10],in8[10],in9[10],in10[10],in11[10],in12[10],in13[10],in14[10],in15[10],out[10]);
	mux_16_1_1_bit m11(s[0],s[1],s[2],s[3],in0[11],in1[11],in2[11],in3[11],in4[11],in5[11],in6[11],in7[11],in8[11],in9[11],in10[11],in11[11],in12[11],in13[11],in14[11],in15[11],out[11]);
	mux_16_1_1_bit m12(s[0],s[1],s[2],s[3],in0[12],in1[12],in2[12],in3[12],in4[12],in5[12],in6[12],in7[12],in8[12],in9[12],in10[12],in11[12],in12[12],in13[12],in14[12],in15[12],out[12]);
	mux_16_1_1_bit m13(s[0],s[1],s[2],s[3],in0[13],in1[13],in2[13],in3[13],in4[13],in5[13],in6[13],in7[13],in8[13],in9[13],in10[13],in11[13],in12[13],in13[13],in14[13],in15[13],out[13]);
	mux_16_1_1_bit m14(s[0],s[1],s[2],s[3],in0[14],in1[14],in2[14],in3[14],in4[14],in5[14],in6[14],in7[14],in8[14],in9[14],in10[14],in11[14],in12[14],in13[14],in14[14],in15[14],out[14]);
	mux_16_1_1_bit m15(s[0],s[1],s[2],s[3],in0[15],in1[15],in2[15],in3[15],in4[15],in5[15],in6[15],in7[15],in8[15],in9[15],in10[15],in11[15],in12[15],in13[15],in14[15],in15[15],out[15]);
endmodule
