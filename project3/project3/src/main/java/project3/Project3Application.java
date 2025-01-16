package project3;

import dto.*;
import entity.*;
import service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class Project3Application implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private JoiaService joiaService;

    @Autowired
    private PedidoService pedidoService;

    // Adicione outros serviços conforme necessário

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Sistema de Gestão de Joalheria ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Joias");
            System.out.println("4. Gerenciar Pedidos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    gerenciarClientes(scanner);
                    break;
                case 2:
                    gerenciarFuncionarios(scanner);
                    break;
                case 3:
                    gerenciarJoias(scanner);
                    break;
                case 4:
                    gerenciarPedidos(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void gerenciarClientes(Scanner scanner) {
        System.out.println("=== Gerenciamento de Clientes ===");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o email do cliente: ");
                String email = scanner.nextLine();

                ClienteDTO clienteDTO = new ClienteDTO(null, nome, email);
                ClienteDTO clienteSalvo = clienteService.criarCliente(clienteDTO);

                System.out.println("Cliente registrado com sucesso: " + clienteSalvo);
                break;

            case 2:
                List<ClienteDTO> clientes = clienteService.buscarTodosClientes();
                System.out.println("Clientes cadastrados:");
                clientes.forEach(System.out::println);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private void gerenciarFuncionarios(Scanner scanner) {
        System.out.println("=== Gerenciamento de Funcionários ===");
        System.out.println("1. Registrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do funcionário: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o cargo do funcionário: ");
                String cargo = scanner.nextLine();

                FuncionarioDTO funcionarioDTO = new FuncionarioDTO(null, nome, cargo);
                FuncionarioDTO funcionarioSalvo = funcionarioService.criarFuncionario(funcionarioDTO);

                System.out.println("Funcionário registrado com sucesso: " + funcionarioSalvo);
                break;

            case 2:
                List<FuncionarioDTO> funcionarios = funcionarioService.buscarTodosFuncionarios();
                System.out.println("Funcionários cadastrados:");
                funcionarios.forEach(System.out::println);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private void gerenciarJoias(Scanner scanner) {
        System.out.println("=== Gerenciamento de Joias ===");
        System.out.println("1. Registrar Joia");
        System.out.println("2. Listar Joias");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome da joia: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o tipo da joia: ");
                String tipo = scanner.nextLine();
                System.out.print("Digite o material da joia: ");
                String material = scanner.nextLine();
                System.out.print("Digite o peso da joia: ");
                double peso = scanner.nextDouble();
                System.out.print("Digite o preço da joia: ");
                double preco = scanner.nextDouble();
                System.out.print("Digite a quantidade em estoque: ");
                int quantidade = scanner.nextInt();

                JoiaDTO joiaDTO = new JoiaDTO(null, nome, tipo, material, peso, preco, quantidade);
                JoiaDTO joiaSalva = joiaService.criarJoia(joiaDTO);

                System.out.println("Joia registrada com sucesso: " + joiaSalva);
                break;

            case 2:
                List<JoiaDTO> joias = joiaService.buscarTodasJoias();
                System.out.println("Joias cadastradas:");
                joias.forEach(System.out::println);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private void gerenciarPedidos(Scanner scanner) {
        System.out.println("=== Gerenciamento de Pedidos ===");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Listar Pedidos");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do cliente: ");
                Long clienteId = scanner.nextLong();
                System.out.print("Digite os IDs das joias (separados por vírgula): ");
                scanner.nextLine();
                String idsJoias = scanner.nextLine();
                List<Long> joiasIds = Arrays.stream(idsJoias.split(","))
                        .map(Long::parseLong)
                        .toList();

                PedidoDTO pedidoDTO = new PedidoDTO(null, clienteId, (Date) joiasIds, null, 0.0, "PENDENTE");
                PedidoDTO pedidoSalvo = pedidoService.criarPedido(pedidoDTO);

                System.out.println("Pedido registrado com sucesso: " + pedidoSalvo);
                break;

            case 2:
                List<PedidoDTO> pedidos = pedidoService.buscarTodosPedidos();
                System.out.println("Pedidos cadastrados:");
                pedidos.forEach(System.out::println);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
