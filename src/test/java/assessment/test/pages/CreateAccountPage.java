package assessment.test.pages;

import com.assessment.framework.base.BasePage;
import com.assessment.framework.controls.elements.ButtonBase;
import com.assessment.framework.controls.elements.ComboBase;
import com.assessment.framework.controls.elements.HyperLinkBase;
import com.assessment.framework.controls.elements.TextBoxBase;
import com.assessment.framework.utilities.CommonUtil;
import com.assessment.framework.utilities.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPage extends BasePage {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    /******************************************************************/
    // Declaration objects page
    /******************************************************************/
    @FindBy(how = How.ID, using = "id_gender1")
    private WebElement title_RadioButton;

    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement firstName_TextBox;

    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement lastName_TextBox;

    @FindBy(how = How.ID, using = "company")
    private WebElement company_TextBox;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement password_TextBox;

    @FindBy(how = How.ID, using = "address1")
    private WebElement address_TextBox;

    @FindBy(how = How.ID, using = "city")
    private WebElement city_TextBox;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement postalCode_TextBox;

    @FindBy(how = How.ID, using = "phone")
    private WebElement homePhone_TextBox;

    @FindBy(how = How.ID, using = "alias")
    private WebElement addressAlias_TextBox;

    @FindBy(how = How.ID, using = "id_state")
    private WebElement state_Combo;

    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement register_Button;

    /******************************************************************/
    // Declaration of methods
    /******************************************************************/

    public void FillRegistrationInformation()
    {

        try{

            String userFName= CommonUtil.generateRandomWord();
            String userLName= CommonUtil.generateRandomWord();
            CommonUtil.setStringHelper(userFName+" "+userLName);
            CommonUtil.waitForVisibility(title_RadioButton);
            new HyperLinkBase(title_RadioButton).click();
            new TextBoxBase(firstName_TextBox).EnterText(userFName);
            new TextBoxBase(lastName_TextBox).EnterText(userLName);
            new TextBoxBase(password_TextBox).EnterText(CommonUtil.generateRandomWord());
            new TextBoxBase(company_TextBox).EnterText(CommonUtil.generateRandomWord());
            new TextBoxBase(address_TextBox).EnterText(CommonUtil.generateRandomWord());
            new TextBoxBase(city_TextBox).EnterText(CommonUtil.generateRandomWord());
            new ComboBase(state_Combo).GetClickFirstTextValue();
            new TextBoxBase(postalCode_TextBox).EnterText("35242");
            new TextBoxBase(homePhone_TextBox).EnterText(CommonUtil.generateRandomNumber());
            new TextBoxBase(addressAlias_TextBox).EnterText(CommonUtil.generateRandomWord());
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" FillRegistrationInformation() " + e.toString());
        }
    }

    public void ClickRegisterButton(){
        try{
            new ButtonBase(register_Button).click();
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+ "public void ClickRegisterButton() " + e.toString());
        }
    }
}
