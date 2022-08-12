import java.util.Random;
public class AttackDown extends PokemonDecorator{

  public AttackDown(Pokemon p){
    super(p, " -ATK", 0);
  }
  @Override
  public int getAttackBonus(int type){
    Random rand = new Random();
    int debuff = rand.nextInt(-1) + -2;
    return debuff;
  }




}