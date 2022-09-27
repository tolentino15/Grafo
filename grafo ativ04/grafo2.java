import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class grafo2 {

    static String[] listaCor = new String[13];  //Lista referente as cores
    static int[] listaDistancia = new int[13]; //Lista referente a distancia
    static int[] listaAnte = new int[13]; //Lista referente aos vértices anteriores
    static int tempo = 1;

    static void inicializa(String v,String[][] matrizAdj){
 

        for (int i = 0; i < listaCor.length; i++)   //Inicializando lista com todos vertices em branco
        {
            listaCor[i] = "Branco";
        }
       

        for (int i = 0; i < listaDistancia.length; i++)   //Inicializando lista com todos vertices com distancia -1
        {
            listaDistancia[i] = -1;
        }
 

        for (int i = 0; i < listaAnte.length; i++)   //Inicializando lista com todos vertices anteriores sendo null
        {
            listaAnte[i] = 0;
        }

        int h = Integer.parseInt(v);
        listaAnte[h] = -1;
        

        DFS(matrizAdj,v);

    }


    static void DFS(String[][] matrizAdj,String u){

        System.out.print(u + " / ");

        int vert = Integer.parseInt(u);

        listaCor[vert] = "cinza";
        listaDistancia[vert] = tempo++;

        for (int i = 0; i < matrizAdj[vert].length; i++){

            if(matrizAdj[i][vert] == "1" && listaCor[i] == "Branco"){
                String i2 = Integer.toString(i);
                listaAnte[i] = vert; 
                DFS(matrizAdj,i2);
            } 

        }

        listaCor[vert] = "Preto";
        listaDistancia[vert] = tempo++;
       
    }


    public static void main(String[] args) throws FileNotFoundException {
        String pequenog = "C:\\pequenoG.txt";
        String[][] matrizAdj = new String[13][13];
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileReader(pequenog)).useDelimiter("\\s+|\\n");
        String Vtotal = scanner.next(); //vertices totais 13 - ordem
        String Atotal = scanner.next(); //arestas totais 13 - tamanho
       

        //Preencher matriz com 0
        for( int linha = 0; linha < matrizAdj.length; linha++) {
            for( int coluna = 0; coluna < matrizAdj[linha].length; coluna++) {
                    matrizAdj[linha][coluna] = "0";
            }
        }

        //Preencher matriz com 1 nas posições onde houver aresta
        //linha ---(aresta)---> coluna
        while(scanner.hasNext()){
            
            String vert1 = scanner.next();
            String vert2 = scanner.next();
            int linhav = Integer.parseInt(vert1);
            int colunav= Integer.parseInt(vert2);

            matrizAdj[linhav][colunav] = "1";
            matrizAdj[colunav][linhav] = "1";
        }   

        System.out.println("Matriz de Adjacência: ");

        //Imprimindo Matriz
        for (int l = 0; l < matrizAdj.length; l++)  {  
            for (int c = 0; c < matrizAdj[0].length; c++)     { 
                System.out.print(matrizAdj[l][c] + " "); 
            }  
            System.out.println(" "); 
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("ordem = "+ Vtotal);
        System.out.println("tamanho = "+ Atotal);

        //Ativ 03/04:

        
        System.out.println("Informe o Vértice que deseja visualizar: ");
        String vertice = scan.nextLine();


        inicializa(vertice,matrizAdj);


}
}


