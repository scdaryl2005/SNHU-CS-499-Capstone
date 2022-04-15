// Daryl Miller
// CS-499-T4546
// March 17, 2022

/* This application is designed to monitor 
 * animals, habitats, and staff within a zoo.
 * This zoo is modeled after the current animals
 * and habitats at the San Antonio Zoo.
 * The staff members are made up with members of
 * the 2022 New York Yankees
 */

package ENHANCEMENT_1; //  Java source package

import java.io.BufferedReader; //  Import package

import java.io.FileReader;  //  Import package

import java.io.IOException;  //  Import package

import java.util.Scanner;  //  Import package

import javax.swing.JOptionPane;  //  Import package


public class DJZOO {  //  This declares the class

    
    public static void main(String[] args) throws IOException {
    	
    	/* Buffer Reader to read in the three .txt files and scanner to read user inputs */
  
        BufferedReader djAnimals = new BufferedReader(new FileReader("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/ANIMALS.txt"));

        BufferedReader djHabitats = new BufferedReader(new FileReader("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/HABITATS.txt"));
        
        BufferedReader djStaff = new BufferedReader(new FileReader("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/STAFF.txt"));

        Scanner scnr = new Scanner(System.in);
        
        int userChoice = 0;  //  Initialize the userChoice to 0 as the user will be choosing an option between 1 and 4
        
        /* This begins the while loop to iterate through the different files
         * this will bloc will also set up the main menu presented to the user
         */

        while(userChoice != 4)

        {

              djAnimals = new BufferedReader(new FileReader ("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/ANIMALS.txt"));  //  Reads the animals file

              djHabitats = new BufferedReader(new FileReader("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/HABITATS.txt"));  //  Reads the habitats file
              
              djStaff = new BufferedReader(new FileReader("/Users/dad/Desktop/ENHANCEMENT_1/src/ENHANCEMENT_1/STAFF.txt")); //  Reads in the staff file
              
              /* Main Menu Design
               * User Input
               * Store information as a string
               */
             
              System.out.println("WELCOME TO DJ'S SAN ANTONIO ZOO MONITORING SYSTEM!!!" + "\n");

              System.out.println("Please select from one of the options below:" + "\n" + "____________________________________________" + "\n");
              
              System.out.println("  Select 1 to see all animals" + "\n");

              System.out.println("  Select 2 to see all habitats" + "\n");
              
              System.out.println("  Select 3 to see all staff" + "\n");

              System.out.println("  Select 4 to exit the system" + "\n");

              System.out.print("  Please make a selection: ");

              userChoice = scnr.nextInt(); //  Reads the user's input

              String[] zooInformation = null; //  This will store the animal, habitat, and staff information in a string
              
              /* Begin the switch statement 
               * There are four cases based on the selections available to the user
               * Each case will display a message box to the user
               * Each case will end with a "break" to exit the loop
               */

              switch (userChoice) {

                case 1: //  Case 1 is all about the animals within the zoo

                    {

                        String currentRow; //  variable to identify the current Row

                        System.out.println("\n" + "____________________________________________" + "\n" + "Please select from one of the animals below:" + "\n" + "____________________________________________" + "\n");

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

                                animalIndex ++; //  This will increment the indexes of the animals
                                
                            }
                                
                            if(blankRows == 0) //  If statement that runs based on no blank rows

                            {

                                animalSelection ++; //  Increments the animals

                                System.out.print("Select " + animalSelection + " for " + currentRow + "\n" + "\n"); //  Print statement that asks the user to select a number based on the animal row and inserts a blank line between each

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
                        
                        System.out.print("Please make a selection: "); //  Asks the user to make a choice

                        int animalChoice = scnr.nextInt(); //  Reads in the user's choice

                        System.out.println("\n" + zooInformation[animalChoice-1] + "\n"); //  Adds a blank line and prints out the details on the selected animal
                        
                        /* If-ElseIF statement to either display a waring message to the keeper if there is something wrong with the animal
                         * or display the same message without the warning string "THERE IS AN ISSUE WITH THIS ANIMAL"
                         */

                        if(zooInformation[animalChoice-1].contains("*"))

                        {

                            JOptionPane.showMessageDialog(null, "THERE IS AN ISSUE WITH THIS ANIMAL" + "\n" + zooInformation[animalChoice-1]); //  With "*" in the animal.txt file

                        }    
                        
                        else if(!zooInformation[animalChoice-1].contains("*"))

                        {

                            JOptionPane.showMessageDialog(null, zooInformation[animalChoice-1]); //  Without "*" in the animal.txt file

                        }  
                        
                        break; //  Exits the loop

                    }

                case 2: //  Case 2 is about the habitats within the zoo
                    {

                        String currentRow; //  variable to identify the current Row

                        System.out.println("Please select from one of the habitats below: " + "\n" + "____________________________________________" + "\n"); //  Asks the user to select from one of the habitats

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

                                habitatIndex ++; //  This will increment the index of the habitats

                            }

                            if(blankRows == 0) //  If statement that runs based on no blank rows

                            {

                                habitatSelection ++; //  Increments the animals

                                System.out.print("Select " + habitatSelection + " for " + currentRow + "\n" + "\n"); //  Print statement that asks the user to select a number based on the habitat row and inserts a blank line between each

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
                        
                        System.out.print("Please make a selection: "); //  Asks the user to make a choice

                        int habitatChoice = scnr.nextInt(); //  Reads in the user's choice

                        System.out.println("\n" + zooInformation[habitatChoice-1] + "\n");  //  Adds a blank line and prints out the details on the selected habitat
                        
                        /* If-ElseIF statement to either display a waring message to the user if there is something wrong with the habitat
                         * or display the same message without the warning string "THERE IS AN ISSUE WITH THIS HABITAT"
                         */

                        if(zooInformation[habitatChoice-1].contains("*"))

                        {

                            JOptionPane.showMessageDialog(null, "THERE IS SOMETHING WRONG WITH THIS HABITAT" + "\n" + zooInformation[habitatChoice-1]); //  With "*" in the habitat.txt file

                        }    
                        
                        else if(!zooInformation[habitatChoice-1].contains("*"))

                        {

                            JOptionPane.showMessageDialog(null, zooInformation[habitatChoice-1]); //  Without "*" in the habitat.txt file

                        }  
                        
                        break; //  Exits the loop

                    }

                case 3: //  Case 3 deals with the staff within the zoo
                {

                    String currentRow; //  variable to identify the current Row

                    System.out.println("Please select from one of the Staff below:" + "\n" + "____________________________________________" + "\n"); //  Asks the user to select from one of the staff

                    int staffSelection = 0; //  Integer variable to assign the habitat selected
                    int blankRows = 0; //  Integer variable to assign blank rows in the text document
                    int section=0; //  This integer variable assigns different sections within the text document
                    int staffIndex = -1; //  This integer variable indexes the array to get the proper habitat that was selected
                    int staffIndicators = 0; //  Will look to see if there are any indicators

                    while((currentRow = djStaff.readLine())!=null) //  This begins the nested while loop to go through the file and read it

                    {

                        section = 0; //  Assigns section

                        if(currentRow.equals("")) //  IF statement looking for blank rows

                        {

                            blankRows ++; //  This will increment the blank rows 

                            if(blankRows == 1) //  Nested if statement looking to see if there are blank rows in line 1

                            {

                                zooInformation = new String[staffSelection]; //  This will index the array for the entire file

                            }

                            staffIndicators = 1; //  Assigns staff indicators to 1

                            section=1; //  Assigns the entire section the value of 1

                            staffIndex ++; //  This will increment the index of the staff

                        }

                        if(blankRows == 0) //  If statement that runs based on no blank rows

                        {

                        	staffSelection ++; //  Increments the staff

                            System.out.print("Select " + staffSelection + " for " + currentRow + "\n" + "\n");
                            

                        }

                        else if(blankRows != 0 && section == 0) //  Else if statement to check to make sure there are no blank rows and its the only section

                        {

                            if(staffIndicators == 1) //  Nested if statement to see if the indicators is in the first row


                            {

                                zooInformation[staffIndex] = currentRow; //  Index the current staff members and sets it to current row

                                staffIndicators = 0; //  Sets the indicator variable to 0

                            }

                            else

                            {
                                zooInformation[staffIndex] = zooInformation[staffIndex]+ "\n" + currentRow; //  This adds the current row to the index

                            }

                        }

                    } 
                    
                    
                    djStaff.close(); //  Closes the staff file
                    
                    System.out.print("Please make a selection: "); //  Asks the user to make a choice

                    int staffChoice = scnr.nextInt(); //  Reads in the user's choice

                    System.out.println("\n" + zooInformation[staffChoice-1] + "\n");
                    
                    /* If statement to see if the staff.txt file contains an "*"
                     * if not, which there is not any, will display the normal message
                     * with the staff's details
                     */
                    
                    if(!zooInformation[staffChoice-1].contains("*")) //  If statement to check to see if any of the details has an asterisk

                    {

                        JOptionPane.showMessageDialog(null, zooInformation[staffChoice-1]); //  With no "*" present in the file, this will produce the information about the selected staff member

                    }  

                    break; //  Exits the loop

                }
                    
                case 4: //  Case 4 is the exit case and if selected, will close the program and scanner

                    System.out.println("Have a great day!!!" + "\n");
                                      
                    break; //  Exits the loop

                default: //  This is the default case, wherein if a numeric option is selected by the user that is not 1, 2, 3, or 4, the default message will appear

                    System.out.print("This is not a valid selection, please choose again" + "\n" + "____________________________________________" +"\n"); //  This is the default message for an invalid choice
                    
                    break; //  Exits the loop

                }

            }
        
        scnr.close();

        }

    }