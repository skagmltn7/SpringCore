package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleInterfaceTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        InterfaceNetworkClient client = ac.getBean(InterfaceNetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public InterfaceNetworkClient networkClient(){
            InterfaceNetworkClient interfaceNetworkClient = new InterfaceNetworkClient();
            interfaceNetworkClient.setUrl("http://hello0spring.dev");
            return interfaceNetworkClient;
        }
    }
}
