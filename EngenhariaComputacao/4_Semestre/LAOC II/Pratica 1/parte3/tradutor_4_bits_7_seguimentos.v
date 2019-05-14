module tradutor_4_bits_7_seguimentos(data,display);
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