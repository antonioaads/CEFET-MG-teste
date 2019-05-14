import java.util.ArrayList;

public class JCiclo {
    public static final byte branco = 0;
    public static final byte cinza  = 1;
    public static final byte preto  = 2;
    private int d[], t[], antecessor[];
    private JGrafo grafo;
    private boolean ciclo;
    private ArrayList<Integer> caminho;

    public JCiclo (JGrafo grafo) {
        this.grafo = grafo; int n = this.grafo.numVertices();
        d = new int[n]; t = new int[n]; antecessor = new int[n]; ciclo = false;
    }

    private int visitaDfs (int u, int tempo, int cor[]) {
        caminho.add(u);
        cor[u] = cinza; this.d[u] = ++tempo;
        
        if (!this.grafo.listaAdjVazia (u)) {
            JGrafo.Aresta a = this.grafo.primeiroListaAdj (u);
            
            while (a != null) {
                // analisa se o vértice de destino já foi visitado
                for (int i: caminho){if(i==a.v2()) this.ciclo=true;}
          
                int v = a.v2 ();
                if (cor[v] == branco) {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs (v, tempo, cor);
                }
                a = this.grafo.proxAdj (u);
            }
        }
        
        cor[u] = preto; this.t[u] = ++tempo;

        caminho.remove(caminho.size()-1);
        return tempo;
    }

    public void buscaEmProfundidade () {
        int tempo = 0; int cor[] = new int[this.grafo.numVertices ()]; 

        // Zera o estado de todos os vértices
        for (int u = 0; u < grafo.numVertices (); u++) {
            cor[u] = branco; this.antecessor[u] = -1;
        }

        // Faz a busca por profundidade para cada vértice
        for (int u = 0; u < grafo.numVertices (); u++){
            this.caminho = new ArrayList<Integer>();
            if (cor[u] == branco) {
                tempo = this.visitaDfs (u, tempo, cor);
            }
        }
    }
    
    //retorna a variável ciclo para saber se ouve ou não ciclo
    public boolean temCiclo() { return this.ciclo; } 

    public int d (int v) { return this.d[v]; }
    public int t (int v) { return this.t[v]; }
    public int antecessor (int v) { return this.antecessor[v]; }
}