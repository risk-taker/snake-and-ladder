package model;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Yeyyy!! You have a stair to climb :) ";
    }
}
