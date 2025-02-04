package domain.entities;

public class Company extends Person{ //removido abstract da classe company

    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private String dataAbertura;
    private String naturezaJuridica;
    private String status;
    private String site;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        if (validate_document(cnpj)){
            this.cnpj = cnpj;
        }
        else {
        throw new IllegalArgumentException("CNPJ inválido");
    }
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }
    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
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
