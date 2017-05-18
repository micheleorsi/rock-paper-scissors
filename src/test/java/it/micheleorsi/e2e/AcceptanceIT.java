package it.micheleorsi.e2e;

import it.micheleorsi.adapter.GameConfigurator;
import it.micheleorsi.adapter.LineParser;
import org.junit.Test;

import java.io.StringReader;

public class AcceptanceIT
{

  @Test(expected = NullPointerException.class)
  public void playerVsComputerMatch_soInputIsNull()
  {
    new GameConfigurator(new LineParser(
      new StringReader("Y\n3\n")),
      System.out).configure().play();
  }

  @Test
  public void computerVsComputerMatch_isIndependentFromInput()
  {
    new GameConfigurator(new LineParser(
      new StringReader("C\n3\n")),
      System.out).configure().play();
  }

  @Test
  public void differentGameEachTime_inputHasBeenClosed()
  {
    new GameConfigurator(new LineParser(
      new StringReader("Y\n1\nP\nP\nP\nP\n")),
      System.out).configure().play();
  }
}
