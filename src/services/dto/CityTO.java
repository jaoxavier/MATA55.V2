package services.dto;

public class CityTO {
    private String city;
    private int ibge_code;

    public CityTO(String city, int ibge_code) {
        this.city = city;
        this.ibge_code = ibge_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIbge_code() {
        return ibge_code;
    }

    public void setIbge_code(int ibge_code) {
        this.ibge_code = ibge_code;
    }
}
