package com.example.service;

import com.example.dto.PizzaDto;
import com.example.dto.TestoDto;
import com.example.entity.DoughEntity;
import com.example.entity.PizzaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PizzaConverter {
    private final ModelMapper mapper = new ModelMapper();

    @PostConstruct
    public void init() {
        mapper.typeMap(PizzaEntity.class, PizzaDto.class)
                .addMappings(mapper -> {
                    //ignore id field
                    mapper.skip(PizzaDto::setId);
                    //property mapping
                    mapper.map(PizzaEntity::getName, PizzaDto::setNazvanie);
                    mapper.map(PizzaEntity::getPrice, PizzaDto::setCena);
                    mapper.map(PizzaEntity::getWeight, PizzaDto::setVes);
                    //deep property mapping
                    mapper.<String>map(src -> src.getDough().getName(), (dest,v) -> dest.getTesto().setNazvanie(v));
                });

    }

    public PizzaDto convertToDto(PizzaEntity entity) {
        return mapper.map(entity, PizzaDto.class);
    }
}
