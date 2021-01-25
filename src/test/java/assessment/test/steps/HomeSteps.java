package assessment.test.steps;

import assessment.test.pages.HomePage;
import com.assessment.framework.base.Base;
import com.assessment.framework.base.DriverContext;
import com.assessment.framework.config.Settings;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

public class HomeSteps extends Base {

    private static final Logger logger = Logger.getLogger(HomeSteps.class);

    @Given("^Go to TestSite$")
    public void GoToTestSite() {
        DriverContext.Browser.GoToUrl(Settings.URLbase);
        DriverContext.Browser.Maximize();

        Settings.Logs.Write("Navigated to URL " + Settings.URLbase);
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage.As(HomePage.class).isPageLoaded();
    }

    @Given("^Click Sign in link$")
    public void ClickSignInLink() {
        Settings.Logs.Write("Click Sign in link");
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage.As(HomePage.class).ClickSignInLink();
    }

}
