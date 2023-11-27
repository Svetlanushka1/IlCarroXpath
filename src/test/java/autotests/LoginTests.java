package autotests;

import org.testng.Assert;
import org.testng.annotations.Test;
import userdto.UserDTO;
import userdto.UserDTOWith;

public class LoginTests extends BaseTest {
        @Test
        public void positiveLoginUserDTO() {
            UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");
            app.getUserHelper().login(userDTO);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

        }

        @Test
        public void positiveLoginUserDTOWith() {
            UserDTOWith userDTOWith = new UserDTOWith()
                    .withEmail("testqa20@gmail.com")
                    .withPassword("123456Aa$");
            app.getUserHelper().login(userDTOWith);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

        }



}
