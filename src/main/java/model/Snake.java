package model;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Ooops!! You encountered a Snake :( ";
    }
}
