public class Company extends Person{

    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private String dataAbertura;
    private String naturezaJuridica;
    private String status;
    private String site;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;



    @Override
    protected boolean validate_document(String cnpj){
       return false;
    }

}