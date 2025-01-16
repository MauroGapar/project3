package controller;

import dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Criar um novo cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
        if (clienteCriado != null) {
            return ResponseEntity.status(201).body(clienteCriado);  // Retorna 201 Created com o cliente criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);  // Retorna 200 OK com o cliente atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o cliente não for encontrado
        }
    }

    // Buscar um cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.buscarClientePorId(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);  // Retorna 200 OK com o cliente encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o cliente não for encontrado
        }
    }

    // Buscar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        List<ClienteDTO> clientesDTO = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientesDTO);  // Retorna 200 OK com a lista de clientes
    }

    // Excluir um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        boolean excluido = clienteService.excluirCliente(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o cliente não for encontrado
        }
    }
}