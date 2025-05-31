package com.uninter.taskcontrolapi.services;

import com.uninter.taskcontrolapi.models.Tarefa;
import com.uninter.taskcontrolapi.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {


    private final TarefaRepository repository;

    @Autowired
    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa add(Tarefa tarefa) {
       return repository.save(tarefa);
    }

    public Optional<Tarefa> findById(Long id) {
        return repository.findById(id);
    }

    public Tarefa update(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public boolean delete(Long id) {
        return findById(id)
                .map(tarefa -> {
                    repository.delete(tarefa);
                    return true;
                })
                .orElse(false);
    }

    public List<Tarefa> getAll() {
        return repository.findAll();
    }
}
