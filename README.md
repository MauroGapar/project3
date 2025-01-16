Este é um sistema de gestão para uma loja de joias, com funcionalidades para gerenciar funcionários, produtos (joias), clientes e pedidos. O projeto foi desenvolvido em Java utilizando o padrão MVC (Model-View-Controller) e o JPA (Java Persistence API) para persistência de dados.

Tecnologias Utilizadas
Java 8
Spring Framework (Spring Boot para facilitar a configuração do servidor)
JPA (Java Persistence API)
Hibernate (Para persistência de dados)
Maven (Gerenciador de dependências)
NetBeans 8.2 (IDE)
MySQL (Banco de dados)
Estrutura do Projeto
Pacotes principais:
entity: Contém as classes de entidades que representam os dados no banco de dados.

Funcionario
Vendedor
Gerente
Joia (superclasse)
Colar, Brinco, Anel (subclasses de Joia)
Cliente
Pedido
Pagamento
dto: Contém as classes DTO (Data Transfer Objects), que são usadas para transferir dados entre as camadas.

FuncionarioDTO
VendedorDTO
GerenteDTO
JoiaDTO
ColarDTO, BrincoDTO, AnelDTO
ClienteDTO
PedidoDTO
PagamentoDTO
mapper: Contém as classes responsáveis por mapear as entidades para os DTOs e vice-versa.

FuncionarioMapper
VendedorMapper
GerenteMapper
JoiaMapper
ColarMapper, BrincoMapper, AnelMapper
ClienteMapper
PedidoMapper
PagamentoMapper
service: Contém as classes de serviço, que são responsáveis pela lógica de negócios e pela comunicação com a camada de persistência.

FuncionarioService
VendedorService
GerenteService
JoiaService
ColarService, BrincoService, AnelService
ClienteService
PedidoService
PagamentoService
controller: Contém as classes de controle (REST Controllers) responsáveis por lidar com as requisições HTTP e retornar respostas.

FuncionarioController
VendedorController
GerenteController
JoiaController
ColarController, BrincoController, AnelController
ClienteController
PedidoController
PagamentoController
