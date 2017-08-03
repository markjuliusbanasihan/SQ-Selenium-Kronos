package kronos;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by RXC8414 on 5/25/2017.
 * Edited by MXB2320, added new assertions
 */
public class VerifyLogin {
    private String user;
    private String password;
    private static final String URL = "http://wn3923.homedepot.com/wfc/navigator/logon";

    // Step 1 for Page Factory
    static MainPage object;
    static WebDriver driver;


    // Step 2 for Page Factory
    @BeforeClass
    public static void setUpDriver(){
        String path = System.getProperty("user.dir")+"\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mxb2320\\SQ2-Selenium-Kronos\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 3 for Page Factory
        object = PageFactory.initElements(driver,MainPage.class);

    }

    @Before
    public void setUpKronos(){
        Assert.assertTrue("Could not navigate to Kronos.",object.navigateURL(URL));
    }

    @Test
    public void verifyLoginValidUserPassword() throws InterruptedException {
        user = "Java10";
        password = "qa02test";

        // Assert user text field and enter user
        Assert.assertTrue("Could not validate user field.",object.verifyCanEnterUser(user));
        System.out.println("Verified user field is present. Entered user: "+user);

        // Assert password text field and enter password
        Assert.assertTrue("Could not validate password field.", object.verifyCanEnterPassword(password));
        System.out.println("Verified password field is present. Entered password: "+password);

        // Assert can click
        Assert.assertTrue("Could not validate submit button.", object.verifyCanSubmitCredentials());
        System.out.println("Verified user can submit credentials.");

        // Assert Test genie table loads
        Assert.assertTrue("Could not validate Genie main table.",object.verifyGenieTable("2"));
        System.out.println("Verified Genie table from the Store Operator tab.");

        // Assert Test timecard table loads and punch entered for Monday
        Assert.assertTrue("Could not validate Timecard table for the Current Pay Period.", object.verifytimeCardTable("1"));
        System.out.println("Verified Timecard table on Timecard tab and entered punch IN for Monday for the Current Pay Period.");

        Assert.assertTrue( "Could not validate punch OUT for Monday.", object.verifyPunchOut( "1" ) );
        System.out.println("Verified punch OUT entered for Monday.");

        Assert.assertTrue( "Could not validate punch back IN for Monday.", object.verifyPunchIn( "1" ) );
        System.out.println("Verified punch back IN entered for Monday.");

        Assert.assertTrue( "Could not validate punch OUT End of Day for Monday.", object.verifyPunchOutEndofDay( "1" ) );
        System.out.println("Verified punch OUT End of Day for Monday.");

        Assert.assertTrue( "Could not validate punches for Tuesday.", object.verifyPunchesforTuesday( "1" ) );
        System.out.println("Verified punches for Tuesday.");

        Assert.assertTrue( "Could not validate punches for Wednesday.", object.verifyPunchesforWednesday( "1" ) );
        System.out.println("Verified punches for Wednesday.");

        Assert.assertTrue( "Could not validate punches for Thursday.", object.verifyPunchesforThursday( "1" ) );
        System.out.println("Verified punches for Thursday.");

        Assert.assertTrue( "Could not validate punches for Friday.", object.verifyPunchesforFriday( "1" ) );
        System.out.println("Verified punches for Friday.");

       //Assert.assertTrue( "Could not validate calculated totals.", object.verifyCalculatedTotals( "1" ) );
        //System.out.println("Verified calculated totals.");

    }


    public void verifyLoginInvalidUserValidPassword(){
        user = "Invalid";
        password = "qa02test";
    }


    public void verifyLoginValidUserInvalidPassword(){
        user = "Java10";
        password = "INVALID";
    }

    @AfterClass
    public static void cleanUpKronos(){
        object.syncElement("SECONDS",5);
        object.driver.close();
   }
}
