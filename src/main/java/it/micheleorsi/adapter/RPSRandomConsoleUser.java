package it.micheleorsi.adapter;

import it.micheleorsi.domain.model.RPSGesture;
import it.micheleorsi.domain.model.RPSRandomUser;

import java.io.PrintStream;

public class RPSRandomConsoleUser extends RPSRandomUser
{
  private final PrintStream printStream;

  public RPSRandomConsoleUser(PrintStream printStream)
  {

    this.printStream = printStream;
  }

  @Override
  public RPSGesture raise()
  {
    RPSGesture gesture = super.raise();
    printStream.println(this+" raised a "+gesture);
    return gesture;
  }
}
