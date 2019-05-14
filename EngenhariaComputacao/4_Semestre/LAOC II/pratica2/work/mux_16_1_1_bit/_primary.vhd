library verilog;
use verilog.vl_types.all;
entity mux_16_1_1_bit is
    port(
        s3              : in     vl_logic;
        s2              : in     vl_logic;
        s1              : in     vl_logic;
        s0              : in     vl_logic;
        in0             : in     vl_logic;
        in1             : in     vl_logic;
        in2             : in     vl_logic;
        in3             : in     vl_logic;
        in4             : in     vl_logic;
        in5             : in     vl_logic;
        in6             : in     vl_logic;
        in7             : in     vl_logic;
        in8             : in     vl_logic;
        in9             : in     vl_logic;
        in10            : in     vl_logic;
        in11            : in     vl_logic;
        in12            : in     vl_logic;
        in13            : in     vl_logic;
        in14            : in     vl_logic;
        in15            : in     vl_logic;
        \out\           : out    vl_logic
    );
end mux_16_1_1_bit;
