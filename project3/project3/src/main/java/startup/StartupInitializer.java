/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package startup;

import repository.ClienteRepository;
import repository.FuncionarioRepository;
import repository.JoiaRepository;
import repository.PagamentoRepository;
import repository.PedidoRepository;
import service.ClienteService;
import service.FuncionarioService;
import service.JoiaService;
import service.PagamentoService;
import service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartupInitializer {

    private final FuncionarioService funcionarioService;
    private final ClienteService clienteService;
    private final JoiaService joiaService;
    private final PedidoService pedidoService;
    private final PagamentoService pagamentoService;

    // Repositórios
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JoiaRepository joiaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Construtor da classe
    public StartupInitializer() {
        // Inicialização dos serviços com os respectivos repositórios
        this.funcionarioService = new FuncionarioService(funcionarioRepository);
        this.clienteService = new ClienteService(clienteRepository);
        this.joiaService = new JoiaService(joiaRepository);
        this.pedidoService = new PedidoService(pedidoRepository);
        this.pagamentoService = new PagamentoService(pagamentoRepository);
    }

    // Método para inicializar dados ou configurações no banco de dados (opcional)
    public void initialize() {
        // Você pode adicionar dados iniciais ou realizar outras configurações aqui, se necessário.
        // Por exemplo, você pode carregar um conjunto inicial de funcionários ou clientes.

        // Exemplo de uso
        System.out.println("Inicializando os serviços da DOA Store...");
    }

    // Métodos de acesso aos serviços para facilitar a utilização em outras partes da aplicação
    public FuncionarioService getFuncionarioService() {
        return funcionarioService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public JoiaService getJoiaService() {
        return joiaService;
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public PagamentoService getPagamentoService() {
        return pagamentoService;
    }
}