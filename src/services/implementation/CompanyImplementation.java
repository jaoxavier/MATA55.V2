package services.implementation;

import domain.entities.Company;
import services.dto.CompanyTO;

public class CompanyImplementation extends Company {

    public void createCompanyFromTO(CompanyTO companyTO) {
        super.setCnpj(validate_document(companyTO.getCnpj()) ? companyTO.getCnpj() : errorCNPJ());
        super.setNomeFantasia(companyTO.getNomeFantasia());
        super.setRazaoSocial(companyTO.getRazaoSocial());
        super.setDataAbertura(companyTO.getDataAbertura());
        super.setNaturezaJuridica(companyTO.getNaturezaJuridica());
        super.setStatus(companyTO.getStatus());
        super.setSite(companyTO.getSite());
        super.setInscricaoEstadual(companyTO.getInscricaoEstadual());
        super.setInscricaoMunicipal(companyTO.getInscricaoMunicipal());
    }

    private String errorCNPJ() {
        throw new IllegalArgumentException("CNPJ inválido!");
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