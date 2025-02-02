package domain.entities;

import domain.enuns.Gender;

import java.util.List;

//TODO CRIAR GET/SET E CONSTRUCTOR
public class Individual extends Person
{
    private String name;
    private String cpf;
    private String rg;
    private String birthday;
    private Gender gender;
    private List<Affiliation> affiliation;
    private List<City> nationality;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected boolean validate_document(String document)
    {
        return false;
    }
}
