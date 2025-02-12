package services.dto;

import domain.enuns.RelationshipType;

public class AffiliationTO {
    private final String name;
    private final RelationshipType relationship;

    public AffiliationTO(String name, RelationshipType relationship) {
        this.name = name;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public RelationshipType getRelationship() {
        return relationship;
    }
}
