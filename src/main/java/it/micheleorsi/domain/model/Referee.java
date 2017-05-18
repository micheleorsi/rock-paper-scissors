package it.micheleorsi.domain.model;

import it.micheleorsi.domain.usecase.Round;

public interface Referee
{

  void play(Round round);

  boolean hasFinished();

}
