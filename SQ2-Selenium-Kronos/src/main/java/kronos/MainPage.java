package kronos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.*;

/**
 * Created by RXC8414 on 5/25/2017 added test code lines 14-55.
 * Edited by MXB2320, lines 55 onward.
 * SXS8680 taught MXB2320 new methods and to use div[@style ids for xpaths.
 */
public class MainPage extends Login {

    public String gridRow = ".//div[@id='row@@@@genieGrid']//div[1]//div";
    public By GRID_ROW;
    public static final By GENIE_FRAME = By.xpath( ".//iframe[contains(@id,'iframe_iFrame_')]" );
    public static final By GOTO = By.xpath( ".//button[@class='btn i widget-button-icon LABELICON e']" );
    public static final By GOTO_TIMECARD = By.xpath( ".//a[@class='ng-binding' and contains(text(),'Timecards')]" );
    private String recNumber;


    public MainPage(WebDriver driver) {
        super( driver );
        this.driver = driver;
    }


    public boolean verifyGenieTable(String recNumber)  {
        if (waitUntilElementDisplayed( GENIE_FRAME )) {
            if (switchDriver( "IFRAME", GENIE_FRAME )) {
                if (openGenieRecord( recNumber )) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean openGenieRecord(String recNumber) {
        gridRow = gridRow.replace( "@@@@", recNumber );
        GRID_ROW = By.xpath( gridRow );
        if (waitUntilElementDisplayed( GRID_ROW )) {
            driver.findElement( GRID_ROW ).click();
            syncElement( "SECONDS", 3 );
            if (waitUntilElementDisplayed( GOTO )) {
                driver.findElement( GOTO ).click();
                if (waitUntilElementDisplayed( GOTO_TIMECARD )) {
                    driver.findElement( GOTO_TIMECARD ).click();
                    syncElement( "SECONDS", 3 );
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifytimeCardTable(String recNumber) throws InterruptedException {

        //Verified Timecard Table and punch IN for MONDAY
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 793; width:68px;']" ) ).click();
        Actions actions = new Actions( driver ); // used actions class to focus the element first before sending any text to the cell
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 793; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "8" );
        actions.build().perform();
        return true;
    }

    //Punch OUT for Monday
    public boolean verifyPunchOut(String recNumber) throws InterruptedException {
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 791; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 791; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "12" );
        actions.build().perform();
        return true;

    }

    public boolean verifyPunchIn(String recNumber) throws InterruptedException {
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 790; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 790; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "13" );
        actions.build().perform();
        return true;

    }

    public boolean verifyPunchOutEndofDay(String recNumber) throws InterruptedException {
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 788; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 788; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "17" );
        actions.build().perform();
        return true;
    }


    public boolean verifyPunchesforTuesday(String recNumber) throws InterruptedException {
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 778; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 778; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "8" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 776; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 776; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "12" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 775; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 775; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "13" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 773; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 773; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "17" );
        actions.build().perform();
        return true;


    }

    public boolean verifyPunchesforWednesday(String recNumber) throws InterruptedException {
        this.recNumber = recNumber;
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 763; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 763; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "8" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 761; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 761; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "12" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 760; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 760; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "13" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 758; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 758; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "17" );
        actions.build().perform();
        return true;
    }


    public boolean verifyPunchesforThursday(String recNumber) throws InterruptedException {
        this.recNumber = recNumber;
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 748; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 748; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "8" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 746; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 746; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "12" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 745; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 745; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "13" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 743; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 743; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "17" );
        actions.build().perform();
        return true;

    }

    public boolean verifyPunchesforFriday(String recNumber) throws InterruptedException {
        this.recNumber = recNumber;
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame( 1 );
        driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 733; width:68px;']" ) ).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 390px; z-index: 733; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "8" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 731; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 526px; z-index: 731; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "12" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 730; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 594px; z-index: 730; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "13" );
        actions.build().perform();

        driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 728; width:68px;']" ) ).click();
        actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "//div[@style='left: 730px; z-index: 728; width:68px;']" ) ) );
        actions.click();
        actions.sendKeys( "17" );
        actions.build().perform();
        return true;
    }

}



   /* public boolean verifyCalculatedTotals(String recNumber) throws InterruptedException {
        this.recNumber = recNumber;
        driver.switchTo().defaultContent();
        sleep( 1000 );
        driver.switchTo().frame(0);
        driver.findElement( By.xpath( "//div[@class=''")).click();
        Actions actions = new Actions( driver );
        actions.moveToElement( driver.findElement( By.xpath( "div[@class=" ) ));
        actions.click();
        actions.build().perform();



        return true;

    }

}
*/










