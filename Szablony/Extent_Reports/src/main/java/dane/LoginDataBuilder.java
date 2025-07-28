package data;

import lombok.Builder;
import lombok.Getter;

// zamiast różnych kontruktorów, np. raz z jednym polem, raz z innym lub wszystkie jednocześnie wystarczy lombok
// przydatne gdy testujemy formularz z wieloma polami i potrzebujemy różne kombinacje konstruktorów z różnymi kombinacjami pól
// dla lombok wymagana dependencja + plugin
// @Getter w domyśle robi gettery + @Builder

@Getter
@Builder
public class LoginDataBuilder {

    private String username;
    private String password;
}
