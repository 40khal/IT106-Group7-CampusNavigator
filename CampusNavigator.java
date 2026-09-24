import java.util.Scanner;

public class CampusNavigator {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        int currentLocation = scnr.nextInt();
        int classLocation = scnr.nextInt();
        int walkingSpeed = scnr.nextInt();
        int classTime = scnr.nextInt();
        int routePreference = scnr.nextInt();

scnr.close(); 
    }
}