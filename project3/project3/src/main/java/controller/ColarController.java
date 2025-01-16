package controller;

import dto.ColarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ColarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/colares")
public class ColarController {

    @Autowired
    private ColarService colarService;

    // Criar um novo colar
    @PostMapping
    public ResponseEntity<ColarDTO> criarColar(@RequestBody ColarDTO colarDTO) {
        ColarDTO colarCriado = colarService.criarColar(colarDTO);
        if (colarCriado != null) {
            return ResponseEntity.status(201).body(colarCriado);  // Retorna 201 Created com o colar criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um colar existente
    @PutMapping("/{id}")
    public ResponseEntity<ColarDTO> atualizarColar(@PathVariable Long id, @RequestBody ColarDTO colarDTO) {
        ColarDTO colarAtualizado = colarService.atualizarColar(id, colarDTO);
        if (colarAtualizado != null) {
            return ResponseEntity.ok(colarAtualizado);  // Retorna 200 OK com o colar atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o colar não for encontrado
        }
    }

    // Buscar um colar pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ColarDTO> buscarColarPorId(@PathVariable Long id) {
        ColarDTO colarDTO = colarService.buscarColarPorId(id);
        if (colarDTO != null) {
            return ResponseEntity.ok(colarDTO);  // Retorna 200 OK com o colar encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o colar não for encontrado
        }
    }

    // Buscar todos os colares
    @GetMapping
    public ResponseEntity<List<ColarDTO>> buscarTodosColares() {
        List<ColarDTO> colaresDTO = colarService.buscarTodosColares();
        return ResponseEntity.ok(colaresDTO);  // Retorna 200 OK com a lista de colares
    }

    // Excluir um colar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirColar(@PathVariable Long id) {
        boolean excluido = colarService.excluirColar(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o colar não for encontrado
        }
    }
}
