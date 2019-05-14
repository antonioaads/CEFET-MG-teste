library verilog;
use verilog.vl_types.all;
entity registrador_16bits is
    port(
        clock           : in     vl_logic;
        enable          : in     vl_logic;
        din             : in     vl_logic_vector(15 downto 0);
        dout            : out    vl_logic_vector(15 downto 0)
    );
end registrador_16bits;
