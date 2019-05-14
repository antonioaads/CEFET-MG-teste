onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /ram_2_port/clock
add wave -noupdate -radix decimal /ram_2_port/data
add wave -noupdate -radix decimal /ram_2_port/wraddress
add wave -noupdate /ram_2_port/wren
add wave -noupdate -radix decimal /ram_2_port/rdaddress
add wave -noupdate -radix decimal /ram_2_port/q
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {35 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 208
configure wave -valuecolwidth 47
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
WaveRestoreZoom {0 ps} {996 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue HiZ -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/ram_2_port/clock 
wave create -driver freeze -pattern counter -startvalue 00000000 -endvalue 11111111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 7 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/data 
WaveExpandAll -1
wave modify -driver freeze -pattern clock -initialvalue 0 -period 50ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/ram_2_port/clock 
wave modify -driver freeze -pattern clock -initialvalue 0 -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/ram_2_port/clock 
wave create -driver freeze -pattern counter -startvalue 00000 -endvalue 11111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 0ps -endtime 1000ps sim:/ram_2_port/wraddress 
WaveExpandAll -1
wave create -driver freeze -pattern constant -value 1 -starttime 0ps -endtime 1000ps sim:/ram_2_port/wren 
wave create -driver freeze -pattern counter -startvalue 00000 -endvalue 11111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 100ps -endtime 1000ps sim:/ram_2_port/rdaddress 
WaveExpandAll -1
wave modify -driver freeze -pattern constant -value 0 -starttime 510ps -endtime 610ps Edit:/ram_2_port/clock 
wave modify -driver freeze -pattern counter -startvalue 00000000 -endvalue 11111111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 7 0 -starttime 500ps -endtime 1000ps Edit:/ram_2_port/data 
wave modify -driver freeze -pattern constant -value 0 -starttime 625ps -endtime 675ps Edit:/ram_2_port/wren 
wave modify -driver freeze -pattern constant -value z -range 4 0 -starttime 0ps -endtime 150ps Edit:/ram_2_port/rdaddress 
wave modify -driver freeze -pattern constant -value 0 -range 4 0 -starttime 0ps -endtime 150ps Edit:/ram_2_port/rdaddress 
wave modify -driver freeze -pattern counter -startvalue 00000000 -endvalue 11111111 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 7 0 -starttime 0ps -endtime 1000ps Edit:/ram_2_port/data 
wave modify -driver freeze -pattern counter -startvalue 00000 -endvalue 00011 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 0ps -endtime 1000ps Edit:/ram_2_port/wraddress 
wave modify -driver freeze -pattern constant -value 0 -starttime 420ps -endtime 550ps Edit:/ram_2_port/clock 
wave modify -driver freeze -pattern constant -value St0 -starttime 420ps -endtime 550ps Edit:/ram_2_port/clock 
wave modify -driver freeze -pattern constant -value St1 -starttime 550ps -endtime 600ps Edit:/ram_2_port/clock 
wave modify -driver freeze -pattern counter -startvalue 00000 -endvalue 00011 -type Range -direction Up -period 50ps -step 1 -repeat forever -range 4 0 -starttime 500ps -endtime 1000ps Edit:/ram_2_port/rdaddress 
wave modify -driver freeze -pattern counter -startvalue 00000 -endvalue 00011 -type Range -direction Up -period 100ps -step 1 -repeat forever -range 4 0 -starttime 500ps -endtime 1000ps Edit:/ram_2_port/rdaddress 
WaveCollapseAll -1
wave clipboard restore
