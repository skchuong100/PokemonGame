import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

/**
 * 
 * Acts as the map for both 
 * a hidden and revealed map
 *
 */
public class Map{
  private char [][] map;
  private boolean [][] revealed;
  static private Map instance = null;
   

  
  /**
  *Default constructor will declare
  * the map that is hiddena and 
  *revealed
  */

   private Map() {
     map = new char[5][5];
     revealed = new boolean[5][5];
   }

   public static Map getInstance(){
     if( instance == null ) {
       instance = new Map();
      }
    return instance;
   }
/**
 * 
 * @param mapNum - acts as what map 
 * number will be loaded
 * 
 */
public void loadMap(int mapNum){
      int theMap = mapNum;
      if (mapNum > 3) {
         theMap = mapNum % 3;
      }
      Path file = Paths.get("./Area" + theMap + ".txt");
      int i = 0;
      
      for (int y = 0; y < revealed.length; y++) {
         for (int z = 0; z < revealed[0].length; z++) {
            revealed[y][z] = false;
         }
      }   
      
      try (InputStream in = Files.newInputStream(file);
         BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
         String line = null;

         while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            for(int j = 0; j < values.length; j++) {
               map[i][j] = values[j].charAt(0);
            }
            i++;
         }
      } catch (IOException x) {
         System.err.println(x);
      }
   }

   public char getCharAtLoc(Point p){
      char i = map[p.x][p.y];
      return i;
   }
/**
 * 
 * @param p - Acts as the value for x and y
 * for the 2D array used
 * @return - returns the letter on the map,
 * whether it should be revealed or stay 
 * hidden
 */
  public String mapToString(Point p){ 
      String theMap = "";
      for (int i = 0; i < map.length; i++) {
         for( int j = 0; j < map.length; j++) {
            if (p.x == i && p.y == j) {
               theMap = theMap + "* ";
            } else if (revealed[i][j] != true) {
               theMap = theMap + "x ";
            } else {
               theMap = theMap + map[i][j] + " ";
            }
         }
         theMap = theMap + "\n";
      }
      return theMap;
   }
/**
 * 
 * @return - Returns the location of 
 * the Start on the 2D array
 */
  public Point findStart(){
      Point point = new Point(0, 0);
      
      for (int i = 0; i < map.length; i++) {
         for (int j = 0; j < map[0].length; j++) {
            if (map[i][j] == 's') {
               point = new Point(i, j);
               reveal(point);
               return point; 
            }
         }
      }
      return point;
  }
/**
 * 
 * @param p - Takes in the point
 * on the 2D array to reveal the 
 * letter 
 */
  public void reveal(Point p){
      int x = p.x;
      int y = p.y;
      revealed[x][y] = true;
   }
   
  /**
   * 
   * @param p - Takes in the point
   * of where the trainer is at
   * and removes the trainer from
   * the point
   */
   public void removeCharAtLoc(Point p){
      int x = p.x;
      int y  = p.y;
      map[x][y] = 'n';  
      
   }
   
}

