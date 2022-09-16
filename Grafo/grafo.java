
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class grafo{


    public static void BFS(String[][] matriz, int vertice, String[]listaCor, String[]listaDis, String[]listaAnte, Queue filaQ){

        listaCor[vertice] = "Cinza"; 
        listaDis[vertice] = "0";

        filaQ.enqueue(vertice);

        while(!filaQ.isEmpty()){

            int newVert = filaQ.dequeue();

            String u = Integer.toString(newVert);

            for (int i = 0; i < matriz.length; i++) { 

                if(matriz[newVert][i] == "1"){

                    if(listaCor[i] == "Branco"){

                    listaCor[i] = "Cinza";
                    listaDis[i] = listaDis[newVert]+1;
                    listaAnte[i] = u;
                    
                    filaQ.enqueue(i);

                    }
                }
            }

            listaCor[newVert] = "Preto";

        }
    }


    public static void printPath(String[] listaAnte, int vertice){      // menor caminho entre vertice solicitado e vertice 0 
        String s = "0";
        String v = Integer.toString(vertice);

        if(v == s){
            System.out.println(s);
        } else {

            if(listaAnte[vertice] == "null"){
                System.out.println("Não há caminho.");
            } else {
                String cambio = listaAnte[vertice];
                int verticeanterior = Integer.parseInt(cambio);
                printPath(listaAnte, verticeanterior);
                System.out.println(vertice);
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        String pequenog = "C:\\pequenoG.txt";
        String[][] matrizAdj = new String[13][13];
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileReader(pequenog)).useDelimiter("\\s+|\\n");
        String Vtotal = scanner.next(); //vertices totais 13 - ordem
        String Atotal = scanner.next(); //arestas totais 13 - tamanho
        int contEnt=0; //
        int contSaida=0;
        int contIsolados = 0;
        int contExt = 0;

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

        System.out.println("Graus de entrada e saída: ");

        for(int x = 0; x < matrizAdj.length; x++){
            for(int y = 0; y < matrizAdj[0].length; y++){

                if(matrizAdj[y][x].equals("1")){
                    contEnt++;
                }

                if(matrizAdj[x][y].equals("1")){
                    contSaida++;
                }
            }

            if(contEnt == 0 && contSaida == 0){ //vert isolado
                System.out.println("Vértice (" + x + ") é isolado");
                contIsolados++;
            }

            if(contSaida == 0){    //vert de extremidade
                contExt++;
            }

            System.out.println("Vértice (" + x + ") é igual a: " + contEnt +" / "+ contSaida);
            
            contEnt = 0;
            contSaida = 0;
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("ordem = "+ Vtotal);
        System.out.println("tamanho = "+ Atotal);
        System.out.println("Número de vertices isolados = " + contIsolados);
        System.out.println("Número de vertices de extremidade = " + contExt);

        //Ativ 03:

        String[] listaCor = new String[13];     //Lista referente as cores

        for (int i = 0; i < listaCor.length; i++)   //Inicializando lista com todos vertices em branco
        {
            listaCor[i] = "Branco";
        }


        String[] listaDistancia = new String[13];     //Lista referente a distancia

        for (int i = 0; i < listaDistancia.length; i++)   //Inicializando lista com todos vertices com distancia ∞
        {
            listaDistancia[i] = "∞";
        }

        
        String[] listaAnte = new String[13];     //Lista referente aos vértices anteriores

        for (int i = 0; i < listaAnte.length; i++)   //Inicializando lista com todos vertices anteriores sendo null
        {
            listaAnte[i] = "null";
        }

        Queue filaQ = new Queue(13);
        
        System.out.println("Informe o Vértice que deseja visualizar: ");
        int vertice = scan.nextInt();

        BFS(matrizAdj,vertice,listaCor,listaDistancia,listaAnte,filaQ);
        printPath(listaAnte, vertice);

       
}
}