package domain.entities;

import java.util.List;


public class Address
{
    private String street;
    private String neighborhood;
    private int number;
    private String complement;
    private List<City> city;
    private boolean is_fiscal_address;

    public Address(String street, String neighborhood, int number, String complement, List<City> city, boolean is_fiscal_address) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.is_fiscal_address = is_fiscal_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public boolean isIs_fiscal_address() {
        return is_fiscal_address;
    }

    public void setIs_fiscal_address(boolean is_fiscal_address) {
        this.is_fiscal_address = is_fiscal_address;
    }
}
