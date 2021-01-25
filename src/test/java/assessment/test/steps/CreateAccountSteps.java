package assessment.test.steps;

import assessment.test.pages.CreateAccountPage;
import com.assessment.framework.base.Base;
import com.assessment.framework.config.Settings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

public class CreateAccountSteps extends Base {

    private static final Logger logger = Logger.getLogger(HomeSteps.class);

    @Given("^Fill the Registration information$")
    public void FillTheRegistrationInformation() {
        Settings.Logs.Write("Click Sign in link");
        CurrentPage = GetInstance(CreateAccountPage.class);
        CurrentPage.As(CreateAccountPage.class).FillRegistrationInformation();
    }

    @And("^Click Register button$")
    public void ClickRegisterButton() {
        Settings.Logs.Write("Click Create an Account button");
        CurrentPage = GetInstance(CreateAccountPage.class);
        CurrentPage.As(CreateAccountPage.class).ClickRegisterButton();
    }
}
