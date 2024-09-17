import java.util.ArrayList;
import java.util.List;

public class SistemaImobiliario {
    private static SistemaImobiliario instanciaUnica;
    private List<Apartamento> apartamentos;
    private List<Universitario> interessados;

    private SistemaImobiliario() {
        apartamentos = new ArrayList<>();
        interessados = new ArrayList<>();
    }

    public static SistemaImobiliario getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new SistemaImobiliario();
        }
        return instanciaUnica;
    }

    public void cadastrarApartamento(Apartamento apto) {
        apartamentos.add(apto);
        notificarInteressados(apto);
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void adicionarInteressado(Universitario universitario) {
        interessados.add(universitario);
    }

    public void notificarInteressados(Apartamento apto) {
        for (Universitario u : interessados) {
            u.atualizar(apto);
        }
    }
}
