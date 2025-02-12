package domain.entities;

import domain.enuns.ContactType;

import java.util.List;
//TODO CRIAR GET/SET E CONSTRUCTOR
public abstract class Person
{
    protected int id;
    protected List<Address> addresses;
    protected List<Contact> contacts;

    protected void add_address(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("O endereço não pode ser nulo.");
        }

        if (address.getCep() == null || !address.getCep().matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido. Deve conter exatamente 8 dígitos numéricos.");
        }

        if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
            throw new IllegalArgumentException("O logradouro (rua) do endereço não pode ser vazio.");
        }

        if (address.getCity() == null) {
            throw new IllegalArgumentException("A cidade do endereço é obrigatória.");
        }

        this.addresses.add(address);
    }

    protected void add_contact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("O contato não pode ser nulo.");
        }

        ContactType type = contact.getContactType();
        String key = contact.getKey();

        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("A chave do contato não pode ser vazia.");
        }

        switch (type) {
            case EMAIL:
                validateEmail(key);
                break;
            case PHONE:
                validatePhone(key);
                break;
            case ADDRESS:
                validateAddress(key);
                break;
            default:
                throw new IllegalArgumentException("Tipo de contato inválido: " + type);
        }

        this.contacts.add(contact);
    }

    private void validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Formato de e-mail inválido.");
        }
    }

    private void validatePhone(String phone) {
        String phoneRegex = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$";
        if (!phone.matches(phoneRegex)) {
            throw new IllegalArgumentException("Formato de telefone inválido. Use (XX) XXXX-XXXX.");
        }
    }

    private void validateAddress(String address) {
        if (address.length() < 5) {
            throw new IllegalArgumentException("Endereço deve ter pelo menos 5 caracteres.");
        }
    }

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
