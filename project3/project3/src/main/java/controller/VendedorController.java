package controller;

import dto.VendedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VendedorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    // Criar um novo vendedor
    @PostMapping
    public ResponseEntity<VendedorDTO> criarVendedor(@RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO vendedorCriado = vendedorService.criarVendedor(vendedorDTO);
        if (vendedorCriado != null) {
            return ResponseEntity.status(201).body(vendedorCriado);  // Retorna 201 Created com o vendedor criado
        } else {
            return ResponseEntity.badRequest().build();  // Retorna 400 Bad Request se não criar
        }
    }

    // Atualizar um vendedor existente
    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO vendedorAtualizado = vendedorService.atualizarVendedor(id, vendedorDTO);
        if (vendedorAtualizado != null) {
            return ResponseEntity.ok(vendedorAtualizado);  // Retorna 200 OK com o vendedor atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se o vendedor não for encontrado
        }
    }

    // Buscar um vendedor pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> buscarVendedorPorId(@PathVariable Long id) {
        VendedorDTO vendedorDTO = vendedorService.buscarVendedorPorId(id);
        if (vendedorDTO != null) {
            return ResponseEntity.ok(vendedorDTO);  // Retorna 200 OK com o vendedor encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }

    // Buscar todos os vendedores
    @GetMapping
    public ResponseEntity<List<VendedorDTO>> buscarTodosVendedores() {
        List<VendedorDTO> vendedoresDTO = vendedorService.buscarTodosVendedores();
        return ResponseEntity.ok(vendedoresDTO);  // Retorna 200 OK com a lista de vendedores
    }

    // Excluir um vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVendedor(@PathVariable Long id) {
        boolean excluido = vendedorService.excluirVendedor(id);
        if (excluido) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a exclusão for bem-sucedida
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrado
        }
    }
}