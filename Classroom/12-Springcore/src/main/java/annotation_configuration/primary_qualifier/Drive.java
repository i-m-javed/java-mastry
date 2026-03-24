package annotation_configuration.primary_qualifier;

import annotation_configuration.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Drive {
    @Autowired
    @Qualifier(value = "car")
    private Vehicles p;
    public void drive(){ p.run();}
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

//        primary
       Vehicles vehicles= context.getBean(Vehicles.class);
        vehicles.run();

        Drive m= context.getBean(Drive.class);
//        Qualifier
        m.drive();
    }
}
