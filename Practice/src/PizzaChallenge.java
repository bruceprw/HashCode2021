import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/*public class PizzaChallenge {
public int numberOfPizzas;
public int teamsOf2;
public int teamsOf3;
public int teamsOf4;

    // void readFile(File f) {
    //     Scanner in = new Scanner(f);
       
    //     numberOfPizzas= in.nextInt();
    //     teamsOf2= in.nextInt();
    //     teamsOf3= in.nextInt();
    //     teamsOf4= in.nextInt();

    //     while (in.nextLine() !=null)
    //     {
    //         String input = in.nextLine();
    //         Scanner line = new Scanner(input);
    //         int numberOfIngredients = line.nextInt();
    //         ArrayList<String> ingredients = new ArrayList<String>();
    //         while(line.next() !=null)
    //         ingredients.add(line.next());
    //         line.close();
    //     }
    //     in.close();
        
        
    // }
    // public static void main(String[] args)
    // {
    //     File f = new File("a_example");
    //     readFile(f);
    // }
}
*/

public class Pizza
{
    public ArrayList<String> ingredients;
    
    public Pizza(String line)
    {
        line = line.substring(line.indexOf(" ") + 1);
        ingredients = new ArrayList<>();
        String[] ingred = line.split(" ");
        Collections.addAll(ingredients, ingred);
    }
}

public HashSet<String> calcDifferentIngredients(ArrayList<Pizza> pizzas)
{
    HashSet<String> uniqueIngredients = new HashSet<>();

    for(Pizza p : pizzas)
        Collections.addAll(uniqueIngredients, p.ingredients);

    return uniqueIngredients;
}

public static void main(String[] args) throws IOException
{
    String inData = Files.readString(Paths.get("a_example"));
    String[] lines = inData.split("\n");

    String[] metaData = lines[0].split(" ");

    int noPizzasAvailable = Integer.parseInt(metaData[0]);
    int numOfTeams2 = Integer.parseInt(metaData[1]);
    int numOfTeams3 = Integer.parseInt(metaData[2]);
    int numOfTeams4 = Integer.parseInt(metaData[3]);
    int totalNumPizzasRequired = (4 * numOfTeams4) + (3 * numOfTeams3) + (2 * numOfTeams2);

    ArrayList<Pizza> pizzas = new ArrayList<>();
    for(int i = 1; i < lines.length; i++)
        pizzas.add(new Pizza(lines[i]));

    int totalNumDiffIngredients = calcDifferentIngredients(pizzas);

    int idealNumPizzasPerTeam = noPizzasAvailable / 3;
    int remainderPizzas = noPizzasAvailable % 3;

    int pizzasForTeam2 = idealNumPizzasPerTeam;
    int pizzasForTeam3 = idealNumPizzasPerTeam;
    int pizzasForTeam4 = idealNumPizzasPerTeam;

    if(pizzasForTeam2 % 2 != 0)
    {
        remainderPizzas += 1;
        pizzasForTeam2 -= 1;
    }

    if(pizzasForTeam3 % 3 != 0) 
    {
        remainderPizzas += (pizzasForTeam3 % 3);
        pizzasForTeam3 -= (pizzasForTeam3 % 3);
    }

    if(pizzasForTeam4 % 4 != 0) 
    {
        remainderPizzas += (pizzasForTeam4 % 4);
        pizzasForTeam4 -= (pizzasForTeam4 % 4);
    }

    if(remainderPizzas != 0)
    {
        switch (remainderPizzas)
        {
            case 2: pizzasForTeam2 += 2; break;
            case 3: pizzasForTeam3 += 3; break;
            case 4: pizzasForTeam4 += 4; break;
            case 5: pizzasForTeam3 += 3; pizzasForTeam2 += 2; break;
            case 6: pizzasForTeam3 += 6; break;
            case 7: pizzasForTeam4 += 4; pizzasForTeam3 += 3; break;
            case 8: pizzasForTeam4 += 8; break;
        }
    }

    int finalNumPizzasUsed = pizzasForTeam2 + pizzasForTeam3 + pizzasForTeam4;



    /*correct number of pizzas per team roughly balanced
    total number of different ingredeients in a data set
    
    
}


/*submission file:

    D - pizzas delivered is first line
    L (#people in team) ' ' P (pizza names e.g. 0,1,2,3,4) - each line thereafter <=3 lines
    
*/

    // 10000 pizzas 20x2 30x3 15x4

    //     for i = 0 to 10000
    //         equally distribute pizzas between team groups
    //         so 1 pizza to x2, 1 to x3, 1 to x4
        
    //     end team will either full or have remainder

    //     sum of the teams remainder - 3 + 2 + 1 = 6    RANGE 1 - 6 INCLUSIVE

    //     backtrack - remove one of team of 4 



}

