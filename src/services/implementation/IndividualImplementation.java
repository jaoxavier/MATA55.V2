package services.implementation;

import domain.entities.Individual;
import services.dto.IndividualTO;

import java.time.LocalDate;

public class IndividualImplementation extends Individual
{
    public IndividualImplementation(IndividualTO dto) {
        individual_implementation(dto);
    }

    public void individual_implementation(IndividualTO dto)
    {
        super.setName(dto.getName());
        super.setCpf(validate_document(dto.getCpf()) ? dto.getCpf() : errorCpf());
        super.setRg(isValidRg(dto.getRg()) ? dto.getRg() : errorRg());
        super.setBirthday(isValidBirthday(dto.getBirthday()) ? dto.getBirthday() : errorBirthday());
        super.setGender(dto.getGender());
        super.setAffiliation(dto.getAffiliation());
        super.setNationality(dto.getNationality());
        super.setPis(isValidPis(dto.getPis()) ? dto.getPis() : errorPis());
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


    private boolean isValidRg(String rg) {
        return rg != null && rg.matches("\\d{9}");
    }

    public String errorCpf() {
        throw new IllegalArgumentException("CPF inválido!");
    }

    public String errorRg() {
        throw new IllegalArgumentException("RG inválido!");
    }

    public LocalDate errorBirthday() {
        throw new IllegalArgumentException("A data de nascimento é obrigatória e não pode ser no futuro.");
    }

    public String errorPis() {
            throw new IllegalArgumentException("PIS inválido! Deve conter exatamente 11 dígitos numéricos e seguir o padrão oficial.");
    }

    private boolean isValidBirthday(LocalDate birthday) {
        return birthday != null && !birthday.isAfter(LocalDate.now());
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


    @Override
    protected boolean validate_document(String document) {
        return isValidCpf(document);
    }
}
