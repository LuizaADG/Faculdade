import java.util.*;
public class Q01 {
    public static void main(String args[]) {
        Scanner scan = new Scanner( System.in );
        boolean pal = true;
        String palindromo = scan.nextLine();
            while(!palindromo.equals("FIM")){
             palindromo = palindromo.replaceAll(" ","");
             palindromo = palindromo.replaceAll(",","");
             String tmp = palindromo.toLowerCase();
             int i=0, j=(palindromo.length()-1);
             while((i<j)&& pal == true){
                 
                 if(tmp.charAt(i)!=tmp.charAt(j)){
                     pal = false;
                     i=j;
                 }else{
                     i++;
                     j--;
                 }
             }
             if(pal == false){
                 System.out.println("NAO");
             }else{
                System.out.println("SIM");
             }
             palindromo = scan.nextLine();
             pal= true;
        }
    }
}