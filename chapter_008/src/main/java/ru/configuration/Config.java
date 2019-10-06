package ru.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.domain.AbstractProduct;
import ru.domain.Phone;


@Configuration
@ComponentScan(value={"ru.consumer"})
public class Config {

    @Bean
    public AbstractProduct getPhone(){
        return new Phone("Xiaomi", 1000);
    }
}
