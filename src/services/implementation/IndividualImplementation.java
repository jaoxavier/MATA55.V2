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
        super.setCpf(dto.getCpf());
        super.setRg(dto.getRg());
        super.setBirthday(dto.getBirthday());
        super.setGender(dto.getGender());
        super.setAffiliation(dto.getAffiliation());
        super.setNationality(dto.getNationality());
        super.setPis(dto.getPis());

    }
}
