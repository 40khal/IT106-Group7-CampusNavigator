import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class CampusNavigator {
    public static void main(String[] args) {

        String currentLocation = JOptionPane.showInputDialog("Enter your current location:");
        String classLocation = JOptionPane.showInputDialog("Enter the class location:");
        double walkingSpeed = Double.parseDouble(JOptionPane.showInputDialog("Enter your walking speed (m/s):"));
        String currentTime = JOptionPane.showInputDialog("Enter the current time (HH:mm):");
        String classTime = JOptionPane.showInputDialog("Enter the class time (HH:mm):");
        String routePreference = JOptionPane.showInputDialog("Choose your route preference:\n1. Shortest Path\n2. Scenic Path\n3. Accessible Path");
        double distance = Double.parseDouble(JOptionPane.showInputDialog("Enter the distance (m):"));
        double travelTime = (distance / walkingSpeed) / 60.0;


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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTimeValue = LocalTime.parse(currentTime, formatter);
        LocalTime classTimeValue = LocalTime.parse(classTime, formatter);
        long travelMinutes = (long) Math.ceil(travelTime);
        LocalTime arrivalTime = currentTimeValue.plusMinutes(travelMinutes);

        String result;

        if (!arrivalTime.isAfter(classTimeValue)) {
            result = "You will arive on time.";
        } else {
            result = "You will be late.";
        }

        JOptionPane.showMessageDialog(null, 
            "Current Location: " + currentLocation +
            "\nClass Location: " + classLocation +
            "\nRoute Preference: " + routePreference +
            "\nDistance: " + distance + " m" +
            "\nTravel Time: " + String.format("%.2f", travelTime) + "minutes" +
            "\nCurrent Time : " + currentTime +
            "\nArrival Time: " + arrivalTime + 
            "\nClass Time: " + classTime +
            "\n\n" + result,
            "Campus Navigator",
            JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
        }
}