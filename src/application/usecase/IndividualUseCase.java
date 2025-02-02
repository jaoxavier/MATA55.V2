package application.usecase;

import domain.entities.Individual;

import java.time.LocalDate;

public class IndividualUseCase {

    public boolean validateIndividual(Individual individual) {
        validateCpf(individual.getCpf());
        validateRg(individual.getRg());
        validateBirthday(individual.getBirthday());
        validatePis(individual.getPis());

        return true;
    }

    private void validateCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido! Deve conter exatamente 11 dígitos numéricos.");
        }
    }

    private void validateRg(String rg) {
        if (rg == null || !rg.matches("\\d{9}")) {
            throw new IllegalArgumentException("RG inválido! Deve conter exatamente 9 dígitos numéricos.");
        }
    }

    private void validateBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("A data de nascimento é obrigatória.");
        }
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser no futuro.");
        }
    }

    private void validatePis(String pis) {
        if (pis != null && !pis.matches("\\d{11}")) {
            throw new IllegalArgumentException("PIS inválido! Deve conter exatamente 11 dígitos numéricos.");
        }
    }
}
