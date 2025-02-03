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
