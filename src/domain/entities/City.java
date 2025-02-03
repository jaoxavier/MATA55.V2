package domain.entities;

import java.util.List;

//TODO CRIAR GET/SET E CONSTRUCTOR
public class City {
    private int city_code;
    private String city;
    private int ibge_code;
    private List<State> states;

    // CONSTRUCTOR
    public City(int city_code, String city, int ibge_code, List<State> states) {
        this.city_code = city_code;
        this.city = city;
        this.ibge_code = ibge_code;
        this.states = states;
    }

    // GET E SET
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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
