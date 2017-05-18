package it.micheleorsi.domain.repository;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.util.Display;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;
import java.util.function.BiFunction;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryScoreboardGameTest
{

  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockery();

  private ScoreboardGame underTest;

  @Mock
  private Map<Player,Integer> map;

  @Mock
  private Player player;
  @Mock
  private Display display;

  private Integer pointsToWin = 5;

  @Before
  public void setup()
  {
    underTest = new InMemoryScoreboardGame(map,pointsToWin,display);
  }

  @Test
  public void whenTiePrintSomething()
  {
    mockery.checking(new Expectations()
    {{
      oneOf(display).println(with(any(String.class)));
    }});
    underTest.markTie();
  }

  @Test
  public void whenMarkScore_PointsHaveBeenIncreased()
  {
    mockery.checking(new Expectations()
    {{
      allowing(display).println(with(any(String.class)));
      oneOf(map).compute(with(player),with(any(BiFunction.class))); will(returnValue(1));
      allowing(map).entrySet();
    }});

    underTest.markScoreFor(player);
  }

  @Test
  public void whenMarkScore_ChampionIsDeclaredOnlyIfRightPointsAreReached()
  {
    stepToVictory();
    underTest.markScoreFor(player);
  }

  @Test
  public void whenrRightPointsAreReached_ChampionIsThere()
  {
    stepToVictory();

    underTest.markScoreFor(player);
    Player champion = underTest.champion().get();
    assertThat(champion,is(equalTo(player)));
  }

  private void stepToVictory()
  {
    mockery.checking(new Expectations()
    {{
      allowing(display).println(with(any(String.class)));
      oneOf(map).compute(with(player),with(any(BiFunction.class))); will(returnValue(pointsToWin));
      allowing(display).println(with(any(String.class)));
      allowing(map).entrySet();
      allowing(display).println(with(any(String.class)));
    }});
  }

}
