package example.micronaut.repo.entity;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(name = "book_name", nullable = false)
  private String bookName;

  @NotNull
  @Column(name = "isbn", nullable = false)
  private String isbn;

  @ManyToOne(fetch = EAGER)
  private Author author;

  @ManyToOne(fetch = EAGER)
  private Genre genre;
}
