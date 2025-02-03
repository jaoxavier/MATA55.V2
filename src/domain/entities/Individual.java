package domain.entities;

import domain.enuns.Gender;
import java.time.LocalDate;
import java.util.List;

public class Individual extends Person {
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthday;
    private Gender gender;
    private List<Affiliation> affiliation;
    private List<City> nationality;
    private String pis;

    private Individual() {}

    public Individual(String name, String cpf, String rg, LocalDate birthday, Gender gender, List<Affiliation> affiliation, List<City> nationality, String pis) {
        validateCpf(cpf);
        validateRg(rg);
        validateBirthday(birthday);
        validatePis(pis);

        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthday = birthday;
        this.gender = gender;
        this.affiliation = affiliation;
        this.nationality = nationality;
        this.pis = pis;
    }

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
        validateCpf(cpf); this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        validateRg(rg); this.rg = rg;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        validateBirthday(birthday); this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Affiliation> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(List<Affiliation> affiliation) {
        this.affiliation = affiliation;
    }

    public List<City> getNationality() {
        return nationality;
    }

    public void setNationality(List<City> nationality) {
        this.nationality = nationality;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        validatePis(pis); this.pis = pis;
    }

    private boolean isValidCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public void validateCpf(String cpf) {
        if (!isValidCpf(cpf)) throw new IllegalArgumentException("CPF inválido! Deve conter exatamente 11 dígitos numéricos.");
    }

    private boolean isValidRg(String rg) {
        return rg != null && rg.matches("\\d{9}");
    }

    public void validateRg(String rg) {
        if (!isValidRg(rg)) throw new IllegalArgumentException("RG inválido! Deve conter exatamente 9 dígitos numéricos.");
    }

    private boolean isValidBirthday(LocalDate birthday) {
        return birthday != null && !birthday.isAfter(LocalDate.now());
    }

    public void validateBirthday(LocalDate birthday) {
        if (!isValidBirthday(birthday)) throw new IllegalArgumentException("A data de nascimento é obrigatória e não pode ser no futuro.");
    }

    private boolean isValidPis(String pis) {
        return pis == null || pis.matches("\\d{11}");
    }

    public void validatePis(String pis) {
        if (!isValidPis(pis)) throw new IllegalArgumentException("PIS inválido! Deve conter exatamente 11 dígitos numéricos.");
    }

    @Override
    protected boolean validate_document(String document) {
        return false;
    }
}
