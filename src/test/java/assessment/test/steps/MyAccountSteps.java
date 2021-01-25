package assessment.test.steps;

import assessment.test.pages.MyAccountPage;
import com.assessment.framework.base.Base;
import com.assessment.framework.config.Settings;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class MyAccountSteps extends Base {

    private static final Logger logger = Logger.getLogger(HomeSteps.class);

    @And("^Validate user is logged$")
    public void ValidateUserLogged() {
        Settings.Logs.Write("Fill a valid email");
        CurrentPage = GetInstance(MyAccountPage.class);
        CurrentPage.As(MyAccountPage.class).ValidateUserLogged();
    }
}
