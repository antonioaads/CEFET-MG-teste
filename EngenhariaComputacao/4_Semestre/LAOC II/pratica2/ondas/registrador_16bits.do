onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /registrador_16bits/clock
add wave -noupdate /registrador_16bits/enable
add wave -noupdate -radix decimal /registrador_16bits/din
add wave -noupdate -radix decimal /registrador_16bits/dout
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {740 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 199
configure wave -valuecolwidth 52
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
WaveRestoreZoom {0 ps} {825 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue HiZ -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/registrador_16bits/clock 
wave create -driver freeze -pattern constant -value 1 -starttime 0ps -endtime 1000ps sim:/registrador_16bits/enable 
wave create -driver freeze -pattern counter -startvalue 0000000000000000 -endvalue 1111111111111111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 15 0 -starttime 0ps -endtime 1000ps sim:/registrador_16bits/din 
WaveExpandAll -1
wave modify -driver freeze -pattern constant -value St0 -starttime 235ps -endtime 500ps Edit:/registrador_16bits/enable 
wave modify -driver freeze -pattern constant -value St1 -starttime 450ps -endtime 500ps Edit:/registrador_16bits/enable 
WaveCollapseAll -1
wave clipboard restore
