package controller;

import dto.JoiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.JoiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@RestController
@RequestMapping("/api/joias")
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    // Criar uma nova joia
    @PostMapping
    public ResponseEntity<JoiaDTO> criarJoia(@RequestBody JoiaDTO joiaDTO) {
        JoiaDTO joiaCriada = joiaService.criarJoia(joiaDTO);
        if (joiaCriada != null) {
            return ResponseEntity.status(201).body(joiaCriada);  // Retorna 201 Created com a joia criada
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar uma joia existente
    @PutMapping("/{id}")
    public ResponseEntity<JoiaDTO> atualizarJoia(@PathVariable Long id, @RequestBody JoiaDTO joiaDTO) {
        JoiaDTO joiaAtualizada = joiaService.atualizarJoia(id, joiaDTO);
        if (joiaAtualizada != null) {
            return ResponseEntity.ok(joiaAtualizada);  // Retorna 200 OK com a joia atualizada
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se a joia não for encontrada
        }
    }

    // Buscar uma joia pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<JoiaDTO> buscarJoiaPorId(@PathVariable Long id) {
        JoiaDTO joiaDTO = joiaService.buscarJoiaPorId(id);
        if (joiaDTO != null) {
            return ResponseEntity.ok(joiaDTO);  // Retorna 200 OK com a joia encontrada
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrada
        }
    }

    // Buscar todas as joias
    @GetMapping
    public ResponseEntity<List<JoiaDTO>> buscarTodasJoias() {
        List<JoiaDTO> joiasDTO = joiaService.buscarTodasJoias();
        return ResponseEntity.ok(joiasDTO);  // Retorna 200 OK com a lista de joias
    }

    // Excluir uma joia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirJoia(@PathVariable Long id) {
        boolean excluida = joiaService.excluirJoia(id);
        if (excluida) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrada
        }
    }
}