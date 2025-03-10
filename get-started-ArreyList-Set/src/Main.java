/*
 * length : mostra o tamanho do arrey usa dento do sout
 * List<Tipagem> : lista sempre deve ser tipada ou seja definir o objeto que vamos trabalho, 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
         * String - names
         * int - codigos 
         * 
         * depois mapiamos os nomes e os codigo usando uma nova classe pessoas e usamos o HashMap
         * depois utilizamos o for para listar as pessoas e usamos o pessoas.put() para adicionar no [i] os codigos e os nomes
         * depois usamos o forEach com os parametros e assim retornamos o sout
         * contains : verifica se tem certo tipo de dados dentro da lista 
         */

 /* 
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User(1, "Kelven"));

        System.out.println(usuarios); // lista os usuarios conforme toString definido na classe
        System.out.println(usuarios.isEmpty()); // verifica se a lista esta vazia
        System.out.println(usuarios.contains(new User(1, "Kelven"))); // verifica se o novo usuario que queremos cadastra contem na lista

        usuarios.clear(); // limpa a lista existe
        System.out.println("Limpando lista"); // mostra msg que estamos limpando a lista

        System.out.println(usuarios); // lista vazia
         */
        List<User> usuarios = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int opecao;

            do {
                System.out.println("\n ======= Menu =======");
                System.out.println("1 - Cadastrar usuario");
                System.out.println("2 - Listar usuarios");
                System.out.println("3 - Atualizar usuarios");
                System.out.println("4 - Remover usuarios");
                System.out.println("0 - Sair");
                System.out.println("Escolha uma opção");
                opecao = scanner.nextInt();
                scanner.nextLine();

                switch (opecao) {
                    case 1 -> {
                        System.out.println("Digite o codigo: ");
                        int code = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o codigo: ");
                        String name = scanner.nextLine();
                        User newUser = new User(code, name);
                        usuarios.add(newUser);
                        System.out.println("Usuario cadastrado com sucesso");
                    }
                    case 2 -> {
                        System.out.println("\n Listando usuarios");
                        usuarios.forEach(System.out::print);
                    }
                    case 3 -> {
                        System.out.println("Digite o codigo do usuario que deseja mudar: ");
                        int seachCode = scanner.nextInt();
                        scanner.nextLine();
                        User found = null;
                        for (User user : usuarios) {
                            if (user.getCode() == seachCode) {
                                found = user;
                                break;
                            }
                        }

                        if (found != null) {
                            System.out.println("Digite o novo nome: ");
                            String newName = scanner.nextLine();
                            found.setName(newName);
                            System.out.println("Usuário atualizado com sucesso!");
                        } else {
                            System.out.println("Usuario nao econtrado");
                        }
                    }

                    case 4 -> {
                        System.out.println("Digite o codigo que deseja remover: ");
                        int removerCode = scanner.nextInt();
                        scanner.nextLine();
                        usuarios.removeIf(users -> users.getCode() == removerCode);
                        System.out.println("Usuario removido com sucesso");
                    }
                    case 0 ->
                        System.out.println("Saindo...");
                    default ->
                        System.out.println("Opção invalida");
                }
            } while (opecao != 0);
        }
    }
}
