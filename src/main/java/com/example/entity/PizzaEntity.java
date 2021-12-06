package com.example.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {
    private Long id;
    private String name;
    private Double price;
    private Double weight;
    private DoughEntity dough;
}

