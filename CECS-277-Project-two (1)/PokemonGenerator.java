import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.util.Random;

public class PokemonGenerator{
  private HashMap<String, String> pokemon;
  private static PokemonGenerator instance = null;


  private PokemonGenerator(){
    pokemon = new HashMap<String,String>();
    BufferedReader br = null;
    try{
      File file = new File("PokemonList.txt");
      br = new BufferedReader(new FileReader(file));
      String line = null;
      while((line = br.readLine()) != null){
        String [] parts = line.split(",");
        String pokemonName = parts[0].trim();
        String pokemonType = parts[1].trim();
        //System.out.println(pokemonName);
        //System.out.println(pokemonType);
        if(!pokemonName.equals("") && !pokemonType.equals("")){
          pokemon.put(pokemonName, pokemonType);
        }

      }
      //System.out.println(pokemon.get(1));
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally{
      if(br != null){
        try { 
        br.close(); 
        }catch(Exception e){};
      }
    }        
    
  }

  public static PokemonGenerator getInstance(){
    if (instance == null){
      instance = new PokemonGenerator();
    }
    return instance;
  }

  public Pokemon generateRandomPokemon(int level){
    ArrayList<String> ppokemon = new ArrayList<>();
    for ( String key : pokemon.keySet() ) {
    ppokemon.add(key);
    }
    Random rand = new Random();
    int randomIndex = rand.nextInt(pokemon.size());
    System.out.println("=-=-=-=-=-=--=--==-=-=-=-=-=-");
    System.out.println(randomIndex);
    //System.out.println(pokemon.get(randomIndex));
    Pokemon RandomPokemon;
    String poke_name = "";
    int y = 0;
    for (String key : pokemon.keySet()){
      //int y = 0;
      //System.out.println(key);
      poke_name = key;
      if (y == randomIndex){
        break;
      }
      y++;
    }
    System.out.println("+++++++++++++++++++++++++++");
    System.out.println(poke_name);
    RandomPokemon = getPokemon(poke_name);
    if (level > 1){
      for (int x = 0; x < level-1; x++){
      RandomPokemon = addRandomBuff(RandomPokemon);
      }
    }
    return RandomPokemon;
  }

  public Pokemon getPokemon(String name){
    int result;
    //asdfaasfsd = "sdfsdfsdfsdf"
    if (name.equals("Charmander") ||  name.equals("Ponyta") ||  name.equals("Vulpix") ||  name.equals("Growlithe") ||  name.equals("Moltres")){
      //Fire firePokemon = new Fire(name,25,25);
      return new Fire(name, 25, 25);
    }
    else if (name.equals("Squirtle") ||  name.equals("Staryu") ||  name.equals("Poliwag") ||  name.equals("Tentacool") ||  name.equals("Goldeen") ||  name.equals("Seel") ||  name.equals("Shellder") ||  name.equals("Krabby") ||  name.equals("Lapras") ||  name.equals("Magikarp") ||  name.equals("Horsea")||  name.equals("Slowpoke")){
      //Water waterPokemon = new Water(name,25,25);
      return new Water(name, 25, 25);
    }
    else{
      //Grass grassPokemon = new Grass(name,25,25);
      return new Grass(name, 25, 25);
    }

  }

  public Pokemon addRandomBuff(Pokemon p){
    //asdfsda = "sdfsdfsd"
    Random rand = new Random();
    int random_num = rand.nextInt(1);
    if (random_num == 0){
      p = new AttackUp(p);
    }
    else{
      p = new HpUp(p);
    }
    return p;
  }

  public Pokemon addRandomDebuff(Pokemon p){
   //asdfsda = "sdfsdfsd"
    Random rand = new Random();
    int random_num = rand.nextInt(1);
    if (random_num == 0){
      p = new AttackDown(p);
    }
    else{
      p = new HpDown(p);
    }
    return p;
  }


}