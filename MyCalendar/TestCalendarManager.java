import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;

public class TestCalendarManager
{

    @BeforeEach
    public void init()
    {

    }

    @Test
    public void test_connexion()
    {
        String infCo = "première ligne\nseconde ligne\n";
        System.setIn(new ByteArrayInputStream(infCo.getBytes()));
    }
}
