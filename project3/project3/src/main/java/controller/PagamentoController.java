package controller;

import dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PagamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Criar um novo pagamento
    @PostMapping
    public ResponseEntity<PagamentoDTO> criarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO pagamentoCriado = pagamentoService.criarPagamento(pagamentoDTO);
        if (pagamentoCriado != null) {
            return ResponseEntity.status(201).body(pagamentoCriado);  // Retorna 201 Created com o pagamento criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um pagamento existente
    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> atualizarPagamento(@PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO pagamentoAtualizado = pagamentoService.atualizarPagamento(id, pagamentoDTO);
        if (pagamentoAtualizado != null) {
            return ResponseEntity.ok(pagamentoAtualizado);  // Retorna 200 OK com o pagamento atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pagamento não for encontrado
        }
    }

    // Buscar um pagamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPagamentoPorId(@PathVariable Long id) {
        PagamentoDTO pagamentoDTO = pagamentoService.buscarPagamentoPorId(id);
        if (pagamentoDTO != null) {
            return ResponseEntity.ok(pagamentoDTO);  // Retorna 200 OK com o pagamento encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pagamento não for encontrado
        }
    }

    // Buscar todos os pagamentos
    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> buscarTodosPagamentos() {
        List<PagamentoDTO> pagamentosDTO = pagamentoService.buscarTodosPagamentos();
        return ResponseEntity.ok(pagamentosDTO);  // Retorna 200 OK com a lista de pagamentos
    }

    // Excluir um pagamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPagamento(@PathVariable Long id) {
        boolean excluido = pagamentoService.excluirPagamento(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o pagamento não for encontrado
        }
    }
}
