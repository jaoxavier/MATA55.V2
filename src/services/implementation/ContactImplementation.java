package services.implementation;

import domain.entities.Contact;
import domain.enuns.ContactType;
import domain.exceptions.InvalidContactKeyException;
import services.dto.ContactTO;

public class ContactImplementation extends Contact {


    public ContactImplementation(ContactTO dto) {
        super(dto.getId(), dto.getContactType(), dto.getKey());
        contact_implementation(dto);
    }

    public void contact_implementation(ContactTO dto) {
        super.setContactType(dto.getContactType());
        super.setKey(validateKeyByType(dto.getContactType(), dto.getKey()) ? dto.getKey() : errorKey());
    }

    private boolean validateKeyByType(ContactType type, String key) {
        switch (type) {
            case EMAIL:
                return isValidEmail(key);
            case PHONE:
                return isValidPhone(key);
            case ADDRESS:
                return key != null && !key.trim().isEmpty();
            default:
                return false;
        }
    }

    private String errorKey() {
        throw new InvalidContactKeyException("A chave do contato é inválida para o tipo especificado.");
    }

    @Override
    public void validateKeyByType() throws InvalidContactKeyException {
        String key = getKey();
        ContactType type = getContactType();

        switch (type) {
            case EMAIL:
                if (!isValidEmail(key)) {
                    throw new InvalidContactKeyException("Email inválido: " + key);
                }
                break;

            case PHONE:
                if (!isValidPhone(key)) {
                    throw new InvalidContactKeyException("Telefone inválido: " + key);
                }
                break;

            case ADDRESS:
                if (key == null || key.trim().isEmpty()) {
                    throw new InvalidContactKeyException("Endereço inválido: A chave não pode ser vazia.");
                }
                break;

            default:
                throw new InvalidContactKeyException("Tipo de contato desconhecido.");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+?\\d{10,15}$");
    }
}
