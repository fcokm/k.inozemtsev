package ru.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Phone extends AbstractProduct {

    public Phone(@Value("${phone.name}")String name,
                 @Value("${phone.price}")int price) {
        super(name, price);
    }

    @Override
    public int calcCostDelivery() {
        return price >= 500 ? 0: 20;
    }

    @Override
    public String toString() {
        return String.format(" %s %d ",name, price);
    }
}
