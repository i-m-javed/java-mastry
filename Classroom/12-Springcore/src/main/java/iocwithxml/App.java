package iocwithxml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {
        BeanFactory beanFactory1=new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
        Laptop l1=(Laptop) beanFactory1.getBean("LaptopId");
        System.out.println(l1);

//        BeanFactory beanFactory2=new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
//        Laptop l2=beanFactory2.getBean(Laptop.class);
//        System.out.println(l2);

//        Laptop l3=(Laptop) beanFactory1.getBean("LaptopId1");
//        System.out.println(l3);

        ApplicationContext context=new ClassPathXmlApplicationContext("beanConfiguration.xml");
        Laptop l4=(Laptop) context.getBean("LaptopId1");
        System.out.println(l4);
    }
}
