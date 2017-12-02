import com.hermestechnologies.service.User.PasswordHashService;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PasswordHashingTest {


    @Test
    public void checkHashing(){
        PasswordHashService passwordHashService = new PasswordHashService();
        String hash = passwordHashService.hash("admin");
        assertTrue(passwordHashService.verifyHash("admin",hash));
    }

}
