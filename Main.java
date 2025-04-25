import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n---- MENU FUNCIONÁRIOS ----");
            System.out.println("\n1 - Cadastrar Funcionário");
            System.out.println("2 - Exibir Todos os Dados");
            System.out.println("3 - Executar Ações");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    System.out.println("Tipo de funcionário:");
                    System.out.println("1 - Gerente");
                    System.out.println("2 - Desenvolvedor");
                    System.out.println("3 - Estagiário");
                    System.out.print("Escolha: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Funcionario func = null;
                    switch (tipo) {
                        case 1:
                            func = new Gerente(nome, salario, departamento, cpf, dataNascimento);
                            break;
                        case 2:
                            func = new Desenvolvedor(nome, salario, departamento, cpf, dataNascimento);
                            break;
                        case 3:
                            func = new Estagiario(nome, salario, departamento, cpf, dataNascimento);
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                            continue;
                    }

                    funcionarios.add(func);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n---- LISTA DE FUNCIONÁRIOS ----");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        System.out.println("\nFuncionário #" + (i + 1));
                        funcionarios.get(i).mostrarDados();
                    }
                    break;

                case 3:
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                        break;
                    }

                    System.out.println("\nSelecione o funcionário (pelo número):");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        System.out.println((i + 1) + " - " + funcionarios.get(i).nome);
                    }

                    int indice = scanner.nextInt() - 1;
                    if (indice < 0 || indice >= funcionarios.size()) {
                        System.out.println("Funcionário inválido.");
                        break;
                    }

                    Funcionario escolhido = funcionarios.get(indice);

                    System.out.println("Ações disponíveis:");
                    System.out.println("1 - Bater Ponto");
                    if (escolhido instanceof Gerente)
                        System.out.println("2 - Realizar Reunião");
                    if (escolhido instanceof Desenvolvedor)
                        System.out.println("2 - Programar");
                    if (escolhido instanceof Estagiario)
                        System.out.println("2 - Fazer Tarefa");

                    System.out.print("Escolha a ação: ");
                    int acao = scanner.nextInt();

                    switch (acao) {
                        case 1:
                            escolhido.baterPonto();
                            break;
                        case 2:
                            if (escolhido instanceof Gerente)
                                ((Gerente) escolhido).realizarReuniao();
                            else if (escolhido instanceof Desenvolvedor)
                                ((Desenvolvedor) escolhido).programar();
                                else if (escolhido instanceof Estagiario) {
                                    scanner.nextLine(); 
                                    System.out.print("Digite a tarefa para o estagiário: ");
                                    String tarefa = scanner.nextLine();
                                    ((Estagiario) escolhido).fazerTarefa(tarefa);
                                }
                                
                            else
                                System.out.println("Ação inválida para esse funcionário.");
                            break;
                        default:
                            System.out.println("Ação inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
