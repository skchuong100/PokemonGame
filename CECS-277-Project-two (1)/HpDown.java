import java.util.*;
public class HpDown extends PokemonDecorator{
  static Random rand = new Random();
  public HpDown(Pokemon p){
    super(p, " -HP", rand.nextInt(-1) + -2);
  }
}