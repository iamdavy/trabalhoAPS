public class Apartamento {
    private String endereco;
    private int numeroQuartos;
    private double preco;
    private boolean disponivel;

    public Apartamento(String endereco, int numeroQuartos, double preco) {
        this.endereco = endereco;
        this.numeroQuartos = numeroQuartos;
        this.preco = preco;
        this.disponivel = true;
    }

    public boolean validarInformacoes() {
        return endereco != null && !endereco.isEmpty() && numeroQuartos > 0 && preco > 0;
    }

    // Getters e Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
