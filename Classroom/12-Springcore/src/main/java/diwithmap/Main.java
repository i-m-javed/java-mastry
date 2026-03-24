package diwithmap;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("dependencyInjection.xml"));
        Kit kit=(Kit)beanFactory.getBean("kitId");
        System.out.println(kit);
    }
}
