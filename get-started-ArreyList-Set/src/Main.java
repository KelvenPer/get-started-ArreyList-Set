import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Set<Users> usuariosSet = new HashSet<>();
    private static List<Users> usuariosList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            menu();
            int options = scanner.nextInt();
            scanner.nextLine();

            switch (options){
                case 1 :
                    criarUsuario();
                    break;
                case 2 :
                    listaUsuarios();
                    break;
                case 3 :
                    atualizarUsuario();
                    break;
                case 4 :
                    deletarUsuario();
                    break;
                case 5 :
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Opção invalida.");
            }
        }

    }

    public static void menu(){
        System.out.println("\n ==== Menu ====");
        System.out.println("1 - Criar usario");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Atualizar usuario");
        System.out.println("4 - Deletar usuario");
        System.out.println("5 - Sair");
        System.out.println("Opção invalida");
    }

    public static void criarUsuario(){
        System.out.println("Digite o nome do usuario: ");
        String nome = scanner.next();
        scanner.nextLine();

        System.out.println("Digite o ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Users novoUsuario = new Users(id, nome);

        if(usuariosSet.contains(novoUsuario)){
            System.out.println("Ops, Usuario com ID " + id + " ja existente, Escolha outro ID.");
        }else{
            usuariosSet.add(novoUsuario);
            usuariosList.add(novoUsuario);
            System.out.println("Usuario inserido com sucesso.");
        }
    }

    public static void listaUsuarios(){
        if (usuariosList.isEmpty()){
            System.out.println("Nenhum usuario encontrado");
        }else{
            System.out.println("\n Lista de usuarios");
            for (Users usuario : usuariosList){
                System.out.println("ID: " + usuario.getId() + " Nome: "+ usuario.getNome());
            }
        }
    }

    public static void atualizarUsuario(){
        System.out.println("Digite o ID do usuario que desejar atualizar.");
        int id = scanner.nextInt();
        scanner.nextLine();

        Users usuarioParaAtualizar = null;
        for (Users usuario : usuariosList){
            if(usuario.getId() == id){
                usuarioParaAtualizar = usuario;
                break;
            }
        }
        if(usuarioParaAtualizar != null){
           System.out.println("Digite o novo nome: ");
           String novoNome = scanner.nextLine();

           usuariosSet.remove(usuarioParaAtualizar);
           usuarioParaAtualizar.setNome(novoNome);
           usuariosSet.add(usuarioParaAtualizar);

           System.out.println("Usuario atualizado com sucesso");

        } else {
            System.out.println("Usuario com ID : " + id + " nao encontrado");
        }
    }

    public static void deletarUsuario(){
        System.out.println("Digite o ID do usuario que deseja deletar");
        int id = scanner.nextInt();
        scanner.nextLine();

        Users usuarioParaDeletar = null;
        for(Users usuarios : usuariosList){
            if(usuarios.getId() == id) {
                usuarioParaDeletar = usuarios;
                break;
            }
        }
        if (usuarioParaDeletar != null){
            usuariosSet.remove(usuarioParaDeletar);
            usuariosList.remove(usuarioParaDeletar);
            System.out.println("Usuario deletado com sucesso");
        }else {
            System.out.println("Nenhum usuario com ID " + id + " encontrado.");
        }
    }
}