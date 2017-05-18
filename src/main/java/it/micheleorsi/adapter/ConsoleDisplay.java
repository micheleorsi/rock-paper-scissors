package it.micheleorsi.adapter;

import it.micheleorsi.domain.util.Display;

import java.io.PrintStream;

public class ConsoleDisplay implements Display
{

  private final PrintStream printStream;

  public ConsoleDisplay(PrintStream printStream)
  {
    this.printStream = printStream;
  }

  @Override
  public void println(String text)
  {
    printStream.println(text);
  }

}
