package geolocationtest;

import api.apienums.GeolocationStatus;
import api.apimodels.GeolocationAPIModel;
import api.apiservice.IpAPIService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import utils.CustomFileReader;

import java.io.IOException;
import java.util.List;

public class BaseGeolocationTest {
    public final IpAPIService ipAPIService = new IpAPIService();
    private static final String UA_DOMAINS_FILE_NAME = "UADomains.txt";
    private final String COUNTRY_UKRAINE = "Ukraine";

    public void verifyIfServerIsLocatedInUkraine(GeolocationAPIModel geolocationAPIModel) {
        Assert.assertEquals(geolocationAPIModel.getStatus(), GeolocationStatus.SUCCESS.getStatus(),
                String.format("Domain name is invalid because status is %s", geolocationAPIModel.getStatus()));
        Assert.assertEquals(geolocationAPIModel.getCountry(), COUNTRY_UKRAINE,
                String.format("Server is not located in UA. Real location is: %s", geolocationAPIModel.getCountry()));
    }

    /**
     * Provides data for testing with domains from the "UADomains.txt" file located in the resources directory.
     *
     * @return a two-dimensional array of objects, where each element represents a domain from the file
     */
    @DataProvider(name = "domainUADataProvider", parallel = true)
    public Object[][] domainUADataProvider() {
        List<String> domains = new CustomFileReader().readDomainsFromFile(UA_DOMAINS_FILE_NAME);
        Object[][] data = new Object[domains.size()][1];
        for (int i = 0; i < domains.size(); i++) {
            data[i][0] = domains.get(i);
        }
        return data;
    }
}
