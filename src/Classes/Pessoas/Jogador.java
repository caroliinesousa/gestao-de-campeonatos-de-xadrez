package Classes.Pessoas;

public class Jogador extends Pessoa {
    private int ranking;
    private int partidasJogadas;
    private int pontos;

    //Jogador novo
    public Jogador(String nome, int idade, char genero) { 
        super(nome, idade, genero);
        this.ranking = 0;
        this.partidasJogadas = 0;
        this.pontos = 0;
    }
    //Jogador antigo
    public Jogador(String nome, int idade, char genero, int ranking, int partidasJogadas, int pontos) { 
        super(nome, idade, genero);
        this.ranking = ranking;
        this.partidasJogadas = partidasJogadas;
        this.pontos = pontos;
    }

    public int getRanking() {
        return this.ranking;
    }
    public int getPartidasJogadas() {
        return this.partidasJogadas;
    }
    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public void incrementarPartidas() { 
        partidasJogadas++; 
    }
    public void adicionarPontos(int pontos){
        this.pontos += pontos;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome" + getNome() + ", Idade: " + getIdade() + ", Gênero: " + getGenero());
        System.out.println("Posição no Ranking: " + this.ranking + ", Partidas Jogadas: " + this.partidasJogadas);

}
}
