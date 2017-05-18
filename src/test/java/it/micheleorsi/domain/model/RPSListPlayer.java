package it.micheleorsi.domain.model;

public class RPSListPlayer implements Player<RPSGesture>
{

  private final RPSGesture[] gestures;
  private int counter = 0;

  public RPSListPlayer(RPSGesture... gestures)
  {

    this.gestures = gestures;
  }

  @Override
  public RPSGesture raise()
  {
    return gestures[counter++];
  }
}
