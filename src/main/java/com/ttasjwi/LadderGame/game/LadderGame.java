package com.ttasjwi.LadderGame.game;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter @Getter
public class LadderGame {

    private LadderElement[][] ladder;

}
