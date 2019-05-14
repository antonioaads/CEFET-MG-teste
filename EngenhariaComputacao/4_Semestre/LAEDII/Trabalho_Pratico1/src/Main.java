import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static class Str2bin{

        public static String ch16(String c){
            // Garantir 16 caracteres
            if(c.length()>16)
                c = c.substring(0,15);
            else
                while (c.length()<16)
                    c = c.concat(" ");
            return c;
        }

        public static String bin(String c){
            byte[] bytes = c.getBytes();
            StringBuilder binary = new StringBuilder();
            for (byte b : bytes)
            {
                int val = b;
                for (int i = 0; i < 8; i++)
                {
                    binary.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
                // separar 8 em 8 bits por espaço
//                binary.append(' ');
            }
//            System.out.println("'" + c + "' to binary: " + binary);
            return binary.toString();
        }

        public static String str(String c,int nBitChave){
            String k = new String("");

            for(int i=0; i<nBitChave; i++){
                String str = new String("");
                for(int j=0; j<8; j++){
                    str = str.concat(c.substring(j,j+1));
                }
                byte b = Byte.parseByte(str); // converção implícita
                int val = b;
                char ch = (char)val;
                k = k.concat(Character.toString(ch));
            }

            return k;
        }
    }

    public static void main (String[] args) {
        // escolher arquivo 0 1 2
        String txt = new String("2");

        ArvorePatricia dicionario = new ArvorePatricia (128);
        int min = 32, max = 126;

        // Trata texto
        ExtraiPalavra input;
        try{
            input = new ExtraiPalavra("delim.txt","texto"+txt+".txt");
        }catch (Exception e){
            System.out.println("Erro: arquivo não aberto");
            return;
        }

        // Insere cada chave na arvore
        for (int i = 0;; i++) {
            String c;
            try{
                c = input.proximaPalavra();
                c = Str2bin.ch16(c); // garantir 16 caracteres
            }catch (Exception e){
                break;
            }

            dicionario.insere(new Item(c,input.i,input.j));
            System.out.println ("Inseriu chave "+ i + ": " + c + " - Linha " + input.i + " / Coluna " + input.j);
        }
        System.out.println("");

        // Imprime arvore
        dicionario.imprime ();

        System.out.println("");

        // Pesquisa cada chave na arvore
        File file = new File("pesquisa"+txt+".txt");
        Scanner search_input;
        try{
            search_input = new Scanner(file);
        } catch (Exception e){
            System.out.println("Erro: arquivo de pesquisa não aberto");
            return;
        }

        int i=0;
        while(search_input.hasNext()) {
            String c = search_input.nextLine();
            System.out.println ("Pesquisando chave" + i + ": " + c);
            c = Str2bin.ch16(c);
            dicionario.pesquisa (c);
            i++;
        }

        try{
            input.fecharArquivos();
        } catch (Exception e){
            System.out.println("Erro: não foi possível fechar arquivo");
        }

//        search_input.close();
    }
}
