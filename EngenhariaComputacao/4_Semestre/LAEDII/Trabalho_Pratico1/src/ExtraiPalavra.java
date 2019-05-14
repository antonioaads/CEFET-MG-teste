import java.util.StringTokenizer;
import java.io.*;
public class ExtraiPalavra {
    private BufferedReader arqDelim, arqTxt;
    private StringTokenizer palavras;
    private String delimitadores;
    public int i;
    public int j;

    public ExtraiPalavra (String nomeArqDelim, String nomeArqTxt)
            throws Exception {
        this.arqDelim = new BufferedReader (new FileReader (nomeArqDelim));
        this.arqTxt = new BufferedReader (new FileReader (nomeArqTxt));
        // @{\it Os delimitadores devem estar juntos em uma \'unica linha do arquivo}@
        this.delimitadores = arqDelim.readLine() + "\r\n";
        this.palavras = null;
        this.i=0;
        this.j=0;
    }

    public String proximaPalavra () throws Exception{
        if (palavras == null || !palavras.hasMoreTokens()) {
            String linha = arqTxt.readLine(); i++; j=0;
            if (linha == null) return null;
            this.palavras = new StringTokenizer (linha, this.delimitadores);
            if (!palavras.hasMoreTokens()) return ""; // ignora delimitadores
        }
        j++;
        return this.palavras.nextToken ();
    }
    public void fecharArquivos () throws Exception {
        this.arqDelim.close();
        this.arqTxt.close();
    }
}