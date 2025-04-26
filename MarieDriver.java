import java.util.Scanner;

public class MarieDriver {
    public static void main(String[] args) {

        //Creates a MarieOperations object to use the methods
        MarieOperations marie = new MarieOperations();
        Scanner sc = new Scanner(System.in);

        int[] addition = {
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001000001010, // Opcode 2 Value 10 -> store 10
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001100001010, // Opcode 3 Value 20 -> add 10
            0b011000000000, // Opcode 6 Value 20 -> output()
            0b111100000000  // -> halt
        };

        //Debug why the subtraction is returing a negative number instead of a positive number
        //Works when inputting the smaller number first then the larger number,
        //but not the other way around
        int[] subtraction = {
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001000001010, // Opcode 2 Value 10 -> store 10
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b010000001010, // Opcode 4 Value 20 -> subtract 10
            0b011000000000, // Opcode 6 Value 20 -> output()
            0b111100000000  // -> halt
        };

        int[] multiply = {
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001000001010, // Opcode 2 Value 10 -> store 10
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b011100001010, // Opcode 4 Value 20 -> multiply 10
            0b011000000000, // Opcode 6 Value 20 -> output()
            0b111100000000  // -> halt
        };

        int[] divide = {
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001000001010, // Opcode 2 Value 10 -> store 10
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b100000001010, // Opcode 4 Value 20 -> multiply 10
            0b011000000000, // Opcode 6 Value 20 -> output()
            0b111100000000, // -> halt
        };

        int input = -1;
        while(true){
            System.out.println("Welcome to the MARIE simulator!");
            System.out.println("Please select an option:");
            System.out.println("0. Load a program");
            System.out.println("1. Add two numbers");
            System.out.println("2. Subtract two numbers");
            System.out.println("3. Multiply two numbers");
            System.out.println("4. Divide two numbers");
            System.out.println("5. Exit");
            System.out.println("");
            if(input == 0){
                    
            }else if(input == 1){
                marie.loadProgram(addition);
            }else if(input == 2){
                marie.loadProgram(subtraction);
            }else if(input == 3){
                marie.loadProgram(multiply);
            }else if(input == 4){
                marie.loadProgram(divide);
            }else{
                break;
            }
        }
        //Run the program in the memory
        marie.runProgram();
    }
}
