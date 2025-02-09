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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactType=" + contactType +
                ", key='" + key + '\'' +
                '}';
    }
}
