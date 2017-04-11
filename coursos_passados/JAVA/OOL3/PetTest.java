import java.util.*;

public class PetTest
{
     public static void main(String[] args)
     {
          Random rand = new Random();
          final int PET_RANGE = 50;
          final int HOME_RANGE = 10;
          Pet[] pets = new Pet[PET_RANGE];
          Household[] homes = new Household[HOME_RANGE];
          for (int x = 0; x < PET_RANGE; x++)
          {
               int y = rand.nextInt(5);
               if (y == 0)
                    pets[x] = new Bird();
               else if (y == 1)
                    pets[x] = new Cat();
               else if (y == 2)
                    pets[x] = new Dog();
               else if (y == 3)
                    pets[x] = new Fish();
               else
                    pets[x] = new Rabbit();
          }
          
          /**
          for (int x = 0; x < PET_RANGE; x++)
               System.out.println(pets[x]);
          */
          for (int x = 0; x < HOME_RANGE; x++)
          {
               homes[x] = new Household();
               //System.out.println(homes[x]);
          }
          
          int x = 0;
          int y = 0;
          while (x < PET_RANGE && y < HOME_RANGE)
          {
               try
               {
                    homes[y].addPet(pets[x]);
                    x++;
               }
               catch (Exception e)
               {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println(homes[y]);
                    System.out.println("-----");
                    System.out.println(pets[x]);
                    y++;
               }
          }
         
     }
}
