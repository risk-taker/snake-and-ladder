package service;

import lombok.Getter;
import model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class BoardInitializer {
    private final int numberOfSnakes;
    private final int numberOfLadders;
    private final int boardSize;
    private Board board;

    public BoardInitializer(int numberOfLadders, int numberOfSnakes, int boardSize) {
        this.numberOfLadders = numberOfLadders;
        this.numberOfSnakes = numberOfSnakes;
        this.boardSize = boardSize;
        this.board = new Board(boardSize);
        initBoard();
    }

    private void initBoard() {
        Set<Integer> usedPositions = new HashSet<>();
        generateSnakes(usedPositions);
        generateLadders(usedPositions);
    }

    private void generateSnakes(Set<Integer> usedPositions) {
        for (int i = 0; i < numberOfSnakes; i++) {
            while (true) {
                int snakeStart = generateRandomPosition(board.getStart(), board.getEnd());
                int snakeEnd = generateRandomPosition(board.getStart(), board.getEnd());
                if (snakeEnd >= snakeStart)
                    continue;
                if (!usedPositions.contains(snakeStart)) {
                    Snake snake = new Snake(snakeStart, snakeEnd);
                    board.addSnake(snake);
                    usedPositions.add(snakeStart);
                    break;
                }
            }
        }
    }

    private void generateLadders(Set<Integer> usedPositions) {
        for (int i = 0; i < numberOfLadders; i++) {
            while (true) {
                int ladderStart = generateRandomPosition(board.getStart(), board.getEnd());
                int ladderEnd = generateRandomPosition(board.getStart(), board.getEnd());
                if (ladderEnd <= ladderStart)
                    continue;
                if (!usedPositions.contains(ladderStart)) {
                    Ladder ladder = new Ladder(ladderStart, ladderEnd);
                    board.addLadder(ladder);
                    usedPositions.add(ladderStart);
                    break;
                }
            }
        }
    }

    private int generateRandomPosition(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }
}
