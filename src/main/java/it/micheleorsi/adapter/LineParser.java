package it.micheleorsi.adapter;

import it.micheleorsi.domain.util.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LineParser implements Parser
{

  private final BufferedReader bufferedReader;

  public LineParser(Reader source)
  {
    bufferedReader = new BufferedReader(source);
  }

  @Override
  public String parseA(String regex)
  {
    String line="";
    try
    {
      while(!line.matches(regex))
      {
        line = bufferedReader.readLine();
        line = line.trim().toUpperCase();
      }
      return line;
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

  }

}
