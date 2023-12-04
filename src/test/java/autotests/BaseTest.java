package autotests;

import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import userdto.UserDtoLombok;
import utils.RandomUtils;

public class BaseTest {
    @Listeners(TestNGListener.class)
      // static ApplicationManager app = new ApplicationManager();
        RandomUtils randomUtils = new RandomUtils();

        Logger logger = LoggerFactory.getLogger(BaseTest.class);

        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("haifa@gmail.com")
                .password("Haifa082022$")
                .build();


        @BeforeSuite(alwaysRun = true)
        public void setup(){
            logger.info("open browser");
            ApplicationManager.init();
        }
        @AfterSuite(alwaysRun = true)
        public void stop(){
            logger.info("close browser");
            app.tearDown();
        }

        public void logoutIfLogin(){
            if(app.getUserHelper().btnLogoutExist()){
                app.getUserHelper().logout();
                logger.info("logout");
            }
        }


}
