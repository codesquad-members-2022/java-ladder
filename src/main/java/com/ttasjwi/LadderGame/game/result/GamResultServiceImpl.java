package com.ttasjwi.LadderGame.game.result;

import com.ttasjwi.LadderGame.game.LadderGame;
import com.ttasjwi.LadderGame.game.LadderElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamResultServiceImpl implements GameResultService {

    private final LadderGame ladderGame;

    @Override
    public LadderElement[][] getLadder() {
        LadderElement[][] ladder = ladderGame.getLadder();
        return ladder;
    }
}
