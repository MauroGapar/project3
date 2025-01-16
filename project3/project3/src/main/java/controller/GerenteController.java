package controller;

import dto.GerenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.GerenteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    // Criar um novo gerente
    @PostMapping
    public ResponseEntity<GerenteDTO> criarGerente(@RequestBody GerenteDTO gerenteDTO) {
        GerenteDTO gerenteCriado = gerenteService.criarGerente(gerenteDTO);
        if (gerenteCriado != null) {
            return ResponseEntity.status(201).body(gerenteCriado);  // Retorna 201 Created com o gerente criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um gerente existente
    @PutMapping("/{id}")
    public ResponseEntity<GerenteDTO> atualizarGerente(@PathVariable Long id, @RequestBody GerenteDTO gerenteDTO) {
        GerenteDTO gerenteAtualizado = gerenteService.atualizarGerente(id, gerenteDTO);
        if (gerenteAtualizado != null) {
            return ResponseEntity.ok(gerenteAtualizado);  // Retorna 200 OK com o gerente atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o gerente não for encontrado
        }
    }

    // Buscar um gerente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<GerenteDTO> buscarGerentePorId(@PathVariable Long id) {
        GerenteDTO gerenteDTO = gerenteService.buscarGerentePorId(id);
        if (gerenteDTO != null) {
            return ResponseEntity.ok(gerenteDTO);  // Retorna 200 OK com o gerente encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }

    // Buscar todos os gerentes
    @GetMapping
    public ResponseEntity<List<GerenteDTO>> buscarTodosGerentes() {
        List<GerenteDTO> gerentesDTO = gerenteService.buscarTodosGerentes();
        return ResponseEntity.ok(gerentesDTO);  // Retorna 200 OK com a lista de gerentes
    }

    // Excluir um gerente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirGerente(@PathVariable Long id) {
        boolean excluido = gerenteService.excluirGerente(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }
}