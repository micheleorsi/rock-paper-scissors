package it.micheleorsi.domain.repository;

import it.micheleorsi.domain.model.Player;

import java.util.Optional;

public interface ScoreboardGame
{

  void markScoreFor(Player player);

  void markTie();

  Optional<Player> champion();

}
