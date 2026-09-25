import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class CampusNavigator {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        String currentLocation = scnr.nextLine();
        String classLocation = scnr.nextLine();
        double walkingSpeed = scnr.nextDouble();
        String currentTime = scnr.nextLine();
        String classTime = scnr.nextLine();
        int routePreference = scnr.nextInt();
        double distance = scnr.nextDouble();
        double travelTime = (distance / walkingSpeed) / 60.0;

        System.out.println("Current location: " + currentLocation);
        System.out.println("Class location: " + classLocation);
        System.out.println("Walking speed (m/s): " + walkingSpeed);
        System.out.println("Current Time: " + currentTime);
        System.out.println("Class Time: " + classTime);
        System.out.println("Route preference: ");
        System.out.println("1. Shortest Path");
        System.out.println("2. Scenic Path");
        System.out.println("3. Accessible Path");
        System.out.println("Choose Route (1-3)");

        switch (routePreference) {
            case 1:
                routePreference = "Shortest Path";
                break; 
            
            case 2:
                routePreference = "Scenic Path";
                break;
            
            case 3:
                routePreference = "Accessible Path";
                break;  
                
            default:
                System.out.println("No User Input. Defaulting to Shortest Route.");
                break;    

        System.out.println("Current Time: "+ currentTime);
        System.out.println("Travel time (minutes): " + travelTime);
        System.out.println("Class Time: " + classTime);

        if ((currentTime + travelTime) <= classTime) {
            System.out.println("You will arrive on time.");
        } else {
            System.out.println("You will be late.");
        }
        }
scnr.close(); 
    }
}