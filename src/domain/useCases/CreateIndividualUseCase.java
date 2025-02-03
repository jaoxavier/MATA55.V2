package domain.useCases;

import domain.entities.Individual;
import domain.repositories.IndividualRepository;

public class CreateIndividualUseCase {
    private final IndividualRepository repository;

    public CreateIndividualUseCase(IndividualRepository repository) {
        this.repository = repository;
    }

    Individual execute(Individual individual) {
        if(this.repository.getById(individual.getId()) != null){
            throw new IllegalArgumentException("individual already exists");
        }

        return this.repository.create(individual);
    }
}
