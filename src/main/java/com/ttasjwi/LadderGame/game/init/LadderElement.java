package com.ttasjwi.LadderGame.game.init;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LadderElement {

    VERTICAL_LINE("-"),
    HORIZONTAL_LINE("|"),
    EMPTY_LINE(" ");

    private final String symbol;

}
