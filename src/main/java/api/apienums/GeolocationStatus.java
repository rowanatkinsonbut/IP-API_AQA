package api.apienums;

public enum GeolocationStatus {
    SUCCESS("success"),
    FAIL("fail");

    private final String status;

    GeolocationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

