import java.util.ArrayList;

public class MarieOperations {
    int[] memory = new int[4096];
    int AC = 0;
    int PC = 0;
    int MQ = 0;
    int IR = 0;
    int MAR = 0;
    int MDR = 0;

    //Loads the value in the address in MAR to the AC
    public void load(int address){
        MAR = address;
        MDR = memory[MAR];
        AC = MDR;
        System.out.println("Load:" + AC);
    }

    //Stores the value in the AC to the address in MAR
    public void store(int address){
        MAR = address;
        memory[MAR] = AC;
        System.out.println("Store :" + AC );
    }

    //Adds the value in the address in MAR to the AC
    public void add(int address){
        MAR = address;
        MDR = memory[MAR];
        AC += MDR;
        System.out.println("Add : " + AC);
    }

    //Subtracts the value in the address in MAR from the AC
    public void subtract(int address){
        MAR = address;
        MDR = memory[MAR];
        AC -= MDR;
        System.out.println("Subtract : " + AC);
    }

    //Takes user input and stores in the AC
    public void input(int value){
        AC = value;
        System.out.println("Input : " + AC);
    }

    //Outputs the value in the AC to the console
    public void output(){
        System.out.println("Output : " + AC);
    }

    //Fetches the instruction from the memory and returns it
    public int fetch(){
        MAR = PC;
        IR = memory[MAR];
        //Converstys the IR to binary
        String binary = Integer.toBinaryString(IR);
        int instruction = Integer.parseInt(binary, 2);
        System.out.println("Instruction as int: " + instruction);
        return instruction;
    }

}
