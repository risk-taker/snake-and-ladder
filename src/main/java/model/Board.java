package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    private final int start;
    private final int end;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size) {
        this.start = 1;
        this.end = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }
    public void addSnake(Snake snake) {
        snakes.add(snake);
    }
    public void addLadder(Ladder ladder) {
        ladders.add(ladder);
    }
}
