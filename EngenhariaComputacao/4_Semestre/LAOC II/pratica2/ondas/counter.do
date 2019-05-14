onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /counter/clock
add wave -noupdate /counter/clear
add wave -noupdate -radix unsigned /counter/out
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {0 ps} 0}
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
WaveRestoreZoom {0 ps} {1036 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue HiZ -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/counter/clock 
wave modify -driver freeze -pattern clock -initialvalue 0 -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/counter/clock 
wave create -driver freeze -pattern constant -value 0 -starttime 0ps -endtime 1000ps sim:/counter/clear 
wave modify -driver freeze -pattern constant -value 1 -starttime 500ps -endtime 700ps Edit:/counter/clear 
wave modify -driver freeze -pattern constant -value St1 -starttime 0ps -endtime 30ps Edit:/counter/clear 
WaveCollapseAll -1
wave clipboard restore
