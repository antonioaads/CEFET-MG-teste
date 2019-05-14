onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /ram_2_port/clock
add wave -noupdate /ram_2_port/wren
add wave -noupdate -radix decimal /ram_2_port/data
add wave -noupdate -radix decimal /ram_2_port/wraddress
add wave -noupdate -radix decimal /ram_2_port/rdaddress
add wave -noupdate -radix decimal /ram_2_port/q
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {0 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 187
configure wave -valuecolwidth 53
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
wave create -driver freeze -pattern clock -initialvalue HiZ -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/ram_2_port/clock 
wave modify -driver freeze -pattern clock -initialvalue 0 -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/ram_2_port/clock 
wave create -driver freeze -pattern constant -value 0 -range 7 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/data 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 0 -range 4 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/wraddress 
WaveExpandAll -1
wave create -driver freeze -pattern counter -startvalue 00000 -endvalue 00011 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/rdaddress 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/wren 
wave modify -driver freeze -pattern counter -startvalue 00000 -endvalue 00011 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 300ps -endtime 1000ps Edit:/ram_2_port/wraddress 
wave modify -driver freeze -pattern counter -startvalue 11111111 -endvalue 0 -type Range -direction Down -period 50ps -step 1 -repeat forever -range 7 0 -starttime 300ps -endtime 1000ps Edit:/ram_2_port/data 
wave modify -driver freeze -pattern counter -startvalue 100 -endvalue 11111111 -type Range -direction Up -period 50ps -step 1 -repeat forever -range 7 0 -starttime 300ps -endtime 1000ps Edit:/ram_2_port/data 
wave modify -driver freeze -pattern counter -startvalue 00000100 -endvalue 11111111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 7 0 -starttime 300ps -endtime 1000ps Edit:/ram_2_port/data 
wave modify -driver freeze -pattern constant -value St1 -starttime 300ps -endtime 1000ps Edit:/ram_2_port/wren 
WaveCollapseAll -1
wave clipboard restore
