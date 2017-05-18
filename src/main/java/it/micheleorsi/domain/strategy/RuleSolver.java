package it.micheleorsi.domain.strategy;

import it.micheleorsi.domain.model.Gesture;

import java.util.Optional;

public interface RuleSolver<T extends Gesture>
{

  Optional<Integer> winnerIndex(T gesture1, T gesture2);

}
