package chakra.controllers;

import chakra.models.Blog;
import chakra.repositories.BlogRepository;
import chakra.requests.CreateBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

  @Autowired
  private BlogRepository repository;

  @RequestMapping(method = POST)
  public Response<Blog> createBlog(@RequestBody CreateBlog request) {
    Blog newBlog = new Blog(request.getName());
    return new Response<Blog>(repository.save(newBlog));
  }

  @RequestMapping(value = "/{name}/", method = GET)
  public Response<Blog> getBlogs(@PathVariable String name) {
    Blog oneBlog = repository.findAll().iterator().next();
    return new Response<Blog>(oneBlog);
  }

}
