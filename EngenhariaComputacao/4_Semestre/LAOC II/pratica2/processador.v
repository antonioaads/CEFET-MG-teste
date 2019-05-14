module processorChomps4UltraMax(clock,din,resetn,run,addr,dout,w,done);
	input clock,resetn,run;
	input [15:0]din;
	output w,done;
	output [15:0]addr,dout;

	wire [9:0]ir;
	wire [3:0]mux_control;
	wire ir_act,incr_pc,a_act,g_act,addr_act,dout_act,w_d,counter_run,counter_clear;
	wire [2:0]addsub;
	wire [7:0]r_act;
	wire [2:0]counter_out;
	wire [15:0]bus;
	wire empty;
	assign empty=0;
	wire [15:0]dout_a,dout_g,dout_ula;
	wire [15:0]dout_r0,dout_r1,dout_r2,dout_r3,dout_r4,dout_r5,dout_r6,dout_r7;

	// IR
		registrador_16bits rir(clock,ir_act,din[15:6], ir);

	// Control_unit

		counter count(clock,counter_run,counter_clear,counter_out);
		control_unit ctrl_unit(run,resetn,counter_out,counter_clear,counter_run,
								ir[9:0],ir_act,mux_control,done,r_act,a_act,g_act,
								addr_act,dout_act,w_d,addsub,incr_pc);

	// Registradores
		registrador_16bits r0(clock,r_act[0], bus, dout_r0);
		registrador_16bits r1(clock,r_act[1], bus, dout_r1);
		registrador_16bits r2(clock,r_act[2], bus, dout_r2);
		registrador_16bits r3(clock,r_act[3], bus, dout_r3);
		registrador_16bits r4(clock,r_act[4], bus, dout_r4);
		registrador_16bits r5(clock,r_act[5], bus, dout_r5);
		registrador_16bits r6(clock,r_act[6], bus, dout_r6);
		regPC_16bits rpc(clock, incr_pc, r_act[7], bus, dout_r7);

	// MUX
		
		
		mux_16_1_16_bit mux(mux_control,dout_r0,dout_r1,dout_r2,dout_r3,dout_r4,dout_r5,dout_r6,dout_r7,
								dout_g,{7'b0000000,din[8:0]},empty,empty,empty,empty,empty,empty,bus);

	// ULA / A / G
		registrador_16bits ra(clock,a_act, bus, dout_a);
		ula_16bits ula(addsub,dout_a,bus,dout_ula);
		registrador_16bits rg(clock,g_act, dout_ula, dout_g);

	// Memória - ADDR / DOUT / W
		registrador_16bits raddr(clock,addr_act, bus, addr);
		registrador_16bits rdout(clock,dout_act, bus, dout);
		

		registrador_16bits rw(clock, 1, w_d, w);


endmodule