import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaFacade facade = new SistemaFacade();

        System.out.println("Cadastrando automaticamente um Proprietário");

        Proprietario proprietarioTeste = new Proprietario("Marcos");
        Apartamento apto1 = new Apartamento("Rua Duque de caxias, 123", 2, 1500);
        Apartamento apto2 = new Apartamento("Avenida Mourao, 456", 3, 2000);

        facade.cadastrarApartamento(proprietarioTeste, apto1);
        facade.cadastrarApartamento(proprietarioTeste, apto2);

        System.out.println("Dois apartamentos cadastrados com sucesso!");

        System.out.println("\nBem-vindo ao Sistema de Gerenciamento de Imóveis Universitário");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Você é um: 1. Universitário  2. Proprietário");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario;

        if (escolha == 1) {
            usuario = UsuarioFactory.criarUsuario("universitario", nome);
            Universitario universitario = (Universitario) usuario;

            System.out.println("Opções disponíveis:");
            System.out.println("1. Ver apartamentos disponíveis");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                SistemaImobiliario sistema = SistemaImobiliario.getInstance();
                if (sistema.getApartamentos().isEmpty()) {
                    System.out.println("Nenhum apartamento disponível no momento.");
                } else {
                    for (Apartamento apto : sistema.getApartamentos()) {
                        if (apto.isDisponivel()) {
                            System.out.println("Apartamento: " + apto.getEndereco());
                            System.out.println("Preço: " + apto.getPreco());
                            System.out.println("Quartos: " + apto.getNumeroQuartos());
                            System.out.println("Disponível: " + apto.isDisponivel());
                            System.out.println("Deseja alugar este apartamento? (1. Sim / 2. Não)");
                            int desejaAlugar = scanner.nextInt();
                            if (desejaAlugar == 1) {
                                facade.alugarApartamento(universitario, apto);
                            }
                        }
                    }
                }
            }
        } else if (escolha == 2) {
            usuario = UsuarioFactory.criarUsuario("proprietario", nome);
            Proprietario proprietario = (Proprietario) usuario;

            System.out.println("Cadastrar um novo apartamento");
            System.out.println("Digite o endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Digite o número de quartos: ");
            int quartos = scanner.nextInt();
            System.out.println("Digite o preço: ");
            double preco = scanner.nextDouble();

            Apartamento apto = new Apartamento(endereco, quartos, preco);
            facade.cadastrarApartamento(proprietario, apto);
        }

        scanner.close();
    }
}
