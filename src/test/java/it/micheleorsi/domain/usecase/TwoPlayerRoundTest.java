package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.model.RPSGesture;
import it.micheleorsi.domain.strategy.RuleSolver;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwoPlayerRoundTest
{

  private Round underTest;

  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockery();

  @Mock
  private Player p1;

  @Mock
  private Player p2;

  @Mock
  private RuleSolver<RPSGesture> solver;

  @Before
  public void setup()
  {
    underTest = new TwoPlayerRound(p1,p2,solver);
  }

  @Test
  public void whenTie_ReturnNoPlayer()
  {
    mockery.checking(new Expectations()
    {{
      allowing(p1).raise(); will(returnValue(RPSGesture.ROCK));
      allowing(p2).raise(); will(returnValue(RPSGesture.ROCK));
      oneOf(solver).winnerIndex(with(RPSGesture.ROCK),with(RPSGesture.ROCK)); will(returnValue(Optional.empty()));
    }});
    Optional<Player> winner = underTest.winner();
    assertThat(winner,is(equalTo(Optional.empty())));

  }

  @Test
  public void whenRockPaper_ReturnSecondPlayer()
  {
    mockery.checking(new Expectations()
    {{
      allowing(p1).raise(); will(returnValue(RPSGesture.ROCK));
      allowing(p2).raise(); will(returnValue(RPSGesture.PAPER));
      oneOf(solver).winnerIndex(with(RPSGesture.ROCK),with(RPSGesture.PAPER)); will(returnValue(Optional.of(1)));
    }});
    Optional<Player> winner = underTest.winner();
    assertThat(winner.orElse(null),is(p2));

  }
}
