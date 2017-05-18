package it.micheleorsi.domain.repository;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.util.Display;

import java.util.Map;
import java.util.Optional;

public class InMemoryScoreboardGame implements ScoreboardGame
{

  private final Map<Player, Integer> score;
  private final Integer pointsToWin;
  private final Display display;
  private Optional<Player> championPlayer = Optional.empty();

  public InMemoryScoreboardGame(Map<Player,Integer> score, Integer pointsToWin,
    Display display)
  {
    this.score = score;
    this.pointsToWin = pointsToWin;
    this.display = display;
  }

  @Override
  public void markScoreFor(Player player)
  {
    display.println(player+" scores 1 point!");
    Integer playerScore = score.compute(player, (k, v) -> (v == null) ? 1 : v + 1);
    display.println("TOTAL SCORE: "+score.entrySet()+"\n");
    if(playerScore.equals(pointsToWin))
    {
      championPlayer = Optional.of(player);
      display.println(" __      __     _                             _                    _          _ _ _ \n" +
        " \\ \\    / /__  | |_  __ ___ _____   __ _   __| |_  __ _ _ __  _ __(_)___ _ _ | | | |\n" +
        "  \\ \\/\\/ / -_) | ' \\/ _` \\ V / -_) / _` | / _| ' \\/ _` | '  \\| '_ \\ / _ \\ ' \\|_|_|_|\n" +
        "   \\_/\\_/\\___| |_||_\\__,_|\\_/\\___| \\__,_| \\__|_||_\\__,_|_|_|_| .__/_\\___/_||_(_|_|_)\n" +
        "                                                             |_|                    \n\n"+ player);
    }
  }

  @Override
  public void markTie()
  {
    display.println("We have a tie!");
  }

  @Override
  public Optional<Player> champion()
  {
    return championPlayer;
  }
}
