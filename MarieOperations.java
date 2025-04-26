import java.util.Scanner;

public class MarieOperations {
    //Create memory array and registers
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
        System.out.println("Store : " + AC );
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

    //Multiplies the value in the address in MAR with the AC
    public void multiply(int address){
        MAR = address;
        MDR = memory[MAR];
        AC *= MDR;
        System.out.println("Multiply : " + AC);
    }

    //Divides the value in the address in MAR by the AC
    public void divide(int address){
        MAR = address;
        MDR = memory[MAR];
        if(MDR != 0){
            AC /= MDR;
            System.out.println("Divide : " + AC);
        } else {
            System.out.println("Error: Division by zero");
        }
    }

    //Takes user input and stores in the AC
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value to input into AC: ");
        int value = sc.nextInt();
        AC = value;
        System.out.println("Input : " + AC);
    }

    //Outputs the value in the AC to the console
    public void output(){
        System.out.println("Output : " + AC);
    }

    //Fetches the instruction from the memory and then returns it
    public int fetch(){
        MAR = PC;
        IR = memory[MAR];
        PC++;
        return IR;
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
            input();
        } else if(opcode == 6){
            output();
        } else if(opcode == 7){
            multiply(address);
        } else if(opcode == 8){
            divide(address);
        }
        else {
            System.out.println("Invalid instruction");
        }
    }

    //Runs the program by fetching and executing instructions in a loop
    public void runProgram(){
        while(true){
            int instruction = fetch();

            if(instruction == 0b111100000000){
                System.out.println("Halt");
                break;
            }

            execute(instruction);
        }
    }
    
    //Loads a program into memory
    public void loadProgram(int[] program){
        for(int i = 0; i < program.length; i++){
            memory[i] = program[i];
        }
    }
}
