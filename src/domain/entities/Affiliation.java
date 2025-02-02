package domain.entities;

import domain.enuns.RelationshipType;

public class Affiliation {
    private String name;
    private RelationshipType relationship;

    public Affiliation() {
    }

    public Affiliation(String name, RelationshipType relationship) {
        this.name = name;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RelationshipType getRelationship() {
        return relationship;
    }

    public void setRelationship(RelationshipType relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "domain.entities.Affiliation{name='" + name + "', relationship=" + relationship + "}";
    }
}

