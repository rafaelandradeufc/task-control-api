package com.uninter.taskcontrolapi.controllers;

import com.uninter.taskcontrolapi.models.Tarefa;
import com.uninter.taskcontrolapi.services.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {


    private final  TarefaService service;

    @Autowired
    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarefa addTarefa(@RequestBody final Tarefa tarefa) {
        return service.add(tarefa);
    }

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable final Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarefaById(@PathVariable final Long id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefaById(@PathVariable final Long id, @RequestBody final Tarefa novaTarefa) {
        return service.findById(id).map(tarefa -> {
            tarefa.setNome(novaTarefa.getNome());
            tarefa.setResponsavel(novaTarefa.getResponsavel());
            tarefa.setDataEntrega(novaTarefa.getDataEntrega());
            return ResponseEntity.ok(service.update(tarefa));
        }).orElse(ResponseEntity.notFound().build());
    }
}
