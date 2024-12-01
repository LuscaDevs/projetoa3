package com.luscadev.projetoa3.controller;

import com.luscadev.projetoa3.model.ModelTarefa;
import com.luscadev.projetoa3.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<ModelTarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelTarefa> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ModelTarefa> criarTarefa(@RequestBody ModelTarefa tarefa) {
        return ResponseEntity.ok(tarefaService.salvar(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelTarefa> atualizarTarefa(@PathVariable Long id, @RequestBody ModelTarefa tarefa) {
        try {
            return ResponseEntity.ok(tarefaService.atualizar(id, tarefa));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
