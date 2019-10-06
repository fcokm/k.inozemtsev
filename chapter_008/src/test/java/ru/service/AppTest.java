package ru.service;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.domain.AnnotationApp;
import ru.consumer.XMLApp;
import ru.domain.AbstractProduct;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Configuration
@ComponentScan
public class AppTest {

    @Bean
    public Deliverable getProduct() {
        return new AbstractProduct("Dummy", 10){
            @Override
            public int calcCostDelivery() {
                return price >= 100 ? 0: 20;
            }
        };
    }

    @Test
    public void whenXmlAppTest() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("spring-context.xml");
        XMLApp app = context.getBean(XMLApp.class);
        int result = app.processOrder();
        context.close();
        assertThat(result, is(0));
    }

    @Test
    public void whenAnnotatAppTest() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.scan("ru.domain");
        context.refresh();
        AnnotationApp app = context.getBean(AnnotationApp.class);
        app.processOrder();
        int result = app.processOrder();
        context.close();
        assertThat(result, is(0));
    }


    @Test
    public void beanTest() {
        assertThat(getProduct().
                calcCostDelivery(), is(20));
    }
}
