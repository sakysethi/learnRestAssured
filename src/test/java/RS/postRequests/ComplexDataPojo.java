package postRequests;

public class ComplexDataPojo {

    private String Country;
    private String Capital;
    private SimpleDataPojo simpleDataPojo;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public SimpleDataPojo getSimpleDataPojo(SimpleDataPojo simpleDataPojo) {
        return this.simpleDataPojo;
    }

    public void setSimpleDataPojo(SimpleDataPojo simpleDataPojo) {
        this.simpleDataPojo = simpleDataPojo;
    }


}
