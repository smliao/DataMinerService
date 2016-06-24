package domain;

public enum DataMinerServiceUrls implements ResourceUrl {


    createUserProfile("http://localhost:8888/data-miner-service/user-profile");

    private final String url;


    @Override
    public String value() {
        return url;
    }

    DataMinerServiceUrls(String url) {
        this.url = url;
    }
}
