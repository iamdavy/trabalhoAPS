public class SistemaFacade {
    private SistemaImobiliario sistema = SistemaImobiliario.getInstance();

    public void cadastrarApartamento(Proprietario proprietario, Apartamento apartamento) {
        String resultado = proprietario.cadastrarApartamento(apartamento);
        System.out.println(resultado);
    }

    public void alugarApartamento(Universitario universitario, Apartamento apartamento) {
        String resultado = universitario.alugarApartamento(apartamento);
        System.out.println(resultado);
    }
}
