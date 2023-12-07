package tests;

import org.testng.annotations.Test;
import utils.ConfigProperties;

public class LaunchAppTest extends BaseTest{
@Test(groups = {"smoke"})
    public void testLaunchApp() {
    app.isAppLaunch(ConfigProperties.getProperty("url"));
    BaseTest.app.getUserHelper().letTheCarWork();
   // Assert.assertTrue();
}
}
