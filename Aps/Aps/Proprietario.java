public class Proprietario extends Usuario {
    public Proprietario(String nome) {
        super(nome);
    }

    public String cadastrarApartamento(Apartamento apartamento) {
        if (apartamento.validarInformacoes()) {
            SistemaImobiliario.getInstance().cadastrarApartamento(apartamento);
            return "Apartamento cadastrado com sucesso!";
        } else {
            return "Erro: Informações inválidas. Por favor, revise e tente novamente.";
        }
    }
}
