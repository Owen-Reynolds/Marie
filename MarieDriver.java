import java.util.*;

public class MarieDriver {
    public static void main(String[] args) {

        //Creates scanner object to get user input
        Scanner sc = new Scanner(System.in);

        //Creates a MarieOperations object to use the methods
        MarieOperations marie = new MarieOperations();
        marie.input(5);
        marie.store(0);
        marie.input(10);
        marie.store(1);
        marie.load(0);
        marie.add(1);
        marie.output();
    }
}
