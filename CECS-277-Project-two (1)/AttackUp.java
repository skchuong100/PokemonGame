import java.util.Random;
public class AttackUp extends PokemonDecorator{
static Random rand = new Random();
  public AttackUp(Pokemon p){
    super(p, " +ATK", 0);
  }
  @Override
  public int getAttackBonus(int type){
    Random rand = new Random();
    int buff = rand.nextInt(2) + 1;
    return buff;
  }
}