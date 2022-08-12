import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.math.BigDecimal;
public class Trainer extends Entity{
  
  private int money;
  private int potions;
  private int pokeballs;
  private Point loc;
  private ArrayList <Pokemon> pokemon;
  /**
   * Contructs an Trainer with a name initial pokemon
   * and map
   * @param String n is the name of the trainer
   * @param Pokemon p is the first pokemon they choose
   * @param Map m is the map
   */
  public Trainer(String n, Pokemon p){
     super(n, 25, 25);
     pokemon = new ArrayList <Pokemon> ( );
     pokemon.add(p);
     Map map = Map.getInstance();
     map.loadMap(1);
     loc = map.findStart();
  }
  /*
  * getMoney - retrieves the amount of money
  * @return - the amount of money.
  */
  public int getMoney(){
    return money;
  }
  /*
  * spendMoney - allows the user to spend money.
  * @param int amt is the amount of money.
  * @return boolean depeding on if the trainer has money * or not
  */
  public boolean spendMoney(int amt){
    if (money > amt){
      money = money - amt;
      return true;
    }else{
      return false;
    }
  }
  /*
  * recieveMoney - allows the user to add money to his * total money.
  * @param int amt is the amount of money being
  * recieved.
  */
  public void recieveMoney(int amt){
    money += amt;
  }
  /*
  * hasPotion - checks if user has has potion.
  * @return - return true if trainer has money to
  * potion, return false if trainer has no potion.
  */
  public boolean hasPotion(){
    if (potions > 0){
      return true;
    }
    else{
      return false;
    }
  }
 /*
  * recievePotion - gives user a potion the collection 
  * of potions. 
  */
  public void recievePotion(){
    potions += 1;
  }
 /*
  * usePotion - allows user to consume a potion.
  * @param int pokeIndex is the index at which pokemon * should be healed.
  */
  public void usePotion(int pokeIndex){
    Pokemon p = pokemon.get(pokeIndex);
    if (potions > 0){
      if (p.getHp() < 24){
        p.heal(); //heal pokemon
        potions -= 1; //potions gets used
      } else {
        System.out.println("Your pokemon is already at full health");
      }
    } else{
      System.out.println("Out of potions"); //if no potions are left
    }
  }
  /*
  * hasPotion - checks if user has potion.
  * @return - return true if user has pokeballs and 
  * return false if user does not have pokeballs.
  */
  public boolean hasPokeball(){
    if (pokeballs > 0){
      return true;
    }
    else{
      return false;
    }
  }
  /*
  * recievePokeball - gives user one pokeball.
  *  
  */
  public void recievePokeball(){
    pokeballs += 1;
  }
  /*
  * catchPokemon - allows user to catch wild pokemon 
  * depeding o th odds.
  * @param Pokemon p the pokemon that might be caught.
  * @return return true if pokemon is caught and 
  * returns false if pokemon is not caught.
  */
  public boolean catchPokemon(Pokemon p){
    boolean result;
    double value = 1.0;
    double DiffPrec = ((double)p.getHp()/(double)p.getMaxHp()); //precentage of health
    double OddPrec = (value - DiffPrec); //odd precentage
    double randNum1 = Math.random();
    if (randNum1 <= OddPrec){
      pokemon.add(p); //add to catch pokemon
      pokeballs -= 1;
      result = true;
    } else {
      result = false;
    }
    return result;
  }
  /*
  * getLocation - retrieves current trainer point 
  * location.
  * @return - the point location
  */
  public Point getLocation(){
    return loc; //gets location
  }
  /*
  * goNorth - moves the trainer up the map 
  * @return the char at the point on the map
  */
  public char goNorth(){
      Map map = Map.getInstance();
      //Returns char
      char theReturn = 'n';
      //Make sure the movement is valid
      if (loc.x > 0) {
         loc.x = loc.x - 1;
         map.reveal(loc);
         theReturn = map.getCharAtLoc(loc);
      //If value is not valid, set it to arbitrary value x
      } else {
         theReturn = 'x';
         System.out.println("You can't go that way!");
      }
      
      //Return Statement
      return theReturn;
   }
 /*
  * goSouth - moves the trainer down the map 
  * @return the char at the point on the map
  */
  public char goSouth(){
      Map map = Map.getInstance();
      //Return Char
      char theReturn = 'n';
      //Make sure the movement is valid
      if (loc.x < 4) {
         loc.x = loc.x + 1;
         map.reveal(loc);
         theReturn = map.getCharAtLoc(loc);
      //If value is not valid, set it to arbitrary value x
      } else {
         theReturn = 'x';
         System.out.println("You can't go that way!");
      }
      
      //Return Statement
      return theReturn;
   }
  /*
  * goEast - moves the trainer right of the map 
  * @return the char at the point on the map
  */
  public char goEast(){
      Map map = Map.getInstance();
       //Return Char
      char theReturn = 'n';
      //Make sure the movement is valid
      if (loc.y < 4) {
         loc.y = loc.y + 1;
         map.reveal(loc);
         theReturn = map.getCharAtLoc(loc);
      //If value is not valid, set it to arbitrary value x
      } else {
         theReturn = 'x';
         System.out.println("You can't go that way!");
      }
      
      //Return Statement
      return theReturn;
   }
  /*
  * goWest - moves the trainer left of the map 
  * @return the char at the point on the map
  */
  public char goWest(){
      Map map = Map.getInstance();
      //Return Char
      char theReturn = 'n';
      //Make sure the movement is valid
      if (loc.y > 0) {
         loc.y = loc.y - 1;
         map.reveal(loc);
         theReturn = map.getCharAtLoc(loc);
      //If value is not valid, set it to arbitrary value x
      } else {
         theReturn = 'x';
         System.out.println("You can't go that way!");
      }
      
      //Return Statement
      return theReturn;
  }


  /*
  * Gives the amount of pokemon the trainer has 
  * @return the amount of pokemon the trainer has 
  */
  public int getNumPokemon(){
    return pokemon.size();
  }
  /*
  * Heals all the pokemon when they go to a hospital
  */
  public void healAllPokemon(){
    for (int i = 0; i < pokemon.size(); i++){//iterates through pokemon by index
      Pokemon p = pokemon.get(i);
      p.heal(); //heals pokemon except if there is no potions left
      }
    }
  /*
  *
  *
  */
  public void buffAllPokemon(){
    //FIX ME
  }

  public void debuffPokemon(int index){
    //FIX ME
  }
  /*
  * Gets the pokemon at the index of the ArrayList 
  * @param int index is the spot the pokemon is
  * @return the Pokemon at that index
  */
  public Pokemon getPokemon(int index){
    return pokemon.get(index);//gets the pokemon at a certain index
  }
  /*
  * Shows the pokemon the trainer has 
  * @return the pokemon the trainer has as a string 
  */
  public String getPokemonList(){
    String pokemon_list = "";
    for (int i = 0; i < getNumPokemon(); i++){
      pokemon_list += i+1 + "." + getPokemon(i).toString()+ "\n";
    }
    return pokemon_list;
  }

  public Pokemon removePokemon(int index){
    return pokemon.remove(index); 
  }
  /*
  * Displays the trainets name, hp/maxhp, money, 
  * potions, pokeballs, and pokemon
  * @return the trainets name, hp/maxhp, money, 
  * potions, pokeballs, and pokemon as a string 
  */
  @Override
  public String toString(){
    Map map = Map.getInstance();
    String stats = "";
    stats += "\n" + getName() + ": " + getHp() + "/" + getMaxHp() + "\n" + "Money: " + money + "\n" + "Potions: " + potions + "\n" + "Poke Balls: " + pokeballs + "\n" + "Pokemon\n-------" + "\n" + getPokemonList() + "\n" + map.mapToString(getLocation());
    return stats;
  }
}
