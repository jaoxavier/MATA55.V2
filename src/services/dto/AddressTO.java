package services.dto;

import domain.entities.City;
import java.util.List;

public class AddressTO {
    private String cep;
    private String street;
    private String neighborhood;
    private int number;
    private String complement;
    private List<City> city;
    private boolean isFiscalAddress;

    public AddressTO(String cep, String street, String neighborhood, int number, String complement, List<City> city, boolean isFiscalAddress) {
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.isFiscalAddress = isFiscalAddress;
    }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getComplement() { return complement; }
    public void setComplement(String complement) { this.complement = complement; }

    public List<City> getCity() { return city; }
    public void setCity(List<City> city) { this.city = city; }

    public boolean getFiscalAddress() { return isFiscalAddress; }
    public void setFiscalAddress(boolean isFiscalAddress) { this.isFiscalAddress = isFiscalAddress; }
}
