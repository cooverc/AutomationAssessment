package assessment.test.pages;

import com.assessment.framework.base.BasePage;
import com.assessment.framework.controls.elements.LabelBase;
import com.assessment.framework.utilities.CommonUtil;
import com.assessment.framework.utilities.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    /******************************************************************/
    // Declaration objects page
    /******************************************************************/
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")
    private WebElement myPersonalInformation_Label;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement userName_Label;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    private WebElement singOut_Link;

    /******************************************************************/
    // Declaration of methods
    /******************************************************************/

    public void ValidateUserLogged ()
    {
        try{
            CommonUtil.waitForVisibility(myPersonalInformation_Label);
            Assert.assertEquals(new LabelBase(myPersonalInformation_Label).getText(),Constant.MY_PERSONAL_INFORMATION);
            Assert.assertEquals(new LabelBase(userName_Label).getText(),CommonUtil.getStringHelper());
            Assert.assertTrue(CommonUtil.isElementEnabled(singOut_Link));
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" writeEmail() " + e.toString());
        }
    }
}
