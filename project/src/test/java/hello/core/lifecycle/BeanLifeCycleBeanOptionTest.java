package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleBeanOptionTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        BeanOptionNetworkClient client = ac.getBean(BeanOptionNetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean(initMethod = "init", destroyMethod = "close")
        public BeanOptionNetworkClient networkClient(){
            BeanOptionNetworkClient client = new BeanOptionNetworkClient();
            client.setUrl("http://hello0spring.dev");
            return client;
        }
    }
}
