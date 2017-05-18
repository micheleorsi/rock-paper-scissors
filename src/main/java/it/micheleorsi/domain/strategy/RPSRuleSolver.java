package it.micheleorsi.domain.strategy;

import it.micheleorsi.domain.model.RPSGesture;

import java.util.Optional;

public class RPSRuleSolver implements RuleSolver<RPSGesture>
{

  @Override
  public Optional<Integer> winnerIndex(RPSGesture gesture1, RPSGesture gesture2)
  {
    if(gesture1==gesture2)
    {
      return Optional.empty();
    }
    switch (gesture1)
    {
      case SCISSORS:
        return gesture2 == RPSGesture.ROCK ? Optional.of(1) : Optional.of(0);
      case ROCK:
        return gesture2 == RPSGesture.PAPER ? Optional.of(1) : Optional.of(0);
      default: // PAPER
        return gesture2 == RPSGesture.SCISSORS ? Optional.of(1) : Optional.of(0);
    }
  }

}
