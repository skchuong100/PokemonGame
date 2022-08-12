/**
*Interface for Water moves of Water type pokemon
*/
public class Water extends Pokemon{
  
  public Water(String n, int h, int m){
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType){
    if(atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
      //sdfsds = "sdfsdfsd"
      return "1.Watergun\n2.Bubble Beam\n3.Waterfall";
    }
    //return "1.Watergun\n2.Bubble Beam\n3.Waterfall";
  }

  @Override
  public int getNumAttackMenuItems(int atkType){
    if (atkType == 1){
      return super.getNumAttackMenuItems(atkType);
    }
    else{
      return 3;
    }
    //return 2;
  }
  @Override
  public String getAttackString(int atkType, int move){
    if(atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
      if(move == 1){
        return "is shot with WATER GUN and takes ";
        }
        else if(move == 2){
        return "is blased with BUBBLES and takes";
        }
        else{
        return "is splashed with a WATERFALL and takes";
      }
    }
  }
  @Override
  public int getAttackDamage(int atkType, int move){
    if(atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
      if(move == 1){
        int waterGun_damage = (int)((Math.random() * 4) + 2);
        return waterGun_damage;
      }
      else if(move== 2){
        int bubbleBeam_damage = (int)((Math.random() * 3) + 1);
        return bubbleBeam_damage;
      }
      else{
        int waterfall_damage = (int)((Math.random() * 4) + 1);
        return waterfall_damage;
      }
    }
  }
  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    if (atkType == 1){
      return super.getAttackMultiplier(p, atkType);
    }
    else{
      return p.battleTable[1][p.getType()];
    }

  }


}