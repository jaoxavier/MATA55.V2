package services.implementation;

import domain.entities.Address;
import domain.entities.City;
import services.dto.AddressTO;

import java.util.List;

public class AddressImplementation extends Address {
    public AddressImplementation(AddressTO dto)
    {
        address_implementation(dto);
    }

    public void address_implementation(AddressTO dto)
    {
        super.setIs_fiscal_address(dto.getFiscalAddress());
        super.setCity(dto.getCity());
        super.setComplement(dto.getComplement());
        super.setNumber(dto.getNumber());
        super.setNeighborhood(dto.getNeighborhood());
        super.setStreet(dto.getStreet());
        super.setCep(isValidCep(dto.getCep()) ? dto.getCep() : errorCep());
    }

    public String errorCep() {
        throw new IllegalArgumentException("CEP inválido. O CEP deve conter 8 dígitos numéricos.");
    }

    private boolean isValidCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }


    
    
}
