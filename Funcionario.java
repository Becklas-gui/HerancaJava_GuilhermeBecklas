public class Funcionario extends Pessoa {
    protected String nome;
    protected double salario;
    protected String departamento;

    public Funcionario(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(cpf, dataNascimento);
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$" + salario);
        System.out.println("Departamento: " + departamento);
        super.mostrarInfoPessoal();
    }

    public void baterPonto() {
        System.out.println(nome + " bateu o ponto.");
    }
}
