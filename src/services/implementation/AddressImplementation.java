package services.implementation;

import domain.entities.Address;
import services.dto.AddressTO;

public class AddressImplementation extends Address {
    public void address_implementation(AddressTO dto)
    {
        super.setIs_fiscal_address(dto.getFiscalAddress());
        super.setCity(dto.getCity());
        super.setComplement(dto.getComplement());
        super.setNumber(dto.getNumber());
        super.setNeighborhood(dto.getNeighborhood());
        super.setStreet(dto.getStreet());
        super.setCep(dto.getCep());
    }


    
    


    
    
}
