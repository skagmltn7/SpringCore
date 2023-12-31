package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleAnnotationTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        AnnotationNetworkClient client = ac.getBean(AnnotationNetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean
        public AnnotationNetworkClient networkClient(){
            AnnotationNetworkClient client = new AnnotationNetworkClient();
            client.setUrl("http://hello0spring.dev");
            return client;
        }
    }
}
