package ru.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.domain.AbstractProduct;


@Component
public class AnnotationApp {
    @Autowired
    @Qualifier("phone")
    private AbstractProduct product;

    public int processMessage(){
        System.out.println(product.getName() +" "+ product.calcCostDelivery());
        return product.calcCostDelivery();
    }
}
