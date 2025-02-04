package services.implementation;

import domain.entities.Company;
import services.dto.CompanyTO;

public class CompanyImplementation {

    public Company createCompanyFromTO(CompanyTO companyTO) {
        Company company = new Company();
        company.setCnpj(companyTO.getCnpj());
        company.setNomeFantasia(companyTO.getNomeFantasia());
        company.setRazaoSocial(companyTO.getRazaoSocial());
        company.setDataAbertura(companyTO.getDataAbertura());
        company.setNaturezaJuridica(companyTO.getNaturezaJuridica());
        company.setStatus(companyTO.getStatus());
        company.setSite(companyTO.getSite());
        company.setInscricaoEstadual(companyTO.getInscricaoEstadual());
        company.setInscricaoMunicipal(companyTO.getInscricaoMunicipal());

        return company;
    }
}