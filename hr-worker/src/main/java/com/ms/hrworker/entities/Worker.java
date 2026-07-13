package com.ms.hrworker.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_worker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private Double dailyIncome;

}
