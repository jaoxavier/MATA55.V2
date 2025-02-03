package services.dto;

// TODO 1. CRIAR O DTO com informações que serão inseridas em individual
// TODO 2. CRIAR CONSTRUCTOR E GET/SET
public class IndividualTO
{
    private String name;

    public IndividualTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
