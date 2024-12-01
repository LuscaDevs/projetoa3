package com.luscadev.projetoa3.service;

import com.luscadev.projetoa3.model.ModelTarefa;
import com.luscadev.projetoa3.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<ModelTarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<ModelTarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public ModelTarefa salvar(ModelTarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public ModelTarefa atualizar(Long id, ModelTarefa tarefaAtualizada) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setNome(tarefaAtualizada.getNome());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setConcluido(tarefaAtualizada.isConcluido());
            return tarefaRepository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
}
