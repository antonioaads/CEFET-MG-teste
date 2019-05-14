onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /control_unit/counter
add wave -noupdate /control_unit/ir
add wave -noupdate /control_unit/mux_control
add wave -noupdate /control_unit/a_act
add wave -noupdate /control_unit/g_act
add wave -noupdate /control_unit/r_act
add wave -noupdate /control_unit/addsub
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {9 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 167
configure wave -valuecolwidth 68
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
WaveRestoreZoom {0 ps} {384 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern counter -startvalue 000 -endvalue 111 -type Range -direction Up -period 50ps -step 1 -repeat forever -range 2 0 -starttime 0ps -endtime 500ps sim:/control_unit/counter 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 0000001010 -range 9 0 -starttime 0ps -endtime 500ps sim:/control_unit/ir 
WaveExpandAll -1
WaveCollapseAll -1
wave clipboard restore
