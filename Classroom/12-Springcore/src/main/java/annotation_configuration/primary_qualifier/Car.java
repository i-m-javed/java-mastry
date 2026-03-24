package annotation_configuration.primary_qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicles {
    @Override
    public void run() {
        System.out.println("Car is running");
    }
}
