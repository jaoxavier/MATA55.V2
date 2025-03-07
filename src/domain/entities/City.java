package domain.entities;

import java.util.List;

public abstract class City {
    private String city;
    private int ibge_code;
    private List<State> states;


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
