import java.util.*;
public class HpUp extends PokemonDecorator{
static Random rand = new Random();
  public HpUp(Pokemon p){
    super(p, " +HP", rand.nextInt(3));
    
  }

}