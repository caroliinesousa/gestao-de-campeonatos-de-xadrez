package Classes;
/**
 * A classe {@code Premio} representa um prêmio com um tipo e um valor monetário.
 * <p>
 * Esta classe fornece métodos para acessar as informações do prêmio e exibi-las no console.
 * </p>
 */
public class Premio {
     /** O tipo do prêmio (ex.: "Medalha", "Dinheiro"). */
    private String tipo;
     /** O valor monetário do prêmio em euros. */
    private double valor;
     /**
     * Construtor da classe {@code Premio}.
     *
     * @param tipo  o tipo do prêmio
     * @param valor o valor monetário do prêmio
     */
    public Premio(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
     /**
     * Retorna o tipo do prêmio.
     *
     * @return o tipo do prêmio
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Retorna o valor monetário do prêmio.
     *
     * @return o valor do prêmio em euros
     */
    public double getValor() {
        return valor;
    }
     /**
     * Exibe as informações do prêmio no console.
     * <p>
     * As informações exibidas incluem o tipo do prêmio e seu valor monetário formatado em euros.
     * </p>
     */
    public void exibirInformacoes() {
        System.out.println("Prêmio: " + tipo + ", Valor: €" + valor + "Euros");
    }
}
