/**
*Interface for Grass moves for Grasss type Pokemon Objects
*/
public class Grass extends Pokemon{
  
  public Grass(String n, int h, int m){
    super(n, h, m);
  }
  @Override
  public String getAttackMenu(int atkType){
    if (atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
      return "1.Vinewhip\n2.Razorleaf\n3.SolarBeam";
    }
  }
  @Override
  public int getNumAttackMenuItems(int atkType){
    if(atkType == 1){
      return super.getNumAttackMenuItems(atkType);
    }
    else{
      return 3;
    }
  }
  @Override
  public String getAttackString(int atkType, int move){
    if(atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
      if(move == 1){
        return "is VINE WHIPPED and takes ";
      }
      else if(move == 2){
        return "is SLASHED with RAZOR LEAF and takes ";
      }
      else{
        return "is dazzled by SOLAR BEAM and takes ";
      }
    }

  }
  @Override
  public int getAttackDamage(int atkType, int move){
    if(atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
      if (move == 1){
        int vineWhip_damage = (int)((Math.random() * 3) + 1);
        return vineWhip_damage;
      }
      else if(move == 2){
        int razorLeaf_damage = (int)((Math.random() * 3) + 2);
        return razorLeaf_damage;
      }
      else{
        int solarBeam_damage = (int)((Math.random() * 4) + 0);
        return solarBeam_damage;
      }
    }

  }
  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    if(atkType == 1){
      return super.getAttackMultiplier(p, atkType);
    }
    else{
      return p.battleTable[2][p.getType()];
    }

  }
}