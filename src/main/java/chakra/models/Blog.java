package chakra.models;


import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  public Blog(String name, String ignore) {
    this.name = ignore;
  }
}