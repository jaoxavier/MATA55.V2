package domain.entities;

public class Contact {

    public enum ContactType {
        EMAIL,
        PHONE,
        ADDRESS
    }

    private Long id;
    private ContactType contactType;
    private String key;
    private Person person;

    
    public Contact(Long id, ContactType contactType, String key, Person person) {
        this.id = id;
        this.contactType = contactType;
        this.key = key;
        this.person = person;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
    @Override
    public String toString() {
        return "domain.entities.Contact{id=" + id +
                ", contactType=" + contactType +
                ", key='" + key + 
                "', person=" + person + "}";
    }
}
