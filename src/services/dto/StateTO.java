package services.dto;

public class StateTO {
    private final int state_code;
    private final String state;
    private final String uf;

    public StateTO(int state_code, String state, String uf) {
        this.state_code = state_code;
        this.state = state;
        this.uf = uf;
    }

    public int getState_code() {
        return state_code;
    }

    public String getState() {
        return state;
    }

    public String getUf() {
        return uf;
    }
}