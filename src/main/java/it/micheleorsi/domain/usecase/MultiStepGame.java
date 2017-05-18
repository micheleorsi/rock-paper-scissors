package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.repository.ScoreboardGame;

import java.util.Optional;

public class MultiStepGame implements Game
{
  private final Round round;
  private final ScoreboardGame scoreboardGame;

  public MultiStepGame(Round round, ScoreboardGame scoreboardGame)
  {
    this.round = round;
    this.scoreboardGame = scoreboardGame;
  }

  @Override
  public void play()
  {
    while (!scoreboardGame.champion().isPresent())
    {
      Optional<Player> winner = round.winner();
      if (winner.isPresent())
      {
        scoreboardGame.markScoreFor(winner.get());
      }
      else
      {
        scoreboardGame.markTie();
      }
    }
  }
}