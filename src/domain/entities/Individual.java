package domain.entities;

import domain.enuns.Gender;

import java.util.List;

//TODO 5. CRIAR GET/SET DE INDIVIDUAL OBS.: O SET DE CPF PRECISA SER VALIDADO COM VALIDATE_DOCUMENT
public abstract class Individual extends Person
{
    private String name;
    private String cpf;
    private String rg;
    private String pis;
    private String birthday;
    private Gender gender;
    private List<Affiliation> affiliation;
    private List<City> nationality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected boolean validate_document(String document)
    {
        // TODO 4. VALIDATE CPF DOCUMENTO PRINCIPAL
        return false;
    }

    // TODO 9. CRIAR VALIDAÇÕES PARA OUTROS DOCUMENTOS RG/PIS
}
