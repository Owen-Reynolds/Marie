import java.util.Scanner;
import java.util.ArrayList;
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
            0b100000001010, // Opcode 8 Value 20 -> divide 10
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
            input = sc.nextInt();

            if(input == 0){
                int assemblyInput = 0;
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(assemblyInput != -1){
                    System.out.println("Enter the assembly instruction(-1 to stop): ");
                    assemblyInput = sc.nextInt();
                    if(assemblyInput != -1){
                        list.add(assemblyInput);
                    }else if(assemblyInput == -1){
                        //Convert ArrayList to Array
                        int[] convert = list.stream().mapToInt(Integer::intValue).toArray();
                        marie.loadProgram(convert);
                        marie.runProgram();
                        break;
                    }    
                    else{
                        System.out.println("Invalid Instruction Try Again");
                    }
                    
                }    
            }
            else if(input == 1){
                marie.loadProgram(addition);
                marie.runProgram();
            }
            else if(input == 2){
                marie.loadProgram(subtraction);
                marie.runProgram();
            }
            else if(input == 3){
                marie.loadProgram(multiply);
                marie.runProgram();
            }
            else if(input == 4){
                marie.loadProgram(divide);
                marie.runProgram();
            }
            else{
                break;
            }
        }
    }
}
