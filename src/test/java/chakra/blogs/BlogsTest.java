package chakra.blogs;


import chakra.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    Map blogParams = new HashMap();
    blogParams.put("name", "aBlog");
    ResponseEntity<Map> response = template.postForEntity(atUrl("blogs"), blogParams, Map.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(((Map)response.getBody().get("data")).get("name").toString(), is("aBlog"));
  }

  private String atUrl(String url) {
    return String.format("http://localhost:%d/%s/", port, url);
  }
}
