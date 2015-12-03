package chakra;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    setupMigrations();
    SpringApplication.run(Application.class, args);
  }

  private static void setupMigrations(){
    Flyway flyway = new Flyway();
    flyway.setDataSource(
        System.getenv("postgres://rfaozzwhaeirje:vRKdlkiGjstuKVOmx2y3BbMKo3@ec2-54-83-0-61.compute-1.amazonaws.com:5432/dfdekq48kqa5sj\n"),
        System.getenv("rfaozzwhaeirje"),
        System.getenv("vRKdlkiGjstuKVOmx2y3BbMKo3"));
    flyway.migrate();
  }
}