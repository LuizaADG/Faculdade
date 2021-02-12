import java.util.*;
public class Q02 {
    public static void main(String args[]) {
        Scanner scan = new Scanner( System.in );
        List<String> frases = new ArrayList<String>();
        String frase = scan.nextLine();
       while(!frase.equals("FIM")){
             frases.add(frase);
             //String tmp = frase.toLowerCase();
         frase = scan.nextLine();
        }
        Collections.sort(frases);
        //frases.sort(Comparator.comparing(Object::toString));
        Iterator i = frases.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}