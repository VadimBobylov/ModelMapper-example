package com.example.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDto {
    private Long id;
    private String nazvanie;
    private Double cena;
    private Double ves;
    private TestoDto testo;

}
