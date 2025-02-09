package domain.entities;

import java.util.List;
//TODO CRIAR GET/SET E CONSTRUCTOR
public abstract class Person
{
    protected int id;
    protected List<Address> addresses;
    protected List<Contact> contacts;

    protected abstract void add_address(Address address);

    protected abstract void add_contact(Contact contact);

    protected abstract boolean validate_document(String document);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
