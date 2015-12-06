package chakra.repositories;


import java.util.List;

import chakra.models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
  List<Blog> findByName(String name);
}