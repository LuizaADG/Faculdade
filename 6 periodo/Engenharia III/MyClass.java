import org.junit.Test;
class Venda {
    // Matriz que guarda, nesta ordem: codigo do produto, quantidade disponivel no estoque, e preço
    static int[][] products = {{0, 40, 5},
            {1, 10, 30},
            {2, 250, 2}};
    public static int receitaTotal = 0;

    public static String fazerVenda(int codProduto, int quant, boolean cpf) {
        int precoVenda = products[codProduto][2];
        if (cpf)
            precoVenda--;

        // Defeito 1: o if abaixo deveria ter >= ao invés de >
        if (products[codProduto][1] > quant) {
            products[codProduto][1] -= quant;
            receitaTotal += products[codProduto][2] * quant; // Defeito 2: total adicionado deveria ser precoVenda, e não o preço original

            if (products[codProduto][1] == 0)
                System.out.println("Estoque do protudo " + codProduto + " vazio");

            return "Registrada venda de " + quant + " #" + codProduto + " por $" + precoVenda;
        }
        else
            return "Nao ha estoque suficiente para realizar esta venda";
    }
}
// Classe driver
public class MyClass {
    public static void main(String args[]) {
      Venda venda = new Venda();
      System.out.println("Venda 1: ");
      System.out.println(venda.fazerVenda(2, 40, false));
      System.out.println("Venda 2: ");
      System.out.println(venda.fazerVenda(0, 39, true));
      System.out.println("Receita total: " + venda.receitaTotal); // O defeito 2 fará com que o valor incorreto seja mostrado
      System.out.println("Venda 3: ");
      System.out.println(venda.fazerVenda(0, 1, true)); // O defeito 1 invalidará esta venda incorretamente
      System.out.println("Venda 4: ");
      System.out.println(venda.fazerVenda(1, -30, false)); // Uma vulnerabilidade na classe fará com que o estoque de itens aumente com esta venda, além de diminuir a receita total
      System.out.println("\nReceita total: " + venda.receitaTotal);
    }
}