package tests;

import data.DataProviderCars;
import org.testng.Assert;
import org.testng.annotations.*;
import userdto.AddCarDTO;
import userdto.UserDtoLombok;

import java.util.Random;

public class AddCarTests extends TestBase {/*
    @BeforeMethod
    public void loginPreConditions() {
        app.navigateToMainPage();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test
    public void addNewCarTest() {

        Random random = new Random();
        String serNumber = String.valueOf(Math.round(random.nextFloat() * Math.pow(10,12)));
        //int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        AddCarDTO car = AddCarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("Toyota Camry2")
                .model("Sedan")
                .year(2023)
                .fuel("Hybrid")
                .seats(4)
                .carClass("luxury")
                .pricePerDay(400)
                .city("Tel Aviv")
                .build();
        // Tel Aviv, Israel
        app.getCarHelper().clickAddNewCar();
        app.getCarHelper().fillFormNewCar(car);
        Assert.assertTrue(app.getCarHelper().validateMessagePopUp());
    }

    @AfterMethod
    public void logoutAfterConditions() {
        app.getCarHelper().clickAddNewCarPopUp();
        app.getUserHelper().logout();
        app.navigateToMainPage();
    }
    @Test(dataProvider = "negativeAddCarCSV",dataProviderClass = DataProviderCars.class)
    public void positiveLoginProvider(UserDtoLombok user){
        app.getUserHelper().loginUserDtoLombok(user);
        flagLogin = true;
        flagPopUp = true;
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }*/
    //span[@class='pac-item-query']
}
