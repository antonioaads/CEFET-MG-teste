library verilog;
use verilog.vl_types.all;
entity counter is
    port(
        clock           : in     vl_logic;
        clear           : in     vl_logic;
        \out\           : out    vl_logic_vector(2 downto 0)
    );
end counter;
