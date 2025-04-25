public class Pessoa {
    protected String cpf;
    protected String dataNascimento;

    public Pessoa(String cpf, String dataNascimento) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public void mostrarInfoPessoal() {
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
}
