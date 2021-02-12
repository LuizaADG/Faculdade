import java.util.*;
public class Q03{
    public static void main(String args[]) {
        Scanner scan = new Scanner( System.in );
        int vertices = scan.nextInt();
        while(vertices!=0){
            //System.out.println(vertices);
            int grafo [][]= new int[vertices][vertices];
            for(int i=0; i< vertices-1; i++){
                for(int j=1; j<vertices;j++){
                    grafo[i][j]=-1;
                }
            }
            for(int i=0;i<vertices-1;i++){
                for(int j=i+1;j<vertices;j++){
                    int aresta = scan.nextInt();
                    if(aresta!=-1){
                        grafo[i][j]=aresta;
                        grafo[j][i]=aresta;
                    }
                }
            }
            boolean euleriano = true;
            int count = 0;
            //  System.out.println("Vertices"+vertices);
            for(int i=0;i<vertices-1;i++){
                for(int j=i+1;j<vertices;j++){
                    if(grafo[i][j]!=-1){
                        count++;
                        //   System.out.println("i:"+i+" j: "+j+" Garfo:"+grafo[i][j]);
                    }
                }
                // System.out.println(count);
            }
            if(count%2!=0){
                euleriano=false;
            }
            if(euleriano){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            vertices = scan.nextInt();
        }
    }
}