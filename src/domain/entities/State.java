package domain.entities;

public class State
{
    private int state_code;
    private String state;
    private String uf;

    public State(int state_code, String state, String uf) {
        this.state_code = state_code;
        this.state = state;
        this.uf = uf;
    }

    public int getState_code() {
        return state_code;
    }

    public void setState_code(int state_code) {
        this.state_code = state_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
