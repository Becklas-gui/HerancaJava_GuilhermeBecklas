public class Estagiario extends Funcionario {
    public Estagiario(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento);
    }

    public void fazerTarefa(String tarefa) {
        System.out.println(nome + " está fazendo a seguinte tarefa: " + tarefa);
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Cargo: Estagiário");
    }
}
