package services.implementation;

import domain.entities.State;
import services.dto.StateTO;

public class StateImplementation extends State {
    
    public StateImplementation(int state_code, String state, String uf) {
        super.state_code = state_code;
        super.state = state;
        super.uf = uf;
    }

    public static StateImplementation createFromTO(StateTO dto) {
        return new StateImplementation(dto.getState_code(), dto.getState(), dto.getUf());
    }
}
