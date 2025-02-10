package services.dto;

public class CityTO {
    private int city_code;
    private String city;
    private int ibge_code;

    public CityTO(int city_code, String city, int ibge_code) {
        this.city_code = city_code;
        this.city = city;
        this.ibge_code = ibge_code;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
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
