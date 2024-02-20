package geolocationtest;

import api.apimodels.GeolocationAPIModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class VerifyCountryOfServerByDomainTest extends BaseGeolocationTest {

    @Test(dataProvider = "domainUADataProvider", threadPoolSize = 3)
    @Feature("IP-API Demo")
    @Story("GET http://ip-api.com/json/{domainName}")
    public void verifyCountryOfServerByDomainTest(String domainName) {
        GeolocationAPIModel geolocationAPIModel = ipAPIService.getIpGeolocationData(domainName);
        verifyIfServerIsLocatedInUkraine(geolocationAPIModel);
    }
}
