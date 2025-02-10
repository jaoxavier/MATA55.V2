package services.implementation;

import domain.entities.City;
import services.dto.CityTO;

public class CityImplementation extends City {
    
    public void city_implementation(CityTO cityTO) {
        super.setCity_code(cityTO.getCity_code());
        super.setCity(cityTO.getCity());
        super.setIbge_code(cityTO.getIbge_code());
    }
}
