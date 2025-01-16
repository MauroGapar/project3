package controller;

import dto.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Criar um novo funcionário
    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioCriado = funcionarioService.criarFuncionario(funcionarioDTO);
        if (funcionarioCriado != null) {
            return ResponseEntity.status(201).body(funcionarioCriado);  // Retorna 201 Created
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um funcionário existente
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionarioDTO);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);  // Retorna 200 OK com o funcionário atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o funcionário não for encontrado
        }
    }

    // Buscar um funcionário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        FuncionarioDTO funcionarioDTO = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionarioDTO != null) {
            return ResponseEntity.ok(funcionarioDTO);  // Retorna 200 OK com o funcionário
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }

    // Buscar todos os funcionários
    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> buscarTodosFuncionarios() {
        List<FuncionarioDTO> funcionariosDTO = funcionarioService.buscarTodosFuncionarios();
        return ResponseEntity.ok(funcionariosDTO);  // Retorna 200 OK com a lista de funcionários
    }

    // Excluir um funcionário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        boolean excluido = funcionarioService.excluirFuncionario(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }
}