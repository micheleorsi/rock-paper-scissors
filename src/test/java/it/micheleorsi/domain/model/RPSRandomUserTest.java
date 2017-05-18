package it.micheleorsi.domain.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class RPSRandomUserTest
{

  private RPSRandomUser underTest = new RPSRandomUser();

  @Test
  public void differentGestureIfRepeatedSeveralTimes()
  {
    int idx = 0;
    int maxAllowedStepsForRandomness = 10;
    RPSGesture firstGesture = underTest.raise();
    RPSGesture secondGesture = underTest.raise();

    while(firstGesture==secondGesture && idx<=maxAllowedStepsForRandomness)
    {
      secondGesture = underTest.raise();
      idx++;
    }
    assertThat(firstGesture,is(not(equalTo(secondGesture))));
  }
}
