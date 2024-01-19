import model.Player;
import service.BoardInitializer;
import service.Game;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board Size");
        int boardSize = scanner.nextInt();
        System.out.println("Enter number of snakes");
        int numSnakes = scanner.nextInt();
        System.out.println("Enter number of ladders");
        int numLadders = scanner.nextInt();

        System.out.println("Enter number of players");
        int numberOfPlayers = scanner.nextInt();

        BoardInitializer boardInitializer = new BoardInitializer(numLadders, numSnakes, boardSize);
        Game game = new Game(boardInitializer);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player id");
            String pName = scanner.next();
            Player player = new Player(pName);
            game.addPlayer(player);
        }
        game.playGame();
    }
}