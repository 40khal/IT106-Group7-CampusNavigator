import java.util.Scanner;

public class CampusNavigator {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        int currentLocation = scnr.nextInt();
        int classLocation = scnr.nextInt();
        int walkingSpeed = scnr.nextInt();
        int classTime = scnr.nextInt();
        int routePreference = scnr.nextInt();

        System.out.println("Current location: " + currentLocation);
        System.out.println("Class location: " + classLocation);
        System.out.println("Walking speed: " + walkingSpeed);
        System.out.println("Class Time: " + classTime);
        System.out.println("Route preference: " + routePreference);


scnr.close(); 
    }
}