package it.micheleorsi.domain.model;

import java.util.Random;

public class RPSRandomUser implements Player<RPSGesture>
{
  private Random random = new Random();
  private static final RPSGesture[] VALUES = RPSGesture.values();

  @Override
  public String toString()
  {
    return "[Random."+hashCode()+"]";
  }

  @Override
  public RPSGesture raise()
  {
    int randomIdx = random.nextInt(VALUES.length);
    return VALUES[randomIdx];
  }
}
