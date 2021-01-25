package assessment.test.steps;

import assessment.test.pages.HomePage;
import assessment.test.pages.ServicePage;
import com.assessment.framework.base.Base;
import com.assessment.framework.config.Settings;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class ServicesSteps extends Base {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    @Then("^I validate GET service response$")
    public void IValidateGETServiceResponse(DataTable dt) {

        Settings.Logs.Write("I validate GET service response");;

        String url = "";

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);


        for(int i=0; i<list.size(); i++) {

            url = Settings.URLService +"alpha/"+ list.get(i).get("Country");
            logger.info("************************   This test is: "+ url );
            new ServicePage().ValidateResponseOK(url);

        }

    }

    @Then("^I validate Post service response$")
    public void IValidatePOSTServiceResponse() {

        new ServicePage().ValidatePOSTServiceResponse();

    }



}
