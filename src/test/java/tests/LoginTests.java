package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import userdto.UserDTO;
import userdto.UserDtoLombok;
import utils.ConfigProperties;

public class LoginTests extends BaseTest {
    Logger logger = LoggerFactory.getLogger(LoginTests.class);

     @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        logoutIflogin();
    }

    @AfterMethod(alwaysRun = true)
    public void postconditionsLogin() {
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }
    @Test(groups = {"smoke", "regression"})
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        BaseTest.app.getUserHelper().login(userDTO);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }
    /*  @Test
        public void positiveLoginUserDTOWith() {
            UserDTOWith userDTOWith = new UserDTOWith()
                    .withEmail("email")
                    .withPassword("password");
            app.getUserHelper().login(userDTOWith);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

        }*/
       @Test
    public void positiveLoginUserDtoLombok(){
            UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                    .email("haifa@gmail.com")
                    .password("Haifa082022$")
                    .build();

            app.getUserHelper().loginUserDtoLombok(userDtoLombok);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
            logger.info("Assert passed");

        }
    /*
    @Test(groups = {"smoke", "regression"})
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        BaseTest.app.getUserHelper().login(userDTO);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test(description = "positiveLoginUserDTOWith", groups = {"smoke", "regression"})
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");
        BaseTest.app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(BaseTest.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }


   @Test(groups = {"smoke", "regression"})
   public void positiveLogin1() {
       app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        try {
           Thread.sleep(1);
       } catch (InterruptedException e) {
            logger.error(String.valueOf(e));
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
        logger.info("Test Finished");
   }
}
     */
// negative
    @Test(priority = 1)
    public void negativePasswordWithoutSymbol() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aaa")
                .build();
        logger.info("testqa20@gmail.com");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    } @Test(priority = 1)
    public void negativePasswordWithoutNumbers() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("ddsdhjAa$")
                .build();
        logger.warn("userDtoLombok initialization finished");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect(), "Fail");
        logger.info("Pass");

    }

    @Test(priority = 1)
    public void negativePasswordWithoutLetters() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("12345678$")
                .build();
        logger.warn("userDtoLombok initialization finished again with warn");
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);

        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }

}

