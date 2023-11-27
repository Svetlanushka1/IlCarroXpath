package autotests;

import org.testng.Assert;
import org.testng.annotations.Test;
import userdto.UserDTO;
import userdto.UserDTOWith;
import userdto.UserDtoLombok;

public class LoginTests extends BaseTest {
        @Test
        public void positiveLoginUserDTO() {
            UserDTO userDTO = new UserDTO("haifa@gmail.com", "Haifa082022$");
            app.getUserHelper().login(userDTO);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

        }

        @Test
        public void positiveLoginUserDTOWith() {
            UserDTOWith userDTOWith = new UserDTOWith()
                    .withEmail("haifa@gmail.com")
                    .withPassword("Haifa082022$");
            app.getUserHelper().login(userDTOWith);
            Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

        }
        @Test
    public void positiveLoginUserDtoLombok(){
            UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                    .email("haifa@gmail.com")
                    .password("Haifa082022$")
                    .build();
        }




}
