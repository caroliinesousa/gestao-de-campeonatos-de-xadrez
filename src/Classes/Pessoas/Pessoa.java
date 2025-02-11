package Classes.Pessoas;

/**
 * A classe abstrata {@code Pessoa} serve como uma base para representar
 * informações comuns
 * sobre uma pessoa no sistema. Classes derivadas, como {@code Jogador} ou
 * {@code Arbitro},
 * herdam desta classe.
 * <p>
 * Esta classe contém os atributos nome, idade e gênero, além de métodos para
 * acesso e
 * modificação dessas informações. Também define o método abstrato
 * {@code exibirInformacoes},
 * que deve ser implementados pelas subclasses.
 * </p>
 */
public abstract class Pessoa {
    /**
     * Nome da pessoa.
     */
    private String nome;
    /**
     * Idade da pessoa.
     */
    private int idade;
    /**
     * Gênero da pessoa.
     */
    private char genero;

    /**
     * Construtor que inicializa uma pessoa com nome, idade e gênero.
     *
     * @param nome   o nome da pessoa
     * @param idade  a idade da pessoa
     * @param genero o gênero da pessoa
     */
    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return o nome da pessoa
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna a idade da pessoa.
     *
     * @return a idade da pessoa
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Retorna o gênero da pessoa.
     *
     * @return o gênero da pessoa
     */
    public char getGenero() {
        return this.genero;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome o novo nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a idade da pessoa.
     *
     * @param idade a nova idade da pessoa
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Define o gênero da pessoa.
     *
     * @param genero o novo gênero da pessoa
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Método abstrato para exibir as informações da pessoa.
     * <p>
     * As subclasses devem implementar este método para exibir informações
     * específicas.
     * </p>
     */
    public abstract void exibirInformacoes();
}
