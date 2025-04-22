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

    public void halt(){
        System.out.println("Halt");
    }

    //Fetches the instruction from the memory and decodes to binary then returns it
    public int fetch(){
        MAR = PC;
        IR = memory[MAR];
        //Converstys the IR to binary
        String binary = Integer.toBinaryString(IR);
        int instruction = Integer.parseInt(binary, 2);
        System.out.println("Instruction as int: " + instruction);
        return instruction;
    }

    //Executes the instruction based on the opcode
    public void execute(int instruction){
        int opcode = instruction >> 8;
        int address = instruction & 0xFF;

        if(opcode == 1){
            load(address);
        } else if(opcode == 2){
            store(address);
        } else if(opcode == 3){
            add(address);
        } else if(opcode == 4){
            subtract(address);
        } else if(opcode == 5){
            input(address);
        } else if(opcode == 6){
            output();
        } else {
            System.out.println("Invalid instruction");
        }
    }

    //Runs the program by fetching and executing instructions in a loop
    public void runProgram(){
        while(true){
            int instruction = fetch();
            execute(instruction);
            PC++;
            if(instruction == 0b111100000000){
                System.out.println("Halt");
                break;
            }
        }
    }
    
    //Loads a program into memory
    public void loadProgram(int[] program){
        for(int i = 0; i < program.length; i++){
            memory[i] = program[i];
        }
    }

}
