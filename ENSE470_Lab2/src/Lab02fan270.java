/**
 * Main class file.
 * User interface for building vehicle.
 * @author Jinkai Fan (200377610)
 */
import java.util.Scanner;

public class Lab02fan270 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean res = false;
        int choice = 0;
        Car car = new Car();
        boolean isAdded[] = new boolean[Decorator.NUM_DECORATORS];

            do
            {
                    System.out.println("Enter an option to build your new 2019 GLS450 4MATIC SUV:\n" +
                    "Base price MSRP is $88,100.00 \n" +
                    " 1 -> Add Customized Exterior Color\n" +
                    " 2 -> Add Sport Package\n" +
                    " 3 -> Add Night Package\n" +
                    " 4 -> Add Interior Sport Package\n" +
                    " 5 -> Add Engine Block Heater\n" +
                    " 6 -> Complete Order\n");

             do
             {
                System.out.print("You have selected: ");
    
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 6)
                        res = true;
                    else
                        System.out.println("Invalid");
                    sc.nextLine();
  
                
             }
                while(!res);
                    
                 if(choice==6)
                     break;
                 
                 if(isAdded[choice-1])
                 {
                     System.out.println("Invalid! Option has been added!");
                     continue;
                 }
                 
                 switch(choice)
                 {
                     case 1:
                         car = new colorPkg(car);
                         break;
                     case 2:
                         car = new sportPkg(car);
                         break;
                     case 3:
                         car = new nightPkg(car);
                         break;
                     case 4:
                         car = new inSportPkg(car);
                         break;
                     case 5:
                         car = new blockHeater(car);
                         break;
                     case 6:
                         defalut:
                            break;
                 }
                 
                 isAdded[choice-1]=true;
                 
            }while(choice!=6);
                    
            System.out.println("Build completed.");

            System.out.println("Total price: " + "$"+ car.getPrice());
           
    }    

        

}
