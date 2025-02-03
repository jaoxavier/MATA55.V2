package domain.entities;

import domain.enuns.Gender;
import java.time.LocalDate;
import java.util.List;

public abstract class Individual extends Person {
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthday;
    private Gender gender;
    private List<Affiliation> affiliation;
    private List<City> nationality;
    private String pis;

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

    public static boolean isValidCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        return isValidCheckDigits(cpf);
    }

    private static boolean isValidCheckDigits(String cpf) {
        int[] numbers = cpf.chars().map(Character::getNumericValue).toArray();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += numbers[i] * (10 - i);
        }
        int firstCheckDigit = (sum * 10) % 11;
        if (firstCheckDigit == 10) firstCheckDigit = 0;
        if (numbers[9] != firstCheckDigit) return false;
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numbers[i] * (11 - i);
        }
        int secondCheckDigit = (sum * 10) % 11;
        if (secondCheckDigit == 10) secondCheckDigit = 0;
        return numbers[10] == secondCheckDigit;
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

    public static boolean isValidPis(String pis) {
        if (pis == null || !pis.matches("\\d{11}")) {
            return false;
        }

        return isValidCheckDigit(pis);
    }


    private static boolean isValidCheckDigit(String pis) {
        int[] multipliers = {3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;

        for (int i = 0; i < multipliers.length; i++) {
            sum += Character.getNumericValue(pis.charAt(i)) * multipliers[i];
        }

        int remainder = sum % 11;
        int checkDigit = remainder < 2 ? 0 : (11 - remainder);

        return checkDigit == Character.getNumericValue(pis.charAt(10));
    }

    public static void validatePis(String pis) {
        if (!isValidPis(pis)) {
            throw new IllegalArgumentException("PIS inválido! Deve conter exatamente 11 dígitos numéricos e seguir o padrão oficial.");
        }
    }

    @Override
    protected boolean validate_document(String cpf) {
        return isValidCpf(cpf);
    }
}
