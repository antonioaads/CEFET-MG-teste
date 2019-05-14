transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Antonio/Documents/4_semestre/LAOC\ II/pratica1/parte2 {C:/Users/Antonio/Documents/4_semestre/LAOC II/pratica1/parte2/top_parte2.v}
vlog -vlog01compat -work work +incdir+C:/Users/Antonio/Documents/4_semestre/LAOC\ II/pratica1/parte2 {C:/Users/Antonio/Documents/4_semestre/LAOC II/pratica1/parte2/ram_2_port.v}

