package services.dto;

import domain.entities.Affiliation;
import domain.entities.City;
import domain.enuns.Gender;

import java.time.LocalDate;
import java.util.List;

public class IndividualTO {
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthday;
    private Gender gender;
    private List<Affiliation> affiliation;
    private List<City> nationality;
    private String pis;

    public IndividualTO(String name, String cpf, String rg, LocalDate birthday, Gender gender, List<Affiliation> affiliation, List<City> nationality, String pis) {
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
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
        this.pis = pis;
    }
}
