package MILLER; //  Java source package

import java.io.BufferedReader; //  Import package

import java.io.FileReader;  //  Import package

import java.io.IOException;  //  Import package

import java.util.Scanner;  //  Import package

import javax.swing.JOptionPane;  //  Import package


public class ZOOMONITORING {  //  This declares the class

    
     public static void main(String[] args) throws IOException {  //  This begins the main method of the program
  
        BufferedReader djAnimals = new BufferedReader(new FileReader("/Users/dad/Desktop/MONITORING ZOO/src/MILLER/ANIMALS.txt")); //  Reads in the animals

        BufferedReader djHabitats = new BufferedReader(new FileReader("/Users/dad/Desktop/MONITORING ZOO/src/MILLER/HABITATS.txt")); //  Reads in the habitats
        
        Scanner scnr = new Scanner(System.in);  //  Creating a simple scanner to read the input from the zookeepers
        
        int userChoice = 0;  //  Since they will be choosing between three options, I initialize the userChoice to 0 to begin with

        while(userChoice != 3)  //  Begins the main while loop as long as the zookeeper does not select 3

        {

              djAnimals = new BufferedReader(new FileReader ("/Users/dad/Desktop/MONITORING ZOO/src/MILLER/ANIMALS.txt"));  //  Reads the animals file

              djHabitats = new BufferedReader(new FileReader("/Users/dad/Desktop/MONITORING ZOO/src/MILLER/HABITATS.txt"));  //  Reads the habitats file

              System.out.println("\n" + "____________________________________________");  //  Formatting line
              
              System.out.println(); //  Blank line

              System.out.println("WELCOME TO DJ'S ZOO MONITORING SYSTEM!!!"); //  Welcome statement

              System.out.println(); //  Blank line

              System.out.println("Please select from one of the options below:"); //  Asking zookeeper to make his/her selection
              
              System.out.println(); //  Blank line

              System.out.println("____________________________________________"); //  Formatting line

              System.out.println(); //  Blank line

              System.out.println("  Select 1 to see all animals"); //  First choice is animals

              System.out.println(); //  Blank line

              System.out.println("  Select 2 to see all habitats"); //  Second choice is habitats

              System.out.println(); //  Blank line

              System.out.println("  Select 3 to exit the system"); //  Third choice is to exit the system

              System.out.println(); //  Blank line

              System.out.print("  Please make a selection: "); //  Selection line

              userChoice = scnr.nextInt(); //  Reads the zookeepers input

              System.out.println("____________________________________________"); //  Formatting line

              System.out.println(); //  Blank line

              String[] zooInformation = null; //  This will store the animal and habitat information in a string

            switch (userChoice) { //  Begins the switch statement

                case 1: //  Starts case 1, which is the animals

                    {

                        String currentRow; //  variable to identify the current Row

                        System.out.println("Please select from one of the animals below:"); //  Asks the zookeeper to select from one of the animals

                        System.out.println("____________________________________________"); //  Formatting line

                        System.out.println(); //  Blank line

                        int animalSelection = 0; //  Integer variable to assign the animal selected
                        int blankRows = 0; //  Integer variable to assign blank rows in the text document
                        int section=0; //  This integer variable assigns different sections within the text document
                        int animalIndex = -1; //  This integer variable index the array to get the proper animal that was selected
                        int animalIndicators = 0; //  Will look to see if there are any indicators

                        while((currentRow = djAnimals.readLine())!=null) //  This begins the nested while loop to go through the file and read it

                        {                     

                            section = 0; //  Assigns section

                            if(currentRow.equals("")) //  IF statement looking for blank rows

                            {

                                blankRows ++; //  This will increment the blank rows 
                                
                                if(blankRows == 1) //  Nested if statement looking to see if there are blank rows in line 1

                                {

                                    zooInformation = new String[animalSelection]; //  This will index the array for the entire file

                                }

                                animalIndicators = 1; //  Assigns animal indicators to 1

                                section = 1; //  Assigns the entire section the value of 1

                                animalIndex ++; //  This will increment the indes of the animals
                                
                            }
                                
                            if(blankRows == 0) //  If statement that runs based on no blank rows

                            {

                                animalSelection ++; //  Increments the animals

                                System.out.print("Select " + animalSelection + " for " + currentRow + "\n"); //  Print statement that asks the zookeeper to select a number based on the animal row and inserts a blank line between each

                                System.out.println(); //  Blank line

                            }

                            else if(blankRows != 0 && section == 0) //  Else if statement to check to make sure there are no blank rows and its the only section

                            {

                                if(animalIndicators == 1) //  Nested if statement to see if the indicators is in the first row

                                {

                                    zooInformation[animalIndex] = currentRow; //  Indexes the current animal and sets it to current row

                                    animalIndicators = 0; //  Sets the indicator variable to 0

                                }

                                else //  The else portion of the original if statement

                                {

                                    zooInformation[animalIndex] = zooInformation[animalIndex] + "\n" + currentRow; //  This adds the current row to the index

                                }

                            }

                        }

                        djAnimals.close(); //  Closes the animal file

                        int animalChoice = scnr.nextInt(); //  Reads in the zookeepers choice

                        System.out.println("\n" + zooInformation[animalChoice-1]); //  Adds a blank line and prints out the details on the selected animal

                        if(zooInformation[animalChoice-1].contains("*")) //  If statement to check to see if any of the details has an asterisk

                        {

                            JOptionPane.showMessageDialog(null, "THERE IS AN ISSUE WITH THIS ANIMAL"); //  An alert box will be displayed with the "THERE IS AN ISSUE WITH THIS ANIMAL" message for the zookeeper without the asterisk

                        }    break; //  Exits the loop

                    }

                case 2: //  This begins the second case which is the habitats.  It is identical to the animal lines in case one, except it references the habitats file
                    {

                        String currentRow; //  variable to identify the current Row

                        System.out.println("Please select from one of the habitats below:"); //  Asks the zookeeper to select from one of the habitats

                        System.out.println("____________________________________________"); //  Formatting line

                        System.out.println(); //  Blank line

                        int habitatSelection = 0; //  Integer variable to assign the habitat selected
                        int blankRows = 0; //  Integer variable to assign blank rows in the text document
                        int section=0; //  This integer variable assigns different sections within the text document
                        int habitatIndex = -1; //  This integer variable indexes the array to get the proper habitat that was selected
                        int habitatIndicators = 0; //  Will look to see if there are any indicators

                        while((currentRow = djHabitats.readLine())!=null) //  This begins the nested while loop to go through the file and read it

                        {

                            section = 0; //  Assigns section

                            if(currentRow.equals("")) //  IF statement looking for blank rows

                            {

                                blankRows ++; //  This will increment the blank rows 

                                if(blankRows == 1) //  Nested if statement looking to see if there are blank rows in line 1

                                {

                                    zooInformation = new String[habitatSelection]; //  This will index the array for the entire file

                                }

                                habitatIndicators = 1; //  Assigns habitat indicators to 1

                                section=1; //  Assigns the entire section the value of 1

                                habitatIndex ++; //  This will increment the indes of the habitats

                            }

                            if(blankRows == 0) //  If statement that runs based on no blank rows

                            {

                                habitatSelection ++; //  Increments the animals

                                System.out.print("Select " + habitatSelection + " for " + currentRow + "\n"); //  Print statement that asks the zookeeper to select a number based on the habitat row and inserts a blank line between each

                                System.out.println(); //  Blank line

                            }

                            else if(blankRows != 0 && section == 0) //  Else if statement to check to make sure there are no blank rows and its the only section

                            {

                                if(habitatIndicators == 1) //  Nested if statement to see if the indicators is in the first row


                                {

                                    zooInformation[habitatIndex] = currentRow; //  Indexes the current habitat and sets it to current row

                                    habitatIndicators = 0; //  Sets the indicator variable to 0

                                }

                                else //  The else portion of the original if statement

                                {
                                    zooInformation[habitatIndex] = zooInformation[habitatIndex]+ "\n" + currentRow; //  This adds the current row to the index

                                }

                            }

                        }    

                        djHabitats.close(); //  Closes the habitats file

                        int habitatChoice = scnr.nextInt(); //  Reads in the zookeepers choice

                        System.out.println("\n" + zooInformation[habitatChoice-1]);  //  Adds a blank line and prints out the details on the selected habitat

                        if(zooInformation[habitatChoice-1].contains("*")) //  If statement to check to see if any of the details has an asterisk

                        {

                            JOptionPane.showMessageDialog(null, "THERE IS SOMETHING WRONG WITH THIS HABITAT"); //  An alert box will be displayed with the "THERE IS AN ISSUE WITH THIS HABITAT" message for the zookeeper without the asterisk

                        }    break; //  Exits the loop

                    }

                case 3: //  This is the final case which is the system exit.  If this option is chosen the build completes and the program is done.

                    System.out.println("Have a great day!!!"); //  This is print statement
                    
                    System.out.println();
                    

                    break; //  Exits the loop

                default: //  This is the default case, wherein if a numeric option is selected by the zookeeper that is not 1, 2, or 3, the default message will appear

                    System.out.print("This is not a valid selection, please choose again"); //  This is the default message for an invalid choice

                    break; //  Exits the loop

                }

            }
        
        scnr.close();

        }

    }
