package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BoardEntity {
    private int start;
    private int end;
    public abstract String getEncounterMessage();
}
