package com.uninter.taskcontrolapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "tarefa")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Getter
    @Setter
    private String responsavel;
}
