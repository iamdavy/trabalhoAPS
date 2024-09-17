public class UsuarioFactory {
    public static Usuario criarUsuario(String tipo, String nome) {
        if (tipo.equalsIgnoreCase("proprietario")) {
            return new Proprietario(nome);
        } else if (tipo.equalsIgnoreCase("universitario")) {
            Universitario universitario = new Universitario(nome);
            SistemaImobiliario.getInstance().adicionarInteressado(universitario);
            return universitario;
        }
        return null;
    }
}
