/*
Campus Navigator helps GMU students see how long it'll take to walk 
between campus buildings and whether they'll arrive on time for class.

The program uses the student's location, destination, walking speed, 
current time, class time, and route preference to get the ETA.
*/


import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class CampusNavigator {
    public static void main(String[] args) {

        // Gets all the information needed from the student
        String currentChoice = JOptionPane.showInputDialog("Choose your current location:\n" + 
        "1. Innovation Hall\n"+
        "2. Nguyen Engineering Building\n"+
        "3. Horizon Hall");

        while (!currentChoice.equals("1") && !currentChoice.equals("2") && !currentChoice.equals("3")) {
            currentChoice = JOptionPane.showInputDialog(
                "Invalid choice. Please enter 1, 2, or 3.\n\n" + 
                "1. Innovation Hall\n"+
                "2. Nguyen Engineering Building\n"+
                "3. Horizon Hall");
        }

        /*String classLocation = JOptionPane.showInputDialog("Enter the class location:");
        double walkingSpeed = Double.parseDouble(JOptionPane.showInputDialog("Enter your walking speed (m/s):"));
        String currentTime = JOptionPane.showInputDialog("Enter the current time (HH:mm):");
        String classTime = JOptionPane.showInputDialog("Enter the class time (HH:mm):");
        String routePreference = JOptionPane.showInputDialog("Choose your route preference:\n1. Shortest Path\n2. Scenic Path\n3. Accessible Path");
        double distance = Double.parseDouble(JOptionPane.showInputDialog("Enter the distance (m):")); */
        // Calculates how long the walk should take in minutes

        String destinationChoice = JOptionPane.showInputDialog(
        "choose your class location:\n" + 
        "1. Innovation Hall\n"+
        "2. Nguyen Engineering Building\n"+
        "3. Horizon Hall");

        while (!destinationChoice.equals("1") && !destinationChoice.equals("2") && !destinationChoice.equals("3")) {
            destinationChoice = JOptionPane.showInputDialog(
                "Invalid choice. Please enter 1, 2, or 3.\n\n" + 
                "1. Innovation Hall\n"+
                "2. Nguyen Engineering Building\n"+
                "3. Horizon Hall");
        }

        String currentLocation;

        switch (currentChoice) {
            case "1":
                currentLocation = "Innovation Hall";
                break;
            case "2":
                currentLocation = "Nguyen Engineering Building";
                break;

            case "3":
                currentLocation = "Horizon Hall";
                break;
            default:
                currentLocation = "Innovation Hall";
                break;
        }

        String classLocation;

        switch (destinationChoice) {
            case "1":
                classLocation = "Innovation Hall";
                break;
            case "2":
                classLocation = "Nguyen Engineering Building";
                break;

            case "3":
                classLocation = "Horizon Hall";
                break;
            default:
                classLocation = "Innovation Hall";
                break;
        }

        double distance;

        if (currentLocation.equals(classLocation)) {
            distance = 0;
        }

        else if ((currentLocation.equals("Innovation Hall") && 
                classLocation.equals("Nguyen Engineering Building")) ||
                (currentLocation.equals("Nguyen Engineering Building") && 
                classLocation.equals("Innovation Hall"))) {
            distance = 483;
        } else if ((currentLocation.equals("Innovation Hall") && 
                classLocation.equals("Horizon Hall")) ||
                (currentLocation.equals("Horizon Hall") && 
                classLocation.equals("Innovation Hall"))) {
            distance = 322;
        } else {
            distance = 644; 
        }




        double walkingSpeed= Double.parseDouble(JOptionPane.showInputDialog("Enter your walking speed (m/s):"));

        while (walkingSpeed <= 0) {
            walkingSpeed = Double.parseDouble(JOptionPane.showInputDialog("Invalid walking speed. Please enter a positive number (m/s):"));
        }
        
        String currentTime = JOptionPane.showInputDialog("Enter the current time (HH:mm):");

        String classTime = JOptionPane.showInputDialog("Enter the class time (HH:mm):");

        String routePreference = JOptionPane.showInputDialog("Choose your route preference:\n"+
            "1. Shortest path\n"+
            "2. Scenic path\n"+
            "3. Accessible path");

        while (!routePreference.equals("1") && !routePreference.equals("2") && !routePreference.equals("3")) {
            routePreference = JOptionPane.showInputDialog(
                "Invalid choice. Please enter 1, 2, or 3.\n\n" + 
                "1. Shortest path\n"+
                "2. Scenic path\n"+
                "3. Accessible path");
        }

        double travelTime = (distance / walkingSpeed) / 60.0;


        // Uses the student's choice to decide which route they want
        switch (routePreference) {
            case "1":
                routePreference = "Shortest Path";
                break; 
            
            case "2":
                routePreference = "Scenic Path";
                break;
            
            case "3":
                routePreference = "Accessible Path";
                break;  
                
            default:
                routePreference = "Shortest Path";
                break;    
    }

        // Calculates the student's estimated arrival time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTimeValue = LocalTime.parse(currentTime, formatter);
        LocalTime classTimeValue = LocalTime.parse(classTime, formatter);
        long travelMinutes = (long) Math.ceil(travelTime);
        LocalTime arrivalTime = currentTimeValue.plusMinutes(travelMinutes);

        String result;

        // Compares the arrival time to the class time to see if the student will be late
        if (!arrivalTime.isAfter(classTimeValue)) {
            result = "You will arrive on time.";
        } else {
            result = "You will be late.";
        }

        // Displays the final route and travel information to the student
        JOptionPane.showMessageDialog(null, 
            "Current Location: " + currentLocation +
            "\nClass Location: " + classLocation +
            "\nRoute Preference: " + routePreference +
            "\nDistance: " + distance + " m" +
            "\nTravel Time: " + String.format("%.2f", travelTime) + " minutes" +
            "\nCurrent Time : " + currentTime +
            "\nArrival Time: " + arrivalTime + 
            "\nClass Time: " + classTime +
            "\n\n" + result,
            "Campus Navigator",
            JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
        }
}
