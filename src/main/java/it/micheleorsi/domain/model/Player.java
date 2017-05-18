package it.micheleorsi.domain.model;

public interface Player<T extends Gesture>
{
  T raise();
}
