package it.micheleorsi.domain.usecase;

import it.micheleorsi.domain.model.Player;

import java.util.Optional;

public interface Round
{
  Optional<Player> winner();
}
