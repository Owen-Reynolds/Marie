public class MarieDriver {
    public static void main(String[] args) {

        //Creates a MarieOperations object to use the methods
        MarieOperations marie = new MarieOperations();
        
        //Sample program loading a program
        int[] program = {
            0b010100000000, // 5 0  -> input()
            0b001000001010, // 2 10 -> store 10
            0b010100000000, // 5 0  -> input()
            0b001100001010, // 3 10 -> add 10
            0b011000000000, // 6 0  -> output()
            0b111100000000  // F 0  -> halt
        };

        marie.loadProgram(program);
        marie.runProgram();
    }
}
