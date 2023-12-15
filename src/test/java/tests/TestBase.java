package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import userdto.UserDtoLombok;
import utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
  //  @Listeners(TestNGListener.class)
  static ApplicationManager app = new ApplicationManager();
    RandomUtils randomUtils = new RandomUtils();

    Logger logger = LoggerFactory.getLogger(TestBase.class);
   boolean flagLogin = false, flagPopUp = false;

   UserDtoLombok userDtoLombok = UserDtoLombok.builder()
            .email("haifa@gmail.com")
            .password("Haifa082022$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        logger.info("open browser");
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop() {
        logger.info("close browser");
        app.tearDown();
    }

    //use flag to know
    public void logoutIflogin() {
        if (app.getUserHelper().btnLogoutExist()) {
            app.getUserHelper().logout();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m) {
        logger.info("start test" + m.getName());
        logger.info("started method with params: " + Arrays.toString(m.getParameters()));
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m) {
        logger.info("End of test:" + m.getName());
        logger.info("end method with params: " + Arrays.toString(m.getParameters()));
    }
}
