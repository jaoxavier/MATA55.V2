package services.implementation;

import domain.entities.Address;
import domain.entities.Company;
import domain.entities.Contact;
import services.dto.CompanyTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        super.setInscricaoEstadual(validate_inscricao_estadual(companyTO.getInscricaoEstadual()) ? companyTO.getInscricaoEstadual() : error_inscricao_estadual());
        super.setInscricaoMunicipal(companyTO.getInscricaoMunicipal());
    }

    private String errorCNPJ() {
        throw new IllegalArgumentException("CNPJ inválido!");
    }


    private String error_inscricao_estadual() {
        throw new IllegalArgumentException("Inscrição estadual inválida!");
    }

    private boolean validate_inscricao_estadual(String inscricaoEstadual) {
        if(inscricaoEstadual == null){
            return false;
        }

        // O número da IE é composto entre nove e 14 dígitos (a depender do estado) e está dividido em três partes:
        // Os dois primeiros dígitos são o código do estado onde a empresa é cadastrada;
        // Os próximos seis dígitos (ou mais) são os números da inscrição de cada empresa;
        // O último dígito é o verificador ou o dígito de controle.
        String regexFormato = "^(\\d{2})\\.?(\\d{6,14})-?(\\d)$";

        Pattern pattern = Pattern.compile(regexFormato);
        Matcher matcher = pattern.matcher(inscricaoEstadual);

        if (!matcher.matches()) {
            return false;
        }
        String numeroInscricao = matcher.group(2);
        String codigoVerificador = matcher.group(3);

        return validaCodigoVerificaor(numeroInscricao, codigoVerificador);
    }

    private boolean validaCodigoVerificaor(String numeroInscricao,String codigoVerificador){
        String codigoEsperado = calcula_verificador(numeroInscricao);

        if(codigoEsperado.equals(codigoVerificador)){
            return true;
        }else{
            return false;
        }
    }

    private String calcula_verificador(String numero){
        int soma = 0;
        int peso = 2;
        int limitePeso = 9;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));
            soma += digito * peso;

            peso++;
            if (peso > limitePeso) {
                peso = 2;
            }
        }

        int resto = soma % 11;

        int verificador;
        if (resto == 0 || resto == 1) {
            verificador = 0;
        } else {
            verificador =11 - resto;
        }

        return String.valueOf(verificador);
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