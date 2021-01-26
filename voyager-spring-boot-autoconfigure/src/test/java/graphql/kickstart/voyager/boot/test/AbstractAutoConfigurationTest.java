package graphql.kickstart.voyager.boot.test;

import org.junit.jupiter.api.AfterEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Andrew Potter
 */
public abstract class AbstractAutoConfigurationTest {

  private final Class<? extends AbstractApplicationContext> contextClass;
  private final Class<?> autoConfiguration;

  private AbstractApplicationContext context;

  protected AbstractAutoConfigurationTest(Class<?> autoConfiguration) {
    this(AnnotationConfigApplicationContext.class, autoConfiguration);
  }

  protected AbstractAutoConfigurationTest(Class<? extends AbstractApplicationContext> contextClass,
      Class<?> autoConfiguration) {
    assert AnnotationConfigRegistry.class.isAssignableFrom(contextClass);
    this.contextClass = contextClass;
    this.autoConfiguration = autoConfiguration;
  }

  @AfterEach
  public void tearDown() {
    if (this.context != null) {
      this.context.close();
      this.context = null;
    }
  }

  protected void load(Class<?> config, String... environment) {
    try {
      this.context = contextClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

//        if (environment != null && environment.length > 0) {
//            EnvironmentTestUtils.addEnvironment(getContext(), environment);
//        }

    getRegistry().register(config);
    getRegistry().register(autoConfiguration);
    getContext().refresh();
  }

  public AnnotationConfigRegistry getRegistry() {
    return (AnnotationConfigRegistry) context;
  }

  public AbstractApplicationContext getContext() {
    return context;
  }
}
