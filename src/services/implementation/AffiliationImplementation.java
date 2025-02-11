package services.implementation;

import domain.entities.Affiliation;
import domain.enuns.RelationshipType;
import services.dto.AffiliationTO;

public class AffiliationImplementation extends Affiliation {
    
    public AffiliationImplementation(String name, RelationshipType relationship) {
        this.name = name;
        this.relationship = relationship;
    }

    public static AffiliationImplementation createFromTO(AffiliationTO dto) {
        return new AffiliationImplementation(dto.getName(), dto.getRelationship());
    }
}
