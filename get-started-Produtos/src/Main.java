import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Set<Produtos> produtosSet = new HashSet<>();
    private static List<Produtos> produtosList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            menu();
            int option = scanner.nextInt();

            switch (option){
                case 1 :
                    criarProduto();
                    break;
                case 2 :
                    listarProduto();
                    break;
                case 3 :
                    deletarProduto();
                    break;
                case 4 :
                    alterarProduto();
                    break;
                case 5:
                    System.out.println("Saindo do sistema");
                    scanner.close();
                default:
                    System.out.println("Opção invalida");
            }
        }

    }
    public static void menu(){
        System.out.println("===== Menu =====");
        System.out.println("1 - cadastrar produto");
        System.out.println("2 - listar produtos");
        System.out.println("3 - excluir produto");
        System.out.println("4 - alterar produto");
        System.out.println("5 - Sair");
        System.out.println("Opção invalida");
    }




    public static void criarProduto(){
        System.out.println("Qual ID do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual o nome do produto: ");
        String nome = scanner.next();
        scanner.nextLine();

        Produtos criarProduto = new Produtos(codigo, nome);

        if(produtosSet.contains(criarProduto)){
            System.out.println("Produto com o CODIGO " + codigo + " já existente");
        }else {
            produtosSet.add(criarProduto);
            produtosList.add(criarProduto);
            System.out.println("Produto cadastrado com sucesso");
        }
    }

    public static void listarProduto(){
        if(produtosList.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
        }else{
            System.out.println("\n Lista de produtos ");
            for(Produtos produto : produtosList){
                System.out.println("Codigo: " + produto.getCodigo() + ", Nome: " + produto.getNome());
            }
        }
    }

    public static void deletarProduto(){
        System.out.println("Digite o codigo do produto para DELETAR");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produtos deletarProdutos = null;
        for(Produtos produto : produtosList){
            if(produto.getCodigo() == codigo){
                deletarProdutos = produto;
                break;
            }
        }
        if(deletarProdutos != null){
            produtosList.remove(deletarProdutos);
            produtosSet.remove(deletarProdutos);
            System.out.println("Produto deletado com sucesso");
        }else{
            System.out.println("Codigo nao encontrato");
        }
    }

    public static void alterarProduto(){
        System.out.println("Digite o codigo do produto que deseja alterar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produtos alterarProduto = null;
        for(Produtos produto : produtosList){
            if(produto.getCodigo() == codigo){
                alterarProduto = produto;
                break;
            }
        }
        if(alterarProduto != null){
            System.out.println("Digite o novo nome do produto");
            String novoNome = scanner.nextLine();

            produtosSet.remove(produtosList);
            alterarProduto.setNome(novoNome);
            produtosSet.add(alterarProduto);

            System.out.println("Produto alterado com sucesso");
        }else{
            System.out.println("Produto com o codigo " + codigo + " nao encontrado");
        }
    }
}