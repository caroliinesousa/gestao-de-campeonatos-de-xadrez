package Classes.Pessoas;

/**
 * A classe {@code Arbitro} representa um árbitro em um sistema, que é uma
 * especialização
 * da classe {@code Pessoa}. Contém informações adicionais específicas do
 * árbitro,
 * como suas certificações.
 */

public class Arbitro extends Pessoa {

    /**
     * Certificações do árbitro.
     */

    private String certificacoes;

    /**
     * Construtor para inicializar um árbitro com os detalhes fornecidos.
     *
     * @param nome          o nome do árbitro
     * @param idade         a idade do árbitro
     * @param genero        o gênero do árbitro
     * @param certificacoes as certificações do árbitro
     */

    public Arbitro(String nome, int idade, char genero, String certificacoes) {
        super(nome, idade, genero);
        this.certificacoes = certificacoes;
    }

    /**
     * Retorna as certificações do árbitro.
     *
     * @return uma {@code String} contendo as certificações do árbitro
     */
    public String getCertificacoes() {
        return this.certificacoes;
    }

    /**
     * Define ou atualiza as certificações do árbitro.
     *
     * @param certificacoes as novas certificações do árbitro
     */
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }

    /**
     * Exibe as informações detalhadas do árbitro no console.
     * Inclui nome, idade, gênero e certificações.
     */
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome" + getNome() + ", Idade: " + getIdade() + ", Gênero: " + getGenero());
        System.out.println("Certificações: " + this.certificacoes);
    }

}
