package chakra.blogs;


import chakra.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class BlogsTest {

  @Value("${local.server.port}")
  private int port;

  private RestTemplate template;

  @Before
  public void setUp() throws Exception {
    template = new TestRestTemplate();
  }

  @Test
  public void testSave() {
    assertThat(1, is(2));
    throw new RuntimeException();
  }

  private String atUrl(String url) {
    return String.format("http://localhost:%d/%s/", port, url);
  }
}
