
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class grafo{

    public static void main(String[] args) throws FileNotFoundException {
        String pequenog = "C:\\pequenoG.txt";
        String[][] matrizAdj = new String[13][13];
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
       
}
}