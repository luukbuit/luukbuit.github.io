import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {
    SearchPageObject search = new SearchPageObject();

    @BeforeEach
    void setup() {
        // TODO
    }

    @Test
    void searchForSong() {
        List<String> result = search.searchFor("blue suede shoes performing artist");
        assertThat(result).containsAnyOf("Elvis Presley");
    }

}
