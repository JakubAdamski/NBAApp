import com.japroject.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class AppTest {

    @Autowired
    ApiService apiService;

    @Test
    public void fetchTest() {
        apiService.fetchAndSaveGames("2023");

    }
}

