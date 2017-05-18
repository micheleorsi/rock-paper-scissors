package it.micheleorsi.domain.strategy;

import it.micheleorsi.domain.model.RPSGesture;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RPSSolverTest
{
  private RPSRuleSolver underTest = new RPSRuleSolver();

  @Test
  public void inRockVSPaper_SecondOneWins()
  {
    assertThat(underTest.winnerIndex(RPSGesture.ROCK, RPSGesture.PAPER).orElse(null),is(equalTo(1)));
  }

  @Test
  public void inScissorsVSPaper_FirstOneWins()
  {
    assertThat(underTest.winnerIndex(RPSGesture.SCISSORS, RPSGesture.PAPER).orElse(null),is(equalTo(0)));
  }

  @Test
  public void inPaperVSScissors_SecondOneWins()
  {
    assertThat(underTest.winnerIndex(RPSGesture.PAPER, RPSGesture.SCISSORS).orElse(null),is(equalTo(1)));
  }

  @Test
  public void sameGesture_isAtie()
  {
    assertThat(underTest.winnerIndex(RPSGesture.ROCK, RPSGesture.ROCK),is(equalTo(Optional.empty())));
  }

}
