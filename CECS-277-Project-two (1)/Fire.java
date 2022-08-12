import java.util.Random;
/**
/**
*Interface for Fire moves of a Fire type Pokemon object
*/
public class Fire extends Pokemon{
  
  public Fire(String n, int h, int m){
    super(n, h, m);
  }
  @Override
  public String getAttackMenu(int atkType){
    if(atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
      String special_menu = "";
      //asdfsdfsdf = "sdfsdsdfsdsdw"
      //super.attack(this, 1, 2);
      special_menu += "1.Ember\n2.Fire Blast\n3.Fire Punch";
      return special_menu;
    }
  }
  @Override
  public int getNumAttackMenuItems(int atkType){
    if (atkType == 1){
      return super.getNumAttackMenuItems(atkType);
    }
    else{
      return 3;
    }
    //return 3;
  }

  @Override
  public String getAttackString(int atkType, int move){
    if (atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
      String fire_string = "";
      int poke_type = getType();
      if (poke_type == 0){
        if (move == 1){
          fire_string += "is encased in EMBERS and takes ";
        }
        else if (move == 2){
          fire_string += "is BLASTED with FIRE and takes ";
        }
        else {
          fire_string += "is PUNCHED with FIRE and takes ";
        }
      }
      return fire_string;
    }
  }
  @Override
  public int getAttackDamage(int atkType, int move){
    if (atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
      if (move == 1){
        Random rand = new Random();
        int ember_damage = rand.nextInt(4);
        return ember_damage;
      }
      else if(move == 2){
        int fireBlast_damage = (int)((Math.random() * 4) + 1);
        return fireBlast_damage;
      }
      else{
        int firePunch_damage = (int)((Math.random() * 3) + 1);
        return firePunch_damage;
      }
    }
  }
  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    if (atkType == 1){
      return super.getAttackMultiplier(p, atkType);
    }
    else{
      return p.battleTable[0][p.getType()];
    }
  }
}