package chakra;

import org.flywaydb.core.Flyway;

public class Migrations {
  public static void main(String[] args) throws Exception {
    Flyway flyway = new Flyway();
    flyway.setDataSource(
        System.getenv("postgres://rfaozzwhaeirje:vRKdlkiGjstuKVOmx2y3BbMKo3@ec2-54-83-0-61.compute-1.amazonaws.com:5432/dfdekq48kqa5sj\n"),
        System.getenv("rfaozzwhaeirje"),
        System.getenv("vRKdlkiGjstuKVOmx2y3BbMKo3"));
    flyway.migrate();
  }
}