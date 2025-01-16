package controller;

import dto.BrincoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BrincoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/brincos")
public class BrincoController {

    @Autowired
    private BrincoService brincoService;

    // Criar um novo brinco
    @PostMapping
    public ResponseEntity<BrincoDTO> criarBrinco(@RequestBody BrincoDTO brincoDTO) {
        BrincoDTO brincoCriado = brincoService.criarBrinco(brincoDTO);
        if (brincoCriado != null) {
            return ResponseEntity.status(201).body(brincoCriado);  // Retorna 201 Created com o brinco criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um brinco existente
    @PutMapping("/{id}")
    public ResponseEntity<BrincoDTO> atualizarBrinco(@PathVariable Long id, @RequestBody BrincoDTO brincoDTO) {
        BrincoDTO brincoAtualizado = brincoService.atualizarBrinco(id, brincoDTO);
        if (brincoAtualizado != null) {
            return ResponseEntity.ok(brincoAtualizado);  // Retorna 200 OK com o brinco atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o brinco não for encontrado
        }
    }

    // Buscar um brinco pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<BrincoDTO> buscarBrincoPorId(@PathVariable Long id) {
        BrincoDTO brincoDTO = brincoService.buscarBrincoPorId(id);
        if (brincoDTO != null) {
            return ResponseEntity.ok(brincoDTO);  // Retorna 200 OK com o brinco encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o brinco não for encontrado
        }
    }

    // Buscar todos os brincos
    @GetMapping
    public ResponseEntity<List<BrincoDTO>> buscarTodosBrincos() {
        List<BrincoDTO> brincosDTO = brincoService.buscarTodosBrincos();
        return ResponseEntity.ok(brincosDTO);  // Retorna 200 OK com a lista de brincos
    }

    // Excluir um brinco
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirBrinco(@PathVariable Long id) {
        boolean excluido = brincoService.excluirBrinco(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o brinco não for encontrado
        }
    }
}
