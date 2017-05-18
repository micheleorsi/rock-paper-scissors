package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.model.RPSGesture;
import it.micheleorsi.domain.model.RPSListPlayer;
import it.micheleorsi.domain.repository.InMemoryScoreboardGame;
import it.micheleorsi.domain.strategy.RPSRuleSolver;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class DeterministicGameIT
{

  @Test
  public void win2RoundsToWinTheFullGame()
  {
    int pointsNeededToWin = 2;
    Player p1 = new RPSListPlayer(RPSGesture.PAPER,
      RPSGesture.ROCK,
      RPSGesture.SCISSORS,
      RPSGesture.PAPER,
      RPSGesture.SCISSORS);
    Player p2 = new RPSListPlayer(RPSGesture.PAPER,
      RPSGesture.PAPER,
      RPSGesture.PAPER,
      RPSGesture.SCISSORS,
      RPSGesture.ROCK);
    Map<Player,Integer> map = new HashMap<>();
    Round round = new TwoPlayerRound(
        p1,p2,new RPSRuleSolver()
    );
    Game fullGame = new MultiStepGame(
      round,new InMemoryScoreboardGame(map,pointsNeededToWin,
      new FakeDisplay())
    );
    fullGame.play();
  }

}
