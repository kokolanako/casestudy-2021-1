package casestudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationStarter {
  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStarter.class);

  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, args);
  }
}
