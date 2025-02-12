package services.implementation;

import domain.entities.Affiliation;
import domain.enuns.RelationshipType;
import services.dto.AffiliationTO;

public class AffiliationImplementation extends Affiliation {
    
    public AffiliationImplementation(AffiliationTO dto) {
        super.name = !dto.getName().isEmpty() ? dto.getName() : errorNull();
        super.relationship = !(dto.getRelationship() == null) ? dto.getRelationship() : RelationshipType.valueOf(errorNull());
    }

    public String errorNull()
    {
        throw new IllegalArgumentException("can't be null");
    }
}
