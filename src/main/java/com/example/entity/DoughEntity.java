package com.example.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoughEntity {
    private Long id;
    private String name;
}
