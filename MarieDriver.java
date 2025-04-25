public class MarieDriver {
    public static void main(String[] args) {

        //Creates a MarieOperations object to use the methods
        MarieOperations marie = new MarieOperations();
        
        //Sample program loading a program
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
        // but not the other way around
        int[] subtraction = {
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b001000001010, // Opcode 2 Value 10 -> store 10
            0b010100000000, // Opcode 5 Value 10 -> input()
            0b010000001010, // Opcode 4 Value 20 -> subtract 10
            0b011000000000, // Opcode 6 Value 20 -> output()
            0b111100000000  // -> halt
        };

        //Loading the program into memory
        marie.loadProgram(subtraction);
        //Run the program in the memory
        marie.runProgram();
    }
}
