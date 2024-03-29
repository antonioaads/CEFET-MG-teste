onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -radix unsigned /ula/in0
add wave -noupdate -radix unsigned /ula/in1
add wave -noupdate -radix unsigned /ula/op
add wave -noupdate -radix decimal /ula/out
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {73 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 150
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
WaveRestoreZoom {364 ps} {1034 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern constant -value 11 -range 15 0 -starttime 0ps -endtime 1000ps sim:/ula/in0 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 101 -range 15 0 -starttime 0ps -endtime 1000ps sim:/ula/in1 
WaveExpandAll -1
wave create -driver freeze -pattern counter -startvalue 000 -endvalue 110 -type Range -direction Up -period 50ps -step 1 -repeat forever -range 2 0 -starttime 0ps -endtime 1000ps sim:/ula/op 
WaveExpandAll -1
WaveCollapseAll -1
wave clipboard restore
