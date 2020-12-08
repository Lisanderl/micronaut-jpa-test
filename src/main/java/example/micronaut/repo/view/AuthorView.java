package example.micronaut.repo.view;

import io.micronaut.core.annotation.Introspected;

@Introspected
public interface AuthorView {
  String getFirstName();

  String getLastName();

  //Set<BookView> getBooks();
  //
  //interface BookView {
  //
  //  String getName();
  //  String getIsbn();
  //}
}
