package services.dto;

import domain.enuns.ContactType;

public class ContactTO {
    private Long id;
    private ContactType contactType;
    private String key;

    public ContactTO(Long id, ContactType contactType, String key) {
        this.id = id;
        this.contactType = contactType;
        this.key = key;
    }

    public Long getId() { return id; }
    public ContactType getContactType() { return contactType; }
    public String getKey() { return key; }

    public void setId(Long id) { this.id = id; }
    public void setContactType(ContactType contactType) { this.contactType = contactType; }
    public void setKey(String key) { this.key = key; }
}

