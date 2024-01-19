package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final String id;
    @Setter
    private int position;
    @Setter
    private boolean won;
    public Player(String id) {
        this.id = id;
        this.position = 0;
        this.won = false;
    }
}
