package services.implementation;

import domain.entities.City;
import services.dto.CityTO;

public class CityImplementation extends City {
    
    public void city_implementation(CityTO cityTO) {
        super.setCity(cityTO.getCity());
        super.setIbge_code(validate_ibge_code(cityTO.getIbge_code()));
    }

    public static String validate_ibge_code(int ibge_code){
      
      // Transformar int em String
      String code = String.valueOf(ibge_code);

      // Verifica se atende os requisitos de 7 digitos para o codigo IBGE
      if (code.length() != 7) {
          throw new IllegalArgumentException ("O código IBGE deve conter 7 dígitos no maximo");
      
      }
        return Integer.parseInt(code);
    }

}
