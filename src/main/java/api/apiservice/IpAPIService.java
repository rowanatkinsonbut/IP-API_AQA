package api.apiservice;

import api.apiclient.IpAPIClient;
import api.apimodels.GeolocationAPIModel;
import io.qameta.allure.Step;

public class IpAPIService {
    private final IpAPIClient ipAPIClient;

    public IpAPIService() {
        this.ipAPIClient = new IpAPIClient();
    }

    /**
     * Retrieves IP geolocation data for the given address name.
     *
     * @param addressName the address name for which to retrieve geolocation data
     * @return an {@link GeolocationAPIModel} object representing the geolocation data
     * @throws RuntimeException if an unexpected response type is received or if there is an error processing the response
     */
    @Step("GET geolocation data for address: {addressName}")
    public GeolocationAPIModel getIpGeolocationData(String addressName) {
        return (GeolocationAPIModel) ipAPIClient.getWithQueryParameter(addressName, GeolocationAPIModel.class);
    }
}
