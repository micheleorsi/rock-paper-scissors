package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.repository.ScoreboardGame;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Optional;

public class SingleStepGameTest
{
  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockery();

  @Mock
  private Round round;

  @Mock
  private Player user1;

  private Game underTest;

  @Mock
  private ScoreboardGame scoreboardGame;

  @Before
  public void setup()
  {
    underTest = new MultiStepGame(round, scoreboardGame);
  }

  @Test
  public void whenDifferentGesture_gameHasOnlyOneStep()
  {
    mockery.checking(new Expectations()
    {{
      oneOf(scoreboardGame).champion(); will(returnValue(Optional.empty()));
      oneOf(round).winner(); will(returnValue(Optional.of(user1)));
      allowing(scoreboardGame).markScoreFor(user1);
      allowing(scoreboardGame).champion(); will(returnValue(Optional.of(user1)));
    }});
    underTest.play();
  }

  @Test
  public void whenSameFirstGesture_gameHasMoreThaOneStep()
  {
    mockery.checking(new Expectations()
    {{
      oneOf(scoreboardGame).champion(); will(returnValue(Optional.empty()));
      oneOf(round).winner(); will(returnValue(Optional.empty()));
      allowing(scoreboardGame).markTie();
      oneOf(scoreboardGame).champion(); will(returnValue(Optional.empty()));
      oneOf(round).winner(); will(returnValue(Optional.of(user1)));
      allowing(scoreboardGame).markScoreFor(user1);
      allowing(scoreboardGame).champion(); will(returnValue(Optional.of(user1)));
    }});
    underTest.play();
  }

}
