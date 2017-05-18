package it.micheleorsi;

import it.micheleorsi.adapter.GameConfigurator;
import it.micheleorsi.adapter.LineParser;
import it.micheleorsi.domain.usecase.Game;

import java.io.InputStreamReader;

public class Main
{

  public static void main(String args[])
  {
    Game game = new GameConfigurator(new LineParser(
      new InputStreamReader(System.in)),
      System.out).configure();
    game.play();
  }
}
