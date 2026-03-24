package annotation_configuration.bin_annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Data
@AllArgsConstructor
public class Person {
    int id;
    String name;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BinAnnotation.class);
        Person person1 = (Person) context.getBean("getPerson");
        System.out.println(person1);
    }
}
