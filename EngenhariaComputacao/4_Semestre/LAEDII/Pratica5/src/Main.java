import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    //Classe para vértice
    private static class Vertice{
        public int vertice;
        public ArrayList<Integer> vizinhos;

        public Vertice(int v) {
            vertice = v;
            vizinhos = new ArrayList<Integer>();
        }
        
        public void addVizinho(int v){
            vizinhos.add(v);
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
        
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        
        // Código para ler e armazenar os vértices e seus vizinhos
        while(input.hasNext())
        {
            String str = input.nextLine();
            StringTokenizer tokens = new StringTokenizer(str);
            if(!tokens.hasMoreElements()) //olha se tem mais itens
                continue;
            
            Vertice v = new Vertice(Integer.parseInt(tokens.nextToken()));
            
            while(tokens.hasMoreTokens())
                v.addVizinho(Integer.parseInt(tokens.nextToken()));
        
            vertices.add(v);
        }
        
        JGrafo grafo = new JGrafo(vertices.size());
        // Inserindo no grafo
        for (Vertice v : vertices) {
            for(int vizinho : v.vizinhos) {grafo.insereAresta(v.vertice, vizinho, 1);}
        }
        
        JCiclo busca_de_ciclo = new JCiclo(grafo);
        // Executa a busca
        busca_de_ciclo.buscaEmProfundidade();
        
        //Analisa se ouve ciclo
        if(busca_de_ciclo.temCiclo() == false){
            System.out.println("Nao possui ciclo");
        }
        else{
            System.out.println("Possui ciclo");
        }
    }
}