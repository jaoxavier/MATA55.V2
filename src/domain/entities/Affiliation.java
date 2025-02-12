package domain.entities;

import domain.enuns.RelationshipType;

public abstract class Affiliation {
    protected String name;
    protected RelationshipType relationship;

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
