import java.util.*;
import java.io.*;
/**
* 'The Big One' is an extensive program that uses objects to place pets into households based on certain criteria. User input is requested to decide which criteria is returned automatically.
*/
public class theBigOne
{
/*
The main method reads data from a file storing pet data, creates the appropriate object (pet or household), and assigns the object to the appropriate arrayList.Also, it calls the appropriate method according to the user input.
*/
 public static void main (String args[]) throws FileNotFoundException, BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {
  ArrayList<Pet> petList = new ArrayList<Pet>();
  ArrayList<Household> houseList = new ArrayList<Household>();

  //enter file to read here :)
  File Data1 = new File("DataSet1.txt");
  Scanner bigEye = new Scanner(Data1);
  int petCounter = 0;

  //read data from file and create pets then add to appropriate arrayList
  while (bigEye.hasNext()) {
   String line = bigEye.nextLine();
   if(line.contains("The")) {

    petCounter += 1;
    //get pet name    
    String [] petName = line.split(":");
    String name = petName[1].trim();
  
    //get double of hours of care required
    String[] careHours = bigEye.nextLine().split(":");
    String filler1 = careHours[1].trim();
    double hours = Double.parseDouble(filler1);
    
    //get double for cost of care
    String [] careCost = bigEye.nextLine().split(":");
    String filler2 = careCost[1].trim();
    double care = Double.parseDouble(filler2);
    
    //get double for owner satisfaction 
    String [] satis = bigEye.nextLine().split(":");
    String filler3 = satis[1].trim();
    double sat = Double.parseDouble(filler3);
    
    //get double for pet reflex 
    String [] ref = bigEye.nextLine().split(":");
    String filler4 = ref[1].trim();
    double reflex = Double.parseDouble(filler4);  

    //check if line includes pet data
    if(line.contains("The Fish")) {
    
     //get boolean for whether or not poisonous
     String [] pois = bigEye.nextLine().split(":");
     String filler5 = pois[1].trim();
     boolean poison = Boolean.valueOf(filler5);
    
     //create new fish object 
     petList.add(new Fish(name, hours, care, sat, reflex, poison));
    }
   
    else if(line.contains("The Cat")) {
     //get boolean value whether or not the cat is declawed
     String [] dec = bigEye.nextLine().split(":");
     String filler6 = dec[1].trim();
     boolean declawed = Boolean.valueOf(filler6);
     
     //get boolean dog tolerance value
     String [] tol = bigEye.nextLine().split(":");
     String filler7 = tol[1].trim();
     boolean dogTolerance = Boolean.valueOf(filler7);

     //get boolean value for if cat eats birds 
     String [] eatsb = bigEye.nextLine().split(":");
     String filler8 = eatsb[1].trim();
     boolean eatsBirds = Boolean.valueOf(filler8);
    
     //get boolean value for if cat eats rabbits
     String [] eatsr = bigEye.nextLine().split(":");
     String filler9 = eatsr[1].trim();
     boolean eatsRabbits = Boolean.valueOf(filler9);

     //get boolean value for if cat eats fish
     String [] eatsf = bigEye.nextLine().split(":");
     String filler10 = eatsf[1].trim();
     boolean eatsFish = Boolean.valueOf(filler10);

     //create new cat object
     petList.add(new Cat(name, hours, care, sat, reflex, declawed, dogTolerance, eatsBirds, eatsRabbits, eatsFish));

    }
    else if(line.contains("The Dog")) {
     //get double for barking frequency 
     String [] b = bigEye.nextLine().split(":");
     String filler11 = b[1].trim();
     double barking = Double.parseDouble(filler11);      
     
     //get boolean value for if dog tolerates cats
     String [] catTol = bigEye.nextLine().split(":");
     String filler12 = catTol[1].trim();
     boolean toleratesCats = Boolean.valueOf(filler12);

     //get boolean value for if dog eats rabbits
     String [] eatsRa = bigEye.nextLine().split(":");
     String filler13 = eatsRa[1].trim();
     boolean eatsRab = Boolean.valueOf(filler13);

     //create new dog object
     petList.add(new Dog(name, hours, care, sat, reflex, toleratesCats, eatsRab, barking));

    }
    else if(line.contains("The Bird")) {
     //get double for tweeting frequency 
     String [] tweet = bigEye.nextLine().split(":");
     String filler14= tweet[1].trim();
     double tweetFrequency = Double.parseDouble(filler14);   
    
     //get boolean for whether the bird can fly
     String [] fly = bigEye.nextLine().split(":");
     String filler15 = fly[1].trim();
     boolean canFly = Boolean.valueOf(filler15);    
    
     //get boolean for whether the bird eats rabbits
     String [] eatRa = bigEye.nextLine().split(":");
     String filler16= eatRa[1].trim();
     boolean birdEatsRabbits = Boolean.valueOf(filler16);
     
     //get boolean for whether bird eats fish     
     String [] eatFishy = bigEye.nextLine().split(":");
     String filler17 = eatFishy[1].trim();
     boolean eatsFishies = Boolean.valueOf(filler17);

     //create new bird object
     petList.add(new Bird(name, hours, care, sat, reflex, tweetFrequency, canFly, birdEatsRabbits, eatsFishies));
    }
    else if(line.contains("The Rabbit")) {
     //get double for panic attack frequency
     String [] panic = bigEye.nextLine().split(":");
     String filler18 = panic[1].trim();
     double panicAttack = Double.parseDouble(filler18);   
     //create new rabbit object
     petList.add(new Rabbit(name, hours, care, sat, reflex, panicAttack));

    }
   }
   if(line.contains("Home")) {
    //get home name    
    String [] homeName = line.split(" ");
    String houseName = homeName[1].trim();


    //get double of hours of possible care
    String[] houseCare = bigEye.nextLine().split(":");
    String fill = houseCare[1].trim();
    double houseHours = Double.parseDouble(fill);

    //get double for max pet budget
    String [] houseCost = bigEye.nextLine().split(":");
    String fil = houseCost[1].trim();
    double houseCareCost = Double.parseDouble(fil);

    //add household to arraylist
    houseList.add(new Household(houseName, houseHours, houseCareCost));
   }
  }

  //what does the user want to do with the data lists?
  Scanner littleEye = new Scanner(System.in);
  boolean stop = false;
  while(!stop) {
   System.out.println("What would you like to do? \n1. Maximize Total Happiness \n2. Maximize Total Happiness(left over pets will be euthanized) \n3. Maximize Leftover Budget (5 unit no-pet tax) \n4. Maximize Leftover Budget (5 unit no-pet tax, 10 extra to euthanize left over pets)\n5. Minimize pets being euthanized \n6. Minimize euthanized pets (limit 3 pets per household) \n7. Maximize Affluency \n 8. Exit Program.");
   int userInput = littleEye.nextInt();

   switch (userInput) {
    case 1:
     maxHappy(petList, houseList);
     break;
    case 2:
     HappyAndPenalties(petList, houseList);
     break;
    case 3:
     maxMoneyLeftover(petList, houseList); 
     break;  
    case 4:
     maxMoneyLeftoverPenalties(petList, houseList);
     break; 
    case 5:
     minEuthanizations(petList, houseList); 
     break;
    case 6:
    minEuthanizationsWithLimit(petList, houseList);
     break;
    //case 7:
    case 8: 
     stop = true;
     break;
   }
  }

 }
/* Minimizes number of pets being euthanized with limit of 3 per household.
 * @param petList
 * @param houseList
 * @param budget
 * @param totalHappiness
 * @param euthPets
 * @param affluency
 */

//6
public static void minEuthanizationsWithLimit(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = MoneyQuickSort(petList);
  houseList = HouseMoneySort(houseList); 
  double budget = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;

  System.out.println("List of Households and Pets: ");
  for(Household house : houseList) {
   if(petList.isEmpty())
    break;
   if(petList.size()<3)
    break;
   for(int a = 0; a<petList.size(); a++) {  
    double sat = petList.get(a).getCostOfCare();
    if(sat>=0) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
     }
   
    }
   if(house.pets.isEmpty()) {
    double currBudget = house.getBudget();
    budget = currBudget-5;       
    house.setBudget(budget);
   }
   if(house.pets.size()==1 || house.pets.size()==2) {
    totalHappiness = totalHappiness - .3;
   }
   if(house.pets.size()==3) {
    totalHappiness = totalHappiness - .1;
   }
  System.out.println("Household: "+ house);
  budget = house.getBudget();
  totalHappiness = totalHappiness + house.happiness;
  }

  for(Pet pet : petList) {
   euthPets++;
  }
  int societyTax = euthPets*10;
  budget = budget - societyTax;
  double affluency = budget + totalHappiness - societyTax;
  System.out.println("Surplus Budget: "+budget);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+affluency);
  System.out.println("Number of euthanized pets: " + euthPets);

 }
/* Maximize amount of leftover money or minimize number of pets that must be euthanized (accomplishes both tasks). Household without a pet must pay 5 unit tax. Unplaced pet costs society 10 units to euthanize.
 * @param petList
 * @param houseList
 * @param budget
 * @param totalHappiness
 * @param euthPets
 * @param affluency
 */
//5
public static void minEuthanizations(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = MoneyQuickSort(petList);
  houseList = HouseMoneySort(houseList); 
  double budget = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;

  System.out.println("List of Households and Pets: ");
  for(Household house : houseList) {
   if(petList.isEmpty()) {
    break;
   }
   for(int a = 0; a<petList.size(); a++) {  
    double sat = petList.get(a).getCostOfCare();
    if(sat>=0) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
    }
   }
  if(house.pets.isEmpty()) {
   totalHappiness = totalHappiness -.05;
   double currBudget = house.getBudget();
   double budget2 = currBudget-5;       
   house.setBudget(budget2);
  }
  if(house.pets.size()==1) {
   totalHappiness = totalHappiness - .3;
  }
  if(house.pets.size()==3) {
   totalHappiness = totalHappiness - .1;
  }
  System.out.println("Household: "+house);
  budget = house.getBudget();
  totalHappiness = totalHappiness + house.happiness;
  }
  for(Pet pet : petList) {
   euthPets++;
  }
  int societyTax = euthPets*10;
  budget = budget - societyTax;
  double affluency = budget + totalHappiness - societyTax;
  System.out.println("Surplus Budget: "+budget);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+affluency);
  System.out.println("Number of euthanized pets: " + euthPets);

 }
//4
public static void maxMoneyLeftoverPenalties(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = MoneyQuickSort(petList);
  houseList = HouseMoneySort(houseList); 
  double budget = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;
  double temp = 0;

  System.out.println("List of Households and Pets: ");
  for(Household house : houseList) {
   if(petList.isEmpty()) {
    break;
   }
   for(int a = 0; a<petList.size(); a++) {  
    double sat = petList.get(a).getCostOfCare();
    if(sat<=10) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
    }
   }
  if(house.pets.isEmpty()) {
   temp = temp -.05;
   double currBudget = house.getBudget();
   double budget2 = currBudget-5;       
   house.setBudget(budget2);
  }
  if(house.pets.size()==1) {
   temp = temp - .3;
  }
  if(house.pets.size()==3) {
   temp = temp - .1;
  }
  System.out.println("Household: "+house);
  budget = house.getBudget();
  totalHappiness = totalHappiness + house.happiness;
  }
  for(Pet pet : petList) {
   euthPets++;
  }
  int societyTax = euthPets*10;
  budget = budget - societyTax;
  double affluency = budget + temp + totalHappiness - societyTax;
  System.out.println("Surplus Budget: "+budget);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+affluency);
  System.out.println("Number of euthanized pets: " + euthPets);

 }
/* maximizes leftover money (for each household in houseList). Households without pet pays 5 unit tax.
 * @param petList
 * @param houseList
 * @param budgetSurplus
 * @param totalHappiness
 * @param euthPets
 * @param affluency
 */
//3
public static void maxMoneyLeftover(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = MoneyQuickSort(petList);
  houseList = HouseMoneySort(houseList); 
  double budget = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;

  System.out.println("List of Households and Pets: ");
  for(Household house : houseList) {
   if(petList.isEmpty()) {
    break;
   }
   for(int a = 0; a<petList.size(); a++) {  
    double cost = petList.get(a).getCostOfCare();
    if(cost<=10) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
    }
   }
   if(house.pets.isEmpty()) {
    double currBudget = house.getBudget();
    budget = currBudget-5;       
    house.setBudget(budget);
   }
   if(house.pets.size()==1) {
    totalHappiness = totalHappiness - .3;
   }
   if(house.pets.size()==3) {
    totalHappiness = totalHappiness - .1;
   }
   
  System.out.println("Household: "+house);
  budget = house.getBudget();
  totalHappiness = totalHappiness + house.happiness;
  }
  for(Pet pet : petList) {
   euthPets++;
  }
  double societyPays = euthPets*10;
  double affluency = budget + totalHappiness - societyPays;
  System.out.println("Surplus Budget: "+budget);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+ affluency);
  System.out.println("Number of euthanized pets: " + euthPets);

 }
/* maximizes total household happiness (for each household in houseList). Penalties for euthanizing pets (3+ pets drops happiness .1, 1 or 2 pets drops happiness .3 or .05 units for no pets)
 * @param petList
 * @param houseList
 * @param budgetSurplus
 * @param totalHappiness
 * @param euthPets
 * @param affluency
 */

//2
public static void HappyAndPenalties(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = HappyQuickSort(petList);
  houseList = HouseMoneySort(houseList); 
  double budgetSurplus = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;

  System.out.println("List of Households and Pets: ");
  for(Household house : houseList) {
   if(petList.isEmpty()) {
    break;
   }
   for(int a = 0; a<petList.size(); a++) {  
    double sat = petList.get(a).getOwnerSatisfaction();
    if(sat>=-1) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
    }
   }
   if(house.pets.isEmpty()) {
    totalHappiness = totalHappiness -.05;
    double currBudget = house.getBudget();
    double budget = currBudget-5;       
    house.setBudget(budget);
   }
   if(house.pets.size()==1) {
    totalHappiness = totalHappiness - .3;
   }
   if(house.pets.size()==3) {
    totalHappiness = totalHappiness - .1;
   }
  System.out.println("Household: "+house);
  budgetSurplus = budgetSurplus + house.getBudget();
  totalHappiness = totalHappiness + house.happiness;
  }

  for(Pet pet : petList) {
   euthPets++;
  }
  double societyPays = euthPets*10;
  double affluency = budgetSurplus + totalHappiness - societyPays;
  System.out.println("Surplus Budget: "+budgetSurplus);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+affluency);
  System.out.println("Number of euthanized pets: " + euthPets);
 
  
 }
/* maximizes total household happiness (for each household in houseList). No penalty for euthanized pets
 * @param petList
 * @param houseList
 * @param budgetSurplus
 * @param totalHappiness
 * @param euthPets
 * @param affluency
 */

//1
 public static void maxHappy(ArrayList<Pet>petList, ArrayList<Household>houseList) throws BudgetBrokenException, DeadPetException, FedUpOwnerException, NoiseException, OwnerExhaustionException
 {   
  petList = HappyQuickSort(MoneyQuickSort(petList));
  houseList = HouseMoneySort(houseList); 
  double budgetSurplus = 0;
  double totalHappiness = 0;
  int euthPets = 0;
  int test = 0;

  System.out.println("List of Households: ");
  for(Household house : houseList) {
   if(petList.isEmpty()) {
    break;
   }
   for(int a = 0; a<petList.size(); a++) {  
    double sat = petList.get(a).getOwnerSatisfaction();
    if(sat>=0) {
     try{
      house.addPet(petList.get(a));      
      petList.remove(a);
     }
     catch(BudgetBrokenException e) {}
     catch(DeadPetException e) {}
     catch(FedUpOwnerException e) {}
     catch(NoiseException e) {}
     catch(OwnerExhaustionException e) {}
    }
   }
	//for affluency
   if(house.pets.isEmpty()) {
    totalHappiness = totalHappiness -.05;
    double currBudget = house.getBudget();
    double budget = currBudget-5;       
    house.setBudget(budget);
   }
   if(house.pets.size()==1) {
    totalHappiness = totalHappiness - .3;
   }
   if(house.pets.size()==3) {
    totalHappiness = totalHappiness - .1;
   }
  }
  for (Household housey : houseList)	{
	System.out.println("Household: "+housey);
   	budgetSurplus = budgetSurplus + housey.getBudget();
   	totalHappiness = totalHappiness + housey.happiness;
  }
  for(Pet pet : petList) {
   euthPets++;
  }
  double societyPays = euthPets*10;
  double affluency = budgetSurplus + totalHappiness - societyPays;
  System.out.println("Surplus Budget: "+budgetSurplus);
  System.out.println("Total Household Happiness: "+totalHappiness);
  System.out.println("Affluency: "+ affluency);
  System.out.println("Number of euthanized pets: " + euthPets);  
 }



//Quicksorts
//-------------------------------------------------------------------------------------------------------------------------------------//


 public static ArrayList<Pet> HappyQuickSort(ArrayList<Pet> me) {
  if (me.size()==0){
   return null;
  }
  ArrayList<Pet>top = new ArrayList<Pet>();
  ArrayList<Pet>bottom = new ArrayList<Pet>();

  Pet pivot = me.get(0);
  for(int b = 1; b< me.size(); b++) {
   if(me.get(b).getOwnerSatisfaction()>pivot.getOwnerSatisfaction()) {
    top.add(me.get(b));
   }
   else
    bottom.add(me.get(b));
  
  }
  ArrayList<Pet>answer = new ArrayList<Pet>();
  
  bottom = HappyQuickSort(bottom);

  if(bottom !=null){
   for(int c = 0; c<bottom.size(); c++) {
    answer.add(bottom.get(c));
   }
  } 
  
  answer.add(pivot);

  top = HappyQuickSort(top);
  if(top!=null) {
   for(int d = 0; d<top.size(); d++) {
    answer.add(top.get(d));
   } 
  }
  return answer;
 }

 public static ArrayList<Pet> MoneyQuickSort(ArrayList<Pet> me) {
  if (me.size()==0){
   return null;
  }
  ArrayList<Pet>top = new ArrayList<Pet>();
  ArrayList<Pet>bottom = new ArrayList<Pet>();

  Pet pivot = me.get(0);
  for(int b = 1; b< me.size(); b++) {
   if(me.get(b).getCostOfCare()>pivot.getCostOfCare()) {
    top.add(me.get(b));
   }
   else
    bottom.add(me.get(b));
  
  }
  ArrayList<Pet>answer = new ArrayList<Pet>();
  
  bottom = MoneyQuickSort(bottom);

  if(bottom !=null){
   for(int c = 0; c<bottom.size(); c++) {
    answer.add(bottom.get(c));
   }
  } 
  
  answer.add(pivot);

  top = MoneyQuickSort(top);
  if(top!=null) {
   for(int d = 0; d<top.size(); d++) {
    answer.add(top.get(d));
   }  
  }
  return answer;
 }

 public static ArrayList<Household> HouseMoneySort(ArrayList<Household> me) {
  if (me.size()==0){
   return null;
  }
  ArrayList<Household>top = new ArrayList<Household>();
  ArrayList<Household>bottom = new ArrayList<Household>();

  Household pivot = me.get(0);
  for(int b = 1; b< me.size(); b++) {
   if(me.get(b).getBudget()<pivot.getBudget()) {
    top.add(me.get(b));
   }
   else
    bottom.add(me.get(b));
  
  }
  ArrayList<Household>answer = new ArrayList<Household>();
  
  bottom = HouseMoneySort(bottom);

  if(bottom !=null){
   for(int c = 0; c<bottom.size(); c++) {
    answer.add(bottom.get(c));
   }
  } 
  
  answer.add(pivot);

  top = HouseMoneySort(top);
  if(top!=null) {
   for(int d = 0; d<top.size(); d++) {
    answer.add(top.get(d));
   }  
  }
  return answer;
 }

}















