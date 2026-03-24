package annotation_configuration.primary_qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Truck implements Vehicles {
    @Override
    public void run() {
        System.out.println("Truck is running");
    }
}
