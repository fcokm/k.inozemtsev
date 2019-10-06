package ru.service;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.configuration.Config;
import ru.consumer.AnnotationApp;
import ru.consumer.XMLApp;
import ru.domain.AbstractProduct;

@Configuration
public class AppTest {

    @Bean
    public Deliverable getProduct() {
        return new AbstractProduct("Dummy", 100){
            @Override
            public int calcCostDelivery() {
                return price >= 100 ? 0: 20;
            }
        };
    }

    @Test
    public void whenXmlAppTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");
        XMLApp app = context.getBean(XMLApp.class);
        app.processMessage();
        context.close();

    }

    @Test
    public void whenAnnotatAppTest() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        AnnotationApp app = context.getBean(AnnotationApp.class);
        app.processMessage();
        context.close();
    }

    @Test
    public void whenQualifierXmlAppTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");
        AnnotationApp app = context.getBean(AnnotationApp.class);
        app.processMessage();
        context.close();
    }

    @Test
    public void beanTest() {
        System.out.println(getProduct().calcCostDelivery());
    }
}
