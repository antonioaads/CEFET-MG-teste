onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -radix unsigned /mux_16_1_16_bit/s
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in0
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in1
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in2
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in3
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in4
add wave -noupdate -radix unsigned /mux_16_1_16_bit/in5
add wave -noupdate -radix unsigned /mux_16_1_16_bit/out
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {309 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 180
configure wave -valuecolwidth 100
configure wave -justifyvalue left
configure wave -signalnamewidth 0
configure wave -snapdistance 10
configure wave -datasetprefix 0
configure wave -rowmargin 4
configure wave -childrowmargin 2
configure wave -gridoffset 0
configure wave -gridperiod 1
configure wave -griddelta 40
configure wave -timeline 0
configure wave -timelineunits ps
update
WaveRestoreZoom {0 ps} {288 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern counter -startvalue 0000 -endvalue 1111 -type Range -direction Up -period 50ps -step 1 -repeat forever -range 3 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/s 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 0 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in0 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 1 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in1 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 10 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in2 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 11 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in3 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 100 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in4 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 101 -range 15 0 -starttime 0ps -endtime 1000ps sim:/mux_16_1_16_bit/in5 
WaveExpandAll -1
WaveCollapseAll -1
wave clipboard restore
