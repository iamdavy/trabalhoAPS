public class Universitario extends Usuario implements Observador {
    public Universitario(String nome) {
        super(nome);
    }

    @Override
    public void atualizar(Apartamento apto) {
        System.out.println("Novo apartamento disponível para " + nome + ": " + apto.getEndereco());
    }

    public String alugarApartamento(Apartamento apartamento) {
        if (apartamento.isDisponivel()) {
            apartamento.setDisponivel(false);
            return "Apartamento alugado com sucesso!";
        } else {
            return "Erro: O apartamento não está disponível.";
        }
    }
}
