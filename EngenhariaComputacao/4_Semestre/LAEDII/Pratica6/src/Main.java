import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static class Aresta{
        public int v1;
        public int v2;
        public int peso;
        
        public Aresta(int v1,int v2,int peso)
        {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }
    }
  
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        int n;
        System.out.print("Entre com o número do gráfico que deseja analisar:");
        n = ler.nextInt();
        
        File f = new File("test/grafo" + n + ".txt");
        
        Scanner input;
        try {
            input = new Scanner(f);
        } catch (Exception e) {
            System.out.println("Grafo não encontrado ou erro na leitura");
            return;
        }
        
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        
        // Salva vértices do arquivo
        int maxVertice = 0;
        while(input.hasNext())
        {
            String str = input.nextLine();
            StringTokenizer tokens = new StringTokenizer(str);
            if(!tokens.hasMoreElements())
                continue;
            
            int v1 = Integer.parseInt(tokens.nextToken());
            int v2 = Integer.parseInt(tokens.nextToken());
            if (v1>maxVertice) maxVertice = v1;
            if (v2>maxVertice) maxVertice = v2;
            
            Aresta a = new Aresta(v1,v2,Integer.parseInt(tokens.nextToken()));
            
            arestas.add(a);
        }
        
        // Já que os grafos não são direcionados
        JGrafo grafinho = new JGrafo(maxVertice+1);
        // Inserir arestas no grafo
        for (Aresta a : arestas) {
            grafinho.insereAresta(a.v1, a.v2, a.peso);
            grafinho.insereAresta(a.v2, a.v1, a.peso);
        }
        
        JAGM agm = new JAGM(grafinho);
        // Executa busca em profundidade verificando se existe ciclo
        try{
            agm.obterAgm(0);
        } catch(Exception e){
            System.out.println("Problema na inicialização da AGM");
            return;
        } 
        
        agm.imprime();
        System.out.println("Peso da agm: "+agm.pesoTotal());
    } 
}
