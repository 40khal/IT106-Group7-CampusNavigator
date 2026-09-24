import java.util.Scanner;

public class CampusNavigator {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        String currentLocation = scnr.nextLine();
        String classLocation = scnr.nextLine();
        double walkingSpeed = scnr.nextDouble();
        String classTime = scnr.nextLine();
        int routePreference = scnr.nextInt();

        System.out.println("Current location: " + currentLocation);
        System.out.println("Class location: " + classLocation);
        System.out.println("Walking speed (m/s): " + walkingSpeed);
        System.out.println("Class Time: " + classTime);
        System.out.println("Route preference: ");
        System.out.println("1. Shortest Path");
        System.out.println("2. Scenic Path");
        System.out.println("3. Accessible Path");
        System.out.print("Choose Route (1-3)");

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
                System.out.println("Invalid choice. Defaulting to Shortest Route.");
                break;    
                
        }
scnr.close(); 
    }
}