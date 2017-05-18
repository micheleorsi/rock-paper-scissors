package it.micheleorsi.adapter;

import it.micheleorsi.domain.util.Parser;
import org.junit.Test;

import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineParserTest
{

  private Parser underTest;

  @Test
  public void parseInTheRightWayASingleChar()
  {
    StringReader sr = new StringReader("P");
    underTest = new LineParser(sr);
    String parsed = underTest.parseA("[P]");
    assertThat(parsed,is(equalTo("P")));
  }

  @Test
  public void parseInTheRightWayASingleInputLowerCase()
  {
    StringReader sr = new StringReader("p");
    underTest = new LineParser(sr);
    String parsed = underTest.parseA("[P]");
    assertThat(parsed,is(equalTo("P")));
  }

  @Test
  public void parseInTheRightWayWithSpaces()
  {
    StringReader sr = new StringReader("     P ");
    underTest = new LineParser(sr);
    String parsed = underTest.parseA("[P]");
    assertThat(parsed,is(equalTo("P")));
  }

  @Test
  public void continueToWaitForInputWhenThereAreMistakes()
  {
    StringReader sr = new StringReader("z\n asd\nz\n a sd\n P ");
    underTest = new LineParser(sr);
    String parsed = underTest.parseA("[P]");
    assertThat(parsed,is(equalTo("P")));
  }
}
