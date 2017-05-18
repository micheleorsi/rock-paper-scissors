package it.micheleorsi.adapter;

import it.micheleorsi.domain.model.Player;
import it.micheleorsi.domain.repository.InMemoryScoreboardGame;
import it.micheleorsi.domain.strategy.RPSRuleSolver;
import it.micheleorsi.domain.usecase.Game;
import it.micheleorsi.domain.usecase.MultiStepGame;
import it.micheleorsi.domain.usecase.TwoPlayerRound;
import it.micheleorsi.domain.util.Parser;

import java.io.PrintStream;
import java.util.HashMap;

public class GameConfigurator
{

  private final Parser parser;
  private final PrintStream printStream;

  public GameConfigurator(Parser parser, PrintStream printStream)
  {
    this.parser = parser;
    this.printStream = printStream;
  }

  public Game configure()
  {
    String typeOfGame = askForTypeOfGame();
    Integer pointsYouNeed = askForPointsYouNeed();
    Player firstPlayer;
    if("C".equals(typeOfGame))
    {
      firstPlayer = new RPSRandomConsoleUser(printStream);
    } else
    {
      firstPlayer = new RPSConsoleUser(parser,printStream);
    }
    return getGame(pointsYouNeed, firstPlayer);
  }

  private Game getGame(Integer pointsYouNeed, Player firstPlayer)
  {
    return new MultiStepGame(
      new TwoPlayerRound(
        firstPlayer,
        new RPSRandomConsoleUser(System.out),
        new RPSRuleSolver()
      ),
      new InMemoryScoreboardGame(
        new HashMap<>(), pointsYouNeed,
        new ConsoleDisplay(System.out)
      )
    );
  }

  private String askForTypeOfGame()
  {
    printStream.println("\n __      __   _                    _                                               \n" +
      " \\ \\    / /__| |__ ___ _ __  ___  | |_ ___                                         \n" +
      "  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\                                        \n" +
      "  _\\_/\\_/\\___|_\\__\\___/_|_|_\\___|__\\__\\___/_   ___  ___ ___ ___ ___  ___  ___  ___ \n" +
      " | _ \\/ _ \\ / __| |/ / | _ \\/_\\ | _ \\ __| _ \\ / __|/ __|_ _/ __/ __|/ _ \\| _ \\/ __|\n" +
      " |   / (_) | (__| ' <  |  _/ _ \\|  _/ _||   / \\__ \\ (__ | |\\__ \\__ \\ (_) |   /\\__ \\\n" +
      " |_|_\\\\___/ \\___|_|\\_\\ |_|/_/ \\_\\_| |___|_|_\\ |___/\\___|___|___/___/\\___/|_|_\\|___/\n" +
      "                                                                                   \n\n" +
      "Now are going to configure the game ..\n" +
      "So first question: which kind of game do you want to play? [C]omputer vs computer or [Y]ou vs computer. Please specify C or Y");
    return parser.parseA("[CY]");
  }

  private Integer askForPointsYouNeed()
  {
    printStream.println(".. and second question: how many points do you need to win a match? (from 0 to 99)\n" +
      "I mean: after that amount of points, we will have a champion and the match will stop!");
    String points = parser.parseA("^(\\d?[1-9]|[1-9]0)$");
    return Integer.parseInt(points);
  }
}
