import java.util.Scanner;
public class Lista03_7
{
   public static void main(String[]args)
   {
      int a,
          r,
          n=1,
          t,
          b;
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o primeiro termo da PA");
		a=s.nextInt();
		System.out.println("Digite a razão");
		r=s.nextInt();
		System.out.println("Digite o número de termos");
		b=s.nextInt();
		while(b!=n-1)
		{
			t=(a+(n-1)*r);
			n=n+1;
			System.out.println(t);
		}

    }     
}                   