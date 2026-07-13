package com.ms.hrpayroll.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;

}
