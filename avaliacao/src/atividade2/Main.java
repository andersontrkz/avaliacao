package atividade2;

import atividade2.alienigena.Alienigena;
import atividade2.especie.Especie;
import atividade2.interfaces.IDetalhes;
import atividade2.planeta.Planeta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Planeta> planetas = new ArrayList<>();
    private static ArrayList<Especie> especies = new ArrayList<>();
    private static ArrayList<Alienigena> alienigenas = new ArrayList<>();
    private static ArrayList<Alienigena> quarentena = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Planeta planeta1 = new Planeta("Marte", 22.9);
        Planeta planeta2 = new Planeta("Netuno", 12.5);
        planetas.addAll(List.of(planeta1, planeta2));

        Especie especie1 = new Especie("Marciano", planeta1, 33.3);
        Especie especie2 = new Especie("Netuniano", planeta2, 4.1);
        especies.addAll(List.of(especie1, especie2));

        Alienigena alienigena1 = new Alienigena("Marinaldo", especie1, 3.23);
        Alienigena alienigena2 = new Alienigena("Netuza", especie2, 155.1);
        alienigenas.addAll(List.of(alienigena1, alienigena2));

        quarentena.add(alienigena2);

        Integer acao;
        do {
            System.out.println("Menu");
            System.out.println("1. Cadastrar Alienígena");
            System.out.println("2. Cadastrar Planeta");
            System.out.println("3. Cadastrar Espécie");
            System.out.println("4. Listar Alienígenas");
            System.out.println("5. Listar Espécies");
            System.out.println("6. Listar Planetas");
            System.out.println("7. Exibir Ranking Periculosidade Alienígenas");
            System.out.println("8. Exibir Ranking Periculosidade Espécies");
            System.out.println("9. Exibir Ranking Periculosidade Planetas");
            System.out.println("10. Adicionar Alienigena em Quarentena");
            System.out.println("11 Listar Alienigenas em Quarentena");
            System.out.println("12 Listar Alienigenas por Espécie");
            System.out.println("13 Listar Alienigenas por Entrada (Últimos 6 Meses)");
            System.out.println("14. Sair");

            System.out.println("Escolha uma ação: ");
            acao = scanner.nextInt();
            scanner.nextLine();

            switch (acao) {
                case 1:
                    cadastrarAlienigena();
                    break;
                case 2:
                    cadastrarPlaneta();
                    break;
                case 3:
                    cadastrarEspecie();
                    break;
                case 4:
                    listarEntidade("alíenigenas", alienigenas);
                    break;
                case 5:
                    listarEntidade("espécies", especies);
                    break;
                case 6:
                    listarEntidade("planetas", planetas);
                    break;
                case 7:
                    exibirRankingPericulosidade("alíenigenas", alienigenas);
                    break;
                case 8:
                    exibirRankingPericulosidade("espécies", especies);
                    break;
                case 9:
                    exibirRankingPericulosidade("planetas", planetas);
                    break;
                case 10:
                    adicionarAlienigenaQuarentena();
                    break;
                case 11:
                    listarEntidade("alíenigenas em quarentena", quarentena);
                    break;
                case 12:
                    listarAlienigenasPorEspecie();
                    break;
                case 13:
                    listarAlienigenas6Meses();
                    break;
                case 14:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Ação inválida!");
            }
        } while (acao != 14);

        scanner.close();
    }

    private static void cadastrarPlaneta() {
        System.out.println("Cadastro de Planeta: ");

        System.out.println("Digite o nome do planeta: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o nível de periculosidade do planeta (ex: 12.5)");
        Double periculosidade = scanner.nextDouble();
        scanner.nextLine();

        Planeta planeta = new Planeta(nome, periculosidade);
        planetas.add(planeta);

        System.out.println("Planeta cadastrado com sucesso.");
    }

    private static void cadastrarEspecie() {
        System.out.println("Cadastro de Espécie: ");

        System.out.println("Digite o nome da espécie: ");
        String nome = scanner.nextLine();

        System.out.println("Selecione o planeta de origem  da espécie:");
        Planeta planeta = getEpeciePlaneta();

        System.out.println("Digite o nível de periculosidade  da espécie (ex: 12.5)");
        Double periculosidade = scanner.nextDouble();
        scanner.nextLine();

        Especie especie = new Especie(nome, planeta, periculosidade);
        especies.add(especie);

        System.out.println("Espécie cadastrada com sucesso.");
    }

    private static Planeta getEpeciePlaneta() {
        for (Integer i = 0; i < planetas.size(); i++) {
            System.out.println((i + 1) + ". " + planetas.get(i).getNome());
        }

        System.out.println((planetas.size() + 1) + ". Cadastrar novo planeta");

        Integer planeta = scanner.nextInt();
        scanner.nextLine();

        if (planeta == planetas.size() + 1) {
            cadastrarPlaneta();
            return planetas.get(planetas.size() - 1);
        }

        return planetas.get(planeta - 1);
    }

    private static void cadastrarAlienigena() {
        System.out.println("Cadastro de Alienigena: ");

        System.out.println("Digite o nome do alienigena: ");
        String nome = scanner.nextLine();

        System.out.println("Selecione a espécie do alienigena:");
        Especie especie = getAlienigenaEpecie();

        System.out.println("Digite o nível de periculosidade do alienigena (ex: 12.5)");
        Double periculosidade = scanner.nextDouble();
        scanner.nextLine();

        Alienigena alien = new Alienigena(nome, especie, periculosidade);
        alienigenas.add(alien);

        System.out.println("Alienígena cadastrado com sucesso.");
    }

    private static Especie getAlienigenaEpecie() {
        for (Integer i = 0; i < especies.size(); i++) {
            System.out.println((i + 1) + ". " + especies.get(i).getNome());
        }

        System.out.println((planetas.size() + 1) + ". Cadastrar nova espécie");

        Integer especie = scanner.nextInt();
        scanner.nextLine();

        if (especie == especies.size() + 1) {
            cadastrarEspecie();
            return especies.get(especies.size() - 1);
        }

        return especies.get(especie - 1);
    }

    private static <T extends IDetalhes> void listarEntidade(String nomeEntidade, List<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("Não há cadastro de " + nomeEntidade);
        } else {
            System.out.println("Listando " + nomeEntidade);
            for (Integer i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i).detalhes());
            }
        }
    }

    private static <T extends IDetalhes> void exibirRankingPericulosidade(String nomeEntidade, List<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("Não há cadastro de " + nomeEntidade);
        } else {
            lista.stream()
                    .sorted((item1, item2) -> Double.compare(item2.getPericulosidade(), item1.getPericulosidade()))
                    .forEach(item -> System.out.println(item.getPericulosidade() + " | " + item.detalhes()));
        }
    }

    private static void adicionarAlienigenaQuarentena() {
        listarEntidade("alíenigenas", alienigenas);

        System.out.println("Informe o alíenigena que deve estar em quarentena: ");
        Integer alienigena = scanner.nextInt();
        scanner.nextLine();

        Alienigena alienigenaQuarentena = alienigenas.get(alienigena - 1);
        alienigenaQuarentena.setEmQuarentena(true);

        quarentena.add(alienigenaQuarentena);

        System.out.println("Alienígena adicionado em quarentena com sucesso.");
    }

    private static void listarAlienigenasPorEspecie() {
        System.out.println("Escolha a espécie para listar os alienígenas:");
        listarEntidade("espécies", especies);

        Integer especie = scanner.nextInt();
        scanner.nextLine();

        Especie especieSelecionada = especies.get(especie - 1);

        System.out.println("Alienígenas da espécie " + especieSelecionada.getNome() + ":");
        for (Alienigena alienigena : alienigenas) {
            if (alienigena.getEspecie().equals(especieSelecionada)) {
                System.out.println(alienigena.detalhes());
            }
        }
    }

    private static void listarAlienigenas6Meses() {
        LocalDateTime dataLimite = LocalDateTime.now().minusMonths(6);

        for (Alienigena alienigena : alienigenas) {
            if (alienigena.getDataHoraEntrada().isAfter(dataLimite)) {
                System.out.println(alienigena.detalhes());
            }
        }
    }
}
