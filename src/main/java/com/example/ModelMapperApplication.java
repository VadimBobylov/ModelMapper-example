package com.example;

import com.example.entity.DoughEntity;
import com.example.entity.PizzaEntity;
import com.example.service.PizzaConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class ModelMapperApplication {
    private final PizzaConverter pizzaConverter;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperApplication.class, args);
    }


    @Bean
    public CommandLineRunner run() {
        return args -> {
            var entity = PizzaEntity
                    .builder()
                    .id(123L)
                    .name("mocarella")
                    .price(777.77)
                    .weight(500.55)
                    .dough(new DoughEntity(1l,"Belkovoe"))
                    .build();
            log.info("Entity: {}", entity);
            var dto = pizzaConverter.convertToDto(entity);
            log.info("DTO:    {}", dto);

        };
    }

}
