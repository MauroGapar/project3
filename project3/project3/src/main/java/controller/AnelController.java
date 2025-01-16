package controller;

import dto.AnelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AnelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/aneis")
public class AnelController {

    @Autowired
    private AnelService anelService;

    // Criar um novo anel
    @PostMapping
    public ResponseEntity<AnelDTO> criarAnel(@RequestBody AnelDTO anelDTO) {
        AnelDTO anelCriado = anelService.criarAnel(anelDTO);
        if (anelCriado != null) {
            return ResponseEntity.status(201).body(anelCriado);  // Retorna 201 Created com o anel criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um anel existente
    @PutMapping("/{id}")
    public ResponseEntity<AnelDTO> atualizarAnel(@PathVariable Long id, @RequestBody AnelDTO anelDTO) {
        AnelDTO anelAtualizado = anelService.atualizarAnel(id, anelDTO);
        if (anelAtualizado != null) {
            return ResponseEntity.ok(anelAtualizado);  // Retorna 200 OK com o anel atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o anel não for encontrado
        }
    }

    // Buscar um anel pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<AnelDTO> buscarAnelPorId(@PathVariable Long id) {
        AnelDTO anelDTO = anelService.buscarAnelPorId(id);
        if (anelDTO != null) {
            return ResponseEntity.ok(anelDTO);  // Retorna 200 OK com o anel encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o anel não for encontrado
        }
    }

    // Buscar todos os anéis
    @GetMapping
    public ResponseEntity<List<AnelDTO>> buscarTodosAnéis() {
        List<AnelDTO> aneisDTO = anelService.buscarTodosAnéis();
        return ResponseEntity.ok(aneisDTO);  // Retorna 200 OK com a lista de anéis
    }

    // Excluir um anel
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnel(@PathVariable Long id) {
        boolean excluido = anelService.excluirAnel(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o anel não for encontrado
        }
    }
}