package services.implementation;

import domain.entities.Individual;
import services.dto.IndividualTO;

// TODO 3. INDIVIDUAL_IMPLEMENTATION PRECISA COMPLETAR INDIVIDUAL ATRÁVES DO SUPER COM AS INFORMAÇÕES DO DTO
public class IndividualImplementation extends Individual
{
    public IndividualImplementation(IndividualTO dto) {
        individual_implementation(dto);
    }

    public void individual_implementation(IndividualTO dto)
    {
        super.setName(dto.getName());
    }
}
