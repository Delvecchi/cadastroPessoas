import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();

        PessoaFisica metodosPf = new PessoaFisica();

        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();

        PessoaJuridica metodosPj = new PessoaJuridica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Fisica e Pessoa Juridica");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {

                case 1:
                    int opcaoPf;
                    do {
                        System.out.println(" Escolha uma opção: 1 - Cadastrar Pessoa Física / 2 - Lista Pessoa Física / 0 - Voltar menu anterior ");
                        opcaoPf = scanner.nextInt();
                        switch (opcaoPf) {
                            case 1:
                                PessoaFisica novapf = new PessoaFisica(); //instanciar objeto pessoa fisica
                                Endereco novaEndPf = new Endereco(); //instanciar objeto endereco

                                System.out.println("Digite o nome da pessoafísica: ");
                                novapf.nome = scanner.next();

                                System.out.println("Digite o número do CPF: ");
                                novapf.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal(Digite somente números): ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); //recebe como string e converte para localdate
                                Period periodo = Period.between(date, LocalDate.now()); //comparação entre a data de nascimnto convertida em localdate e data atual(localdate)

                                novapf.dataNascimento = date;

                                if (periodo.getYears() >= 18) {      //comparação de maioridade
                                    System.out.println("A pessoa tem mais de 18 anos");
                                } else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novaEndPf.lograduro = scanner.next();

                                System.out.println("Digite o número: ");
                                novaEndPf.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novaEndPf.enderecoComercial = true;
                                } else {
                                    novaEndPf.enderecoComercial = false;
                                }

                                novapf.endereco = novaEndPf;

                                listaPf.add(novapf); //adiciona ao array instanciado

                                System.out.println("Cadastro realizado com sucesso!");

                                break;
                            case 2:

                                if (listaPf.size() > 0) {

                                    for (PessoaFisica cadaPf : listaPf) {       //acessar a listaPf e cada item acessar pelo cadaPf
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.lograduro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaoPf = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia!");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior!");
                                break;
                            default:
                                System.out.println("Opção inválida, digite uma opção válida!");
                                break;
                        }

                    } while (opcaoPf != 0);

                    break;
                case 2:
                    int opcaoPj;

                    do {
                        System.out.println("Escolha uma opção: 1 - Cadastrar Pessoa Juridica ; 2 Listar Pessoa Juridica ; 0 - Voltar ao menu anterior");
                        opcaoPj = scanner.nextInt();

                        switch (opcaoPj) {
                            case 1:
                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("Digite o nome da pessoa juridica: ");
                                novaPj.nome = scanner.next();

                                System.out.println("Digite o número do CNPJ: ");
                                novaPj.cnpj = scanner.next();

                                System.out.println("Digite o rendimento mensal(Digite somente numero): ");
                                novaPj.rendimento = scanner.nextInt();

                                System.out.println("Digite a razão social: ");
                                novaPj.razaoSocial = scanner.next();

                                System.out.println("Digite o logradouro: ");
                                novoEndPj.lograduro = scanner.next();

                                System.out.println("Digite o número: ");
                                novoEndPj.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoEndPj.enderecoComercial = true;
                                } else {
                                    novoEndPj.enderecoComercial = false;
                                }

                                novaPj.endereco = novoEndPj;

                                listaPj.add(novaPj);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;
                            case 2:

                                if (listaPj.size() > 0) {

                                    for (PessoaJuridica cadaPj : listaPj) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Endereço: " + cadaPj.endereco.lograduro + ", " + cadaPj.endereco.numero + ", endereço comercial: " + cadaPj.endereco.enderecoComercial);
                                        System.out.println("Razão Social: " + cadaPj.razaoSocial);
                                        System.out.println("Imposto a ser pago: " + cadaPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        System.out.println();
                                    }

                                    opcaoPj = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;
                            default:
                                System.out.println("Opção inválida, por favor digite uma opção válida!");
                                break;
                        }

                    } while (opcaoPj != 0);

                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida, digite uma opção válida!");
                    break;
            }

        } while (opcao != 0);
    }
}
