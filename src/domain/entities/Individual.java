package domain.entities;

import domain.enuns.Gender;

import java.util.List;

//TODO FALTA FAZER GET/SET DOS ATRIBUTOS QUE CONTÉM UMA LISTA
public class Individual extends Person
{
    private String name;
    private String cpf;
    private String rg;
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
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    

    @Override
    protected boolean validate_document(String cpf)
    {
        if(cpf == null){
            return false;
        }
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] tabela1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito1 = calcularDigito(cpf, tabela1);

        int[] tabela2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito2 = calcularDigito(cpf, tabela2);

        if ((digito1 == (cpf.charAt(9) - '0' )) && (digito2 == (cpf.charAt(10) - '0'))){
            return true;
        }
        return false;

       
    }
    
    private int calcularDigito(String cpf, int[] tabela){
        int sum = 0;
        for(int i = 0; i < tabela.length; i++){
            sum += (cpf.charAt(i) - '0') * tabela[i];
        }
        int resto = ((sum * 10) % 11);
        
        if (resto == 10){
            return 0;
        }

        return resto;  
    }
    
}
