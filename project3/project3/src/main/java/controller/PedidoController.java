package controller;

import dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Criar um novo pedido
    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoCriado = pedidoService.criarPedido(pedidoDTO);
        if (pedidoCriado != null) {
            return ResponseEntity.status(201).body(pedidoCriado);  // Retorna 201 Created com o pedido criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoAtualizado = pedidoService.atualizarPedido(id, pedidoDTO);
        if (pedidoAtualizado != null) {
            return ResponseEntity.ok(pedidoAtualizado);  // Retorna 200 OK com o pedido atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pedido não for encontrado
        }
    }

    // Buscar um pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        PedidoDTO pedidoDTO = pedidoService.buscarPedidoPorId(id);
        if (pedidoDTO != null) {
            return ResponseEntity.ok(pedidoDTO);  // Retorna 200 OK com o pedido encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pedido não for encontrado
        }
    }

    // Buscar todos os pedidos
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidos() {
        List<PedidoDTO> pedidosDTO = pedidoService.buscarTodosPedidos();
        return ResponseEntity.ok(pedidosDTO);  // Retorna 200 OK com a lista de pedidos
    }

    // Excluir um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        boolean excluido = pedidoService.excluirPedido(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pedido não for encontrado
        }
    }
}