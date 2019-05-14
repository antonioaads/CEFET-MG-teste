module ula(op,in0,in1,out);
	input [15:0]in0, in1;
	input [2:0]op; //Olhar certinho ainda
	output [15:0]out;
	
	wire[15:0]add,sub,slt,sll,srl,ou;
	
	assign add = in0 + in1;
	assign sub = in0 - in1;
	assign sll = in0 << in1;
	assign srl = in0 >> in1;
	assign ou = in0 | in1;
	assign slt = sub[15];
	
	mux_ula m(op,add,sub,sll,srl,ou,slt,slt,slt,out);
	
endmodule

module mux_ula(s,in0,in1,in2,in3,in4,in5,in6,in7,out);

  input [2:0]s;
  input [15:0]in0,in1,in2,in3,in4,in5,in6,in7;
  output [15:0]out;
  
  mux_8_1_1_bit m0(s[0],s[1],s[2],in0[0],in1[0],in2[0],in3[0],in4[0],in5[0],in6[0],in7[0],out[0]);
	mux_8_1_1_bit m1(s[0],s[1],s[2],in0[1],in1[1],in2[1],in3[1],in4[1],in5[1],in6[1],in7[1],out[1]);
	mux_8_1_1_bit m2(s[0],s[1],s[2],in0[2],in1[2],in2[2],in3[2],in4[2],in5[2],in6[2],in7[2],out[2]);
	mux_8_1_1_bit m3(s[0],s[1],s[2],in0[3],in1[3],in2[3],in3[3],in4[3],in5[3],in6[3],in7[3],out[3]);
	mux_8_1_1_bit m4(s[0],s[1],s[2],in0[4],in1[4],in2[4],in3[4],in4[4],in5[4],in6[4],in7[4],out[4]);
	mux_8_1_1_bit m5(s[0],s[1],s[2],in0[5],in1[5],in2[5],in3[5],in4[5],in5[5],in6[5],in7[5],out[5]);
	mux_8_1_1_bit m6(s[0],s[1],s[2],in0[6],in1[6],in2[6],in3[6],in4[6],in5[6],in6[6],in7[6],out[6]);
	mux_8_1_1_bit m7(s[0],s[1],s[2],in0[7],in1[7],in2[7],in3[7],in4[7],in5[7],in6[7],in7[7],out[7]);
	mux_8_1_1_bit m8(s[0],s[1],s[2],in0[8],in1[8],in2[8],in3[8],in4[8],in5[8],in6[8],in7[8],out[8]);
	mux_8_1_1_bit m9(s[0],s[1],s[2],in0[9],in1[9],in2[9],in3[9],in4[9],in5[9],in6[9],in7[9],out[9]);
	mux_8_1_1_bit m10(s[0],s[1],s[2],in0[10],in1[10],in2[10],in3[10],in4[10],in5[10],in6[10],in7[10],out[10]);
	mux_8_1_1_bit m11(s[0],s[1],s[2],in0[11],in1[11],in2[11],in3[11],in4[11],in5[11],in6[11],in7[11],out[11]);
	mux_8_1_1_bit m12(s[0],s[1],s[2],in0[12],in1[12],in2[12],in3[12],in4[12],in5[12],in6[12],in7[12],out[12]);
	mux_8_1_1_bit m13(s[0],s[1],s[2],in0[13],in1[13],in2[13],in3[13],in4[13],in5[13],in6[13],in7[13],out[13]);
	mux_8_1_1_bit m14(s[0],s[1],s[2],in0[14],in1[14],in2[14],in3[14],in4[14],in5[14],in6[14],in7[14],out[14]);
	mux_8_1_1_bit m15(s[0],s[1],s[2],in0[15],in1[15],in2[15],in3[15],in4[15],in5[15],in6[15],in7[15],out[15]);
	
endmodule

module mux_8_1_1_bit(s2,s1,s0,in0,in1,in2,in3,in4,in5,in6,in7,out);
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
