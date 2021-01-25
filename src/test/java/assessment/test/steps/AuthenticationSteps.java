package assessment.test.steps;

import assessment.test.pages.AuthenticationPage;
import com.assessment.framework.base.Base;
import com.assessment.framework.config.Settings;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class AuthenticationSteps extends Base {

    private static final Logger logger = Logger.getLogger(HomeSteps.class);

    @And("^Fill a valid email$")
    public void FillAValidEmail() {
        Settings.Logs.Write("Fill a valid email");
        CurrentPage = GetInstance(AuthenticationPage.class);
        CurrentPage.As(AuthenticationPage.class).writeEmail();
    }

    @And("^Click Create an Account button$")
    public void ClickCreateAnAccountButton() {
        Settings.Logs.Write("Click Create an Account button");
        CurrentPage = GetInstance(AuthenticationPage.class);
        CurrentPage.As(AuthenticationPage.class).ClickCreateAnAccountButton();
    }

}
