package assessment.test.steps;

import com.assessment.framework.base.DriverContext;
import com.assessment.framework.base.FrameworkInitialize;
import com.assessment.framework.config.ConfigReader;
import com.assessment.framework.config.Settings;
import com.assessment.framework.utilities.CommonUtil;
import com.assessment.framework.utilities.LogUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize(Scenario scenario) throws Exception {

        //Initialize Config
        ConfigReader.PopulateSettings();

        //Logging
        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework Initialize");

        InitializeBrowser(Settings.BrowserType, Settings.DeviceType);

        Capabilities cap = ((RemoteWebDriver) DriverContext.Driver).getCapabilities();
        Settings.Logs.Write("Device - Browser initialized :: Platform [" + cap.getPlatform() + "] - Browser [" + cap.getBrowserName() + "] - Version [" + cap.getVersion() + "]");
        DriverContext.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @After
    public void TearDown(Scenario scenario) {


        if (scenario.isFailed()) {
            if (!CommonUtil.getFeatureName(scenario.getId()).contains("services")) {
                CommonUtil.embedScreenshot(DriverContext.Driver, scenario);
                CommonUtil.takeScreenshot(DriverContext.Driver, scenario);
            }

        }

        System.out.println("#####################################################################");
        System.out.println("Scenario [" + scenario.getName() + "] - Status [" + scenario.getStatus() + "]");
        System.out.println("#####################################################################");

        CommonUtil.deleteAllCookies();
        if (Settings.BrowserClose.equals("true")) {
            DriverContext.Driver.quit();
        }
    }
}