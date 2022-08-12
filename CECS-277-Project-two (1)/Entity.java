public abstract class Entity{
  private String name;
  private int hp;
  private int maxHp;
  /**
   * Contructs an entity with a name and hp
   *@param String n is the name of the pokemon
   *@param is the max hp of the pokemon
   */
  public Entity(String n, int h, int m){
    name = n;
    maxHp = m;
    hp = h;
  }
  /**
   * Accessor the gets the hp
   * @return the current hp
   */
  public int getHp(){
    return hp;
  }
  /**
   * Accessor the gets the max hp
   * @return the max hp
   */
  public int getMaxHp(){
    return maxHp;
  }
  /**
   * Damages by taking current hp from entity
   * @param int d is the amount of damage taken
   */
  public void takeDamage(int d){
    hp -= d;
		if (hp < 0){
      hp = 0;
		}
  }
  /**
   * Heals the entity by equating the current hp to max * hp
   */
  public void heal(){
    hp = maxHp;
  }
  /**
   * Accessor the gets the name
   * @return the name
   */
  public String getName(){
    return name;
  }
  /**
   * Displays the name and current hp out of max hp
   * @return the string of the name and current hp out * of max hp
   */
  public String toString(){
    return name + " HP: " + getHp() + "/" + getMaxHp();
  }
}