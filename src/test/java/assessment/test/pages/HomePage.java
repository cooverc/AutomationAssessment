package assessment.test.pages;

import com.assessment.framework.base.BasePage;
import com.assessment.framework.controls.elements.HyperLinkBase;
import com.assessment.framework.utilities.CommonUtil;
import com.assessment.framework.utilities.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    /******************************************************************/
    // Declaration objects page
    /******************************************************************/
    @FindBy(how = How.ID, using = "header_logo")
    private WebElement headerLogo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signIn_Link;


    /******************************************************************/
    // Declaration of methods
    /******************************************************************/


    public boolean isPageLoaded()
    {
        return CommonUtil.isElementDisplayed(headerLogo);
    }

    public void ClickSignInLink()
    {
        try{
            new HyperLinkBase(signIn_Link).ClickLink();
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" isPageLoad() " + e.toString());
        }
    }
}
