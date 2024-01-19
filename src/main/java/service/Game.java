package service;

import lombok.Getter;
import model.*;

import java.util.*;

@Getter
public class Game {
    private final Queue<Player> players;
    private final Board board;
    private final Dice dice;

    public Game(BoardInitializer boardInitializer) {
        this.players = new LinkedList<>();
        this.board = boardInitializer.getBoard();
        this.dice = new Dice(1, 1, 6);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playGame() {
        while (players.size() > 1) {
            Player player = players.poll();
            int diceVal = dice.roll();
            int newPosition = player.getPosition() + diceVal;
            if (newPosition > board.getEnd()) {
                players.offer(player);
            } else {
                player.setPosition(getNewPosition(newPosition));
                if (hasPlayerWon(player.getPosition())) {
                    player.setWon(true);
                    System.out.println("Player " + player.getId() + " Won.");
                } else {
                    System.out.println("Setting " + player.getId() + "'s new position to " + player.getPosition());
                    players.offer(player);
                }
            }
        }
    }

    private int getNewPosition(int newPosition) {
        for (Snake snake : board.getSnakes()) {
            if (snake.getStart() == newPosition) {
                System.out.println(snake.getEncounterMessage());
                return snake.getEnd();
            }
        }
        for (Ladder ladder : board.getLadders()) {
            if (ladder.getStart() == newPosition) {
                System.out.println(ladder.getEncounterMessage());
                return ladder.getEnd();
            }
        }
        return newPosition;
    }

    private boolean hasPlayerWon(int currentPosition){
        return currentPosition == board.getEnd();
    }
}
