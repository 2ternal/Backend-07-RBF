package rbf3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rbf3.config.AppConfigV1;
import rbf3.config.AppConfigV2;
import rbf3.config.AppConfigV3;
import rbf3.repository.PlayerRepository;
import rbf3.repository.RepositoryInterface;

@Slf4j
public class ConfigTest {

    @Test
    @DisplayName("Bean Context test")
    void test1() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV1.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            log.info("beanDefinition = {}", beanDefinition);
        }
    }

    @Test
    @DisplayName("Bean Context test2")
    void test1_1() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV1.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                log.info("beanDefinition = {}", beanDefinition);
            }

        }
    }

    @Test
    @DisplayName("Duplicate Named Bean test")
    void test2() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV2.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {

                log.info("beanDefinition = {}", beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("구체 클레스 조회")
    void test3() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV3.class);

        RepositoryInterface bean = ac.getBean(PlayerRepository.class);

        log.info("bean = {}", bean);
    }

    @Test
    @DisplayName("인터페이스 조회")
    void test4() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV3.class);

        RepositoryInterface bean = ac.getBean(RepositoryInterface.class);

        log.info("bean = {}", bean);
    }

    @Test
    @DisplayName("AppConfigV3")
    void test5() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV3.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                log.info("beanDefinition = {}", beanDefinition);
            }

        }
    }
}
