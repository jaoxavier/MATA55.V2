package services.implementation;

import domain.entities.Address;
import domain.entities.Company;
import domain.entities.Contact;
import services.dto.CompanyTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CompanyImplementation extends Company {

    public CompanyImplementation(CompanyTO dto) {
        company_implementation(dto);
    }

    public void company_implementation(CompanyTO companyTO){
        super.setCnpj(validate_document(companyTO.getCnpj()) ? companyTO.getCnpj() : errorCNPJ());
        super.setNomeFantasia(companyTO.getNomeFantasia());
        super.setRazaoSocial(companyTO.getRazaoSocial());
        super.setDataAbertura(validate_data_abertura(companyTO.getDataAbertura()) ? companyTO.getDataAbertura() : error_data_abertura());
        super.setNaturezaJuridica(companyTO.getNaturezaJuridica());
        super.setStatus(companyTO.getStatus());
        super.setSite(companyTO.getSite());
        super.setInscricaoEstadual(companyTO.getInscricaoEstadual());
        super.setInscricaoMunicipal(companyTO.getInscricaoMunicipal());
    }

    private String errorCNPJ() {
        throw new IllegalArgumentException("CNPJ inválido!");
    }


    private String error_data_abertura() {
        throw new IllegalArgumentException("Data inválido!");
    }

    private boolean validate_data_abertura(String dataAbertura) {
        if(dataAbertura == null){
            return false;
        }

        if(!is_data_valida(dataAbertura)){
            return false;
        }

        LocalDate dataFomatada = formata_data(dataAbertura);
        LocalDate dataAtual = LocalDate.now();
        if(dataFomatada.isAfter(dataAtual)) {
            return false;
        }

        return  true;
    }


    public static boolean is_data_valida(String data) {
        try {
            formata_data(data);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static LocalDate formata_data(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }



    @Override
    protected void add_address(Address address) {

    }

    @Override
    protected void add_contact(Contact contact) {

    }

    @Override
    protected boolean validate_document(String cnpj){
        if(cnpj == null){
            return false;
        }
        cnpj = cnpj.replaceAll("\\D", "");

        if(cnpj.length() != 14){
            return false;
        }
        int[] tabela1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito1 = calcularDigito(cnpj, tabela1);

        int[] tabela2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int digito2 = calcularDigito(cnpj, tabela2);

        if (digito1 == (cnpj.charAt(12) - '0') && digito2 == (cnpj.charAt(13) - '0')){
            return true;
        }
        return false;
    }

    private int calcularDigito(String cnpj, int[] tabela){
        int sum = 0;
        for (int i = 0; i < tabela.length; i++){
            sum += (cnpj.charAt(i) - '0') * tabela[i];
        }
        if (sum % 11 < 2){
            return 0;
        }
        else return 11 - (sum % 11);
    }
}