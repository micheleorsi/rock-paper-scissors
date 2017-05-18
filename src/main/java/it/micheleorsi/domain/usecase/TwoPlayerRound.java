package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Gesture;
import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.strategy.RuleSolver;

import java.util.Optional;

public class TwoPlayerRound implements Round
{

  private final Player player1;
  private final Player player2;
  private final RuleSolver ruleSolver;

  public TwoPlayerRound(Player player1, Player player2,
    RuleSolver ruleSolver)
  {
    this.player1 = player1;
    this.player2 = player2;
    this.ruleSolver = ruleSolver;
  }

  @Override
  public Optional<Player> winner()
  {
    Player[] players = new Player[]{
      player1,player2,null
    };
    Gesture g1 = players[0].raise();
    Gesture g2 = players[1].raise();
    Optional<Integer> result = ruleSolver.winnerIndex(g1, g2);
    return Optional.ofNullable(players[result.orElse(2)]);
  }
}
