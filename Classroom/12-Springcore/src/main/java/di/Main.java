package di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory1=new XmlBeanFactory(new ClassPathResource("dependencyInjection.xml"));
        Person person=(Person) beanFactory1.getBean("person");
        System.out.println(person);
        ListOfPan pans=(ListOfPan) beanFactory1.getBean("listofpan");
        System.out.println(pans);
    }
}
