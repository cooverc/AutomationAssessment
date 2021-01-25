package assessment.test.pages;

import com.assessment.framework.base.BasePage;
import com.assessment.framework.controls.elements.ButtonBase;
import com.assessment.framework.controls.elements.TextBoxBase;
import com.assessment.framework.utilities.CommonUtil;
import com.assessment.framework.utilities.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthenticationPage extends BasePage {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    /******************************************************************/
    // Declaration objects page
    /******************************************************************/
    @FindBy(how = How.ID, using = "email_create")
    private WebElement email_TextBox;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement createAccount_Button;

    /******************************************************************/
    // Declaration of methods
    /******************************************************************/

    public void writeEmail()
    {
        try{
            String email = CommonUtil.generateRandomWord() + "@gmail.com";
            new TextBoxBase(email_TextBox).EnterText(email);
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" writeEmail() " + e.toString());
        }
    }

    public void ClickCreateAnAccountButton()
    {
        try{
            new ButtonBase(createAccount_Button).click();
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" isPageLoad() " + e.toString());
        }
    }
}
