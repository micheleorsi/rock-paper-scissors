package it.micheleorsi.adapter;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.model.RPSGesture;
import it.micheleorsi.domain.util.Parser;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class RPSConsoleUser implements Player<RPSGesture>
{

  private final Parser parser;
  private final PrintStream printStream;
  private static Map<String,RPSGesture> acronyms = new HashMap<>();
  static {
    acronyms.put("S",RPSGesture.SCISSORS);
    acronyms.put("P",RPSGesture.PAPER);
    acronyms.put("R",RPSGesture.ROCK);
  }

  public RPSConsoleUser(Parser parser, PrintStream printStream)
  {
    this.parser = parser;
    this.printStream = printStream;
  }

  @Override
  public String toString()
  {
    return "[Console]";
  }

  @Override
  public RPSGesture raise()
  {
    printStream.println("Here you are! What do you choose? [S]cissors, [R]ock or [P]aper ..");
    String rightString = parser.parseA("[SPR]");
    return acronyms.get(rightString);
  }

}
