package Classes;

public class Premio {
    private String tipo;
    private double valor;

    public Premio(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void exibirInformacoes() {
        System.out.println("Prêmio: " + tipo + ", Valor: €" + valor + "Euros");
    }
}
