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

  protected Blog() {}
  public Blog(String name) {
    this.name = name;
  }

  public String getName(){return this.name;}
}