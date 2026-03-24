package annotation_configuration.entity;

import annotation_configuration.configuration.AppConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public class Favourite {
    @Value("100")
    private int id;
//    private int id=100;
    @Value(value = "ABC")
    private String name;

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Favourite mp= context.getBean(Favourite.class);
        System.out.println(mp);
    }
}
