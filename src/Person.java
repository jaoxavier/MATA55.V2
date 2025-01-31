import java.util.List;
//TODO CRIAR GET/SET E CONSTRUCTOR
public abstract class Person
{
    protected int id;
    protected List<Address> addresses;
    protected List<Contact> contacts;

    protected void add_address(Address address)
    {
        if (address != null){
            this.addresses.add(address);
        }
    }


    //TODO ADICIONAR CONTATO
    protected void add_contact(Contact contact)
    {

    }

    protected abstract boolean validate_document(String document);


    //TODO GET E SET DE PERSON
}
