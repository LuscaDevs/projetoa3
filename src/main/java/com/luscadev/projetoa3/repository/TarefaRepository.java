package com.luscadev.projetoa3.repository;

import com.luscadev.projetoa3.model.ModelTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<ModelTarefa, Long> {
}
