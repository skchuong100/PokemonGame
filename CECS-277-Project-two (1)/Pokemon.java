import java.util.Scanner;
import java.util.Random;
import java.lang.Math; 
public abstract class Pokemon extends Entity{
  /**
	 * Default constructor will inherit the name
	 * and max hp of the pokemon
   * @param String n is the name of the pokemon
   * @param int mHp is the max hp of the pokemon
	 */
  public Pokemon(String n, int h, int m) {
    super(n, h, m);
  }
  public static final double [][] battleTable = {{1,.5,2}, {2,1,.5}, {.5,2,1}};
  /**
	 * String of the basic moves
	 * @return the basic moves as a string
	 */
  //@Override
  public String getAttackTypeMenu(){
    return "1.Basic Attack\n2.Special Attack";
  }
  /**
	 * Gets the number of moves in the basic moves
	 * @return the amount of basic moves
	 */
  //@Override
  public int getNumAttackTypeMenuItems(){
    //Maybe not right
    return 2;
  }
  /**
	 * Depending on the trainer choice attack with a move
	 * @param Pokemon p is the pokemon getting attacked
   * @param int move is the decision of the trainer
   * @return the battle based on the move as a string
	 */
  //"int move" will be what the move the user chooses
  /*
  
  */
  /**
	 * Makes menu of choices of basic or special attack
   * @return the two choices as a string
	 */
  //This should allow the user to choose either 
  //
  //@Override
  public String getAttackMenu(int atkType) {
    String attack_menu = "";
    if (atkType == 1){
      attack_menu += "1.Slam\n2.Tackle\n3.Punch";
      //return attack_menu;
    }
    return attack_menu;
  }
  //@Override
  public String attack(Pokemon p, int atkType, int move){
    String attack_message = "";
    int attack_dmg;
    String attack_string = "";
    double attack_multiplier;
    int attack_bonus;
    attack_dmg = getAttackDamage(atkType, move);
    attack_string += getAttackString(atkType, move);
    attack_multiplier = getAttackMultiplier(p, atkType);
    //p = new HpUp(p);
    /*
    int poke_type = getType();
    if (poke_type == 0){
      Pokemon f = new Fire(super.getName(), super.getHp(), super.getMaxHp());
      attack_dmg = f.getAttackDamage(atkType, move);
      attack_string += f.getAttackString(atkType, move);
      attack_multiplier = f.getAttackMultiplier(p, atkType);
    }
    else if(poke_type == 1){
      Pokemon w = new Water(super.getName(), super.getHp(), super.getMaxHp());
      attack_dmg = w.getAttackDamage(atkType, move);
      attack_string += w.getAttackString(atkType, move);
      attack_multiplier = w.getAttackMultiplier(p, atkType);
    }
    else{
      Pokemon g = new Grass(super.getName(), super.getHp(), super.getMaxHp());
      attack_dmg = g.getAttackDamage(atkType, move);
      attack_string += g.getAttackString(atkType, move);
      attack_multiplier = g.getAttackMultiplier(p, atkType);
    }
    */
    int attack_multi = attack_dmg * (int)Math.round(attack_multiplier);

    //int total_attack_dmg = attack_multi + attack_bonus;
    attack_bonus = getAttackBonus(atkType);
    int total_attack_dmg = attack_multi + attack_bonus;
    p.takeDamage(total_attack_dmg);
    //sdfdas = "sdfsfsdfsdfsdsd"
    attack_message += p.getName() + attack_string + "by " + getName() + " and takes " + total_attack_dmg + " damage";
    return attack_message;
  }
  //@Override
  public String getAttackString(int atkType, int move){
    String attack_string = "";
    if (atkType == 1){
      //String attack_string = "";
      if(move == 1 ){
        attack_string +=" SLAMMED ";
      }
      else if (move == 2){
        attack_string += " TACKLED ";
      }
      else{
        attack_string += " PUNCHED ";
      }
    }
    return attack_string;
  }
  //@Override
  public int getAttackDamage(int atkType, int move){
    Random rand = new Random();
    int damage = 0;
    if (atkType == 1){
      //int damage;
      if(move == 1){
        damage += rand.nextInt(6);
        //return damage;
        //return damage = rand.nextInt(6);
      }
      else if (move == 2){
        damage += rand.nextInt(2) + 2;
        //return damage;
      }
      else{
        damage += rand.nextInt(4) + 1;
        //return damage; 
      }
      return damage;
    }
    //esrsdfsfsf = " sdfssdfsdfsd"
    return 0;
  }
  //@Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    return 1.0;
    //sdfasfa = "dfsfsdfsd"
    //FIXME
  }
  //@Override
  public int getAttackBonus(int atkType){
    return 0;                                                                        
    //asdfasdf = "sdfsdfsdf"
    //FIXME
  }


  /**
	 * Gets the number of types of attacks
	 * @return the amount of types of attacks
	 */
  //@Override
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }
  
  
  /**
   * Gets the type of the pokemon
   * @return an int depending on the type of pokemon
   */
   //FIXME: UPDATE THIS 
  public int getType() {
    int result;
    if ( this instanceof Fire){
      result = 0;
    }
    else if (this instanceof Water){
      result = 1;
    }
    else{
      result = 2;
    }
    return result;
  }
}