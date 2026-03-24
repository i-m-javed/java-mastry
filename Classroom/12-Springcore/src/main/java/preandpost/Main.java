package preandpost;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
//        BeanFactory beanFactory= new XmlBeanFactory(new ClassPathResource("pre_and_post.xml"));
        ApplicationContext context= new ClassPathXmlApplicationContext("pre_and_post.xml");
//        beanFactory.getBean("vId");
        context.getBean("vId");
        ((AbstractApplicationContext) context).close();
    }
}
