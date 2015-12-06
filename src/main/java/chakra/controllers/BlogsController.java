package chakra.controllers;

import chakra.models.Blog;
import chakra.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

  @Autowired
  private BlogRepository repository;

  @RequestMapping(method = POST)
  public Data<Blog> createBlog(@RequestBody Map params) {
    return new Data<Blog>(new Blog(params.get("name").toString()));
  }

  @RequestMapping(method = GET)
  public Data<Blog> getBlogs() {
    Blog oneBlog = repository.findAll().iterator().next();
    return new Data<Blog>(oneBlog);
  }

}
