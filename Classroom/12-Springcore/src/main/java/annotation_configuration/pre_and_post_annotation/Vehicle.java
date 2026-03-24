package annotation_configuration.pre_and_post_annotation;

import annotation_configuration.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Component
public class Vehicle {
    public Vehicle(){
        System.out.println("Vehicle constructor");
    }
//    @PostConstruct
    public void moving(){
        System.out.println("Vehicle is moving");
    }
//    @PreDestroy
    public void accident(){
        System.out.println("Thank God, No live lost");
    }

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Vehicle.class);
        ((AbstractApplicationContext) context).close();
    }
}
