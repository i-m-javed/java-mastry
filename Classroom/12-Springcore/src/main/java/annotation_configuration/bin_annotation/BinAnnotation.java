package annotation_configuration.bin_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BinAnnotation {
    @Scope(value = "prototype")
    @Bean(name = "getPerson")
    public Person getPerson() {
        return new Person(1, "John");
    }

    @Bean(name = "getPerson1")
    public Person getPerson1() {
        return new Person(2, "Don");
    }
}
