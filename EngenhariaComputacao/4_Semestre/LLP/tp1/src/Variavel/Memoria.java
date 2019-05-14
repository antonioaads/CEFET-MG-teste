package Variavel;

public class Memoria{

    public double[] var;
    public boolean[] var_state;

    public Memoria(){
        var = new double[26];
        var_state = new boolean[26];
        for (int i =0; i<26; i++) {
            var_state[i] = false;
            var[i] = -1;
        } 
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i =0; i<26; i++) {
            sb.append("[").append( i ).append("] = ").append(var[i]).append("\n");
        } 

        return sb.toString( );
    }	
}