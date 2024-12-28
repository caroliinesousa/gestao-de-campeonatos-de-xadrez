package Classes;

import Classes.Partidas.PartidaDuplas;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Carlos", 25, 'M', 1, 2);
        Jogador jogador2 = new Jogador("Ana", 22, 'F', 2, 2);

        Jogador jogador3 = new Jogador("Lucas", 28, 'M', 3, 2);
        Jogador jogador4 = new Jogador("Maria", 30, 'F', 4, 2);

        Arbitro arbitro = new Arbitro("Arnaldo", 40, 'M', "Certificado A");

        PartidaSingulares partidaSingular = new PartidaSingulares(arbitro, jogador1, jogador2, arbitro);
        partidaSingular.realizarPartida();

        PartidaDuplas partidaDuplas = new PartidaDuplas(arbitro, jogador1, jogador2, jogador1, jogador2);
        partidaDuplas.realizarPartida();
    }
}
