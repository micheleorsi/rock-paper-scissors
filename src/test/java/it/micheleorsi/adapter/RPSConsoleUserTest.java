package it.micheleorsi.adapter;

import it.micheleorsi.domain.model.RPSGesture;
import it.micheleorsi.domain.util.Parser;
import org.junit.Test;

import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RPSConsoleUserTest
{

  private RPSConsoleUser underTest;

  @Test
  public void returnRightEnumPaper()
  {
    Parser parser = new LineParser(new StringReader("P"));
    underTest = new RPSConsoleUser(parser,System.out);
    RPSGesture gesture = underTest.raise();
    assertThat(gesture,is(equalTo(RPSGesture.PAPER)));
  }

  @Test
  public void returnRightEnumRock()
  {
    Parser parser = new LineParser(new StringReader("R"));
    underTest = new RPSConsoleUser(parser,System.out);
    RPSGesture gesture = underTest.raise();
    assertThat(gesture,is(equalTo(RPSGesture.ROCK)));
  }

  @Test
  public void returnRightEnumScissors()
  {
    Parser parser = new LineParser(new StringReader("S"));
    underTest = new RPSConsoleUser(parser,System.out);
    RPSGesture gesture = underTest.raise();
    assertThat(gesture,is(equalTo(RPSGesture.SCISSORS)));
  }
}
