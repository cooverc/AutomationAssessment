package assessment.test.pages;

import com.assessment.framework.base.BasePage;
import com.assessment.framework.config.Settings;
import com.assessment.framework.utilities.Constant;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ServicePage extends BasePage {

    private String url = Settings.URLService + "all";

    private static final Logger logger = Logger.getLogger(HomePage.class);

    public void ValidateGETServiceResponse()
    {
        try{
            int responseStatus = given().when().get(this.url).getStatusCode();
            Assert.assertEquals(HttpStatus.SC_OK, responseStatus);
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" ValidateGETServiceResponse() " + e.toString());
        }
    }

    public void ValidateResponseOK(String url)
    {
        try{
            int responseStatus = given().when().get(url).getStatusCode();
            Assert.assertEquals(HttpStatus.SC_OK, responseStatus);
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" ValidateResponseOK() " + e.toString());
        }
    }

    public void ValidatePOSTServiceResponse()
    {
        try{
            Map<String,String> country = new HashMap<>();
            country.put("name", "Test Country");
            country.put("alpha2_code", "TC");
            country.put("alpha3_code", "TCY");

            given()
                    .contentType("application/json")
                    .body(country)
                    .when().post("/garage/slots").then()
                    .statusCode(200);
        }
        catch (Exception e){
            logger.error(Constant.MESSAGE_ERROR_METHOD+" ValidateGETServiceResponse() " + e.toString());
        }
    }
}
