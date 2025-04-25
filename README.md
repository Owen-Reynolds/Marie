# Marie Simulator #

## Objective ##
Create a simple Marie Simulator that allows users to run and visualize the execution of Marie Assembley Code.
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" alt="Java Logo" width="300"/>

## Material Learned ##
1. Basic Marie Concepts  
2. Fetch-Decode-Execute Cycle
3. Machine Level Instructions
4. How CPUs operate internally

## Registers ##
|Name |Full Name                |
|-----|-------------------------|
|AC   |Accumulator              |
|PC   |Program Counter          |
|MQ   |Multiplier Quotient      |
|IR   |Instruction Register     |
|MAR  |Memory Address Register  |
|MDR  |Memory Data Register     |

## Methods ##
| Method Name | Method Operations                                                              |
|-------------|--------------------------------------------------------------------------------|
|Load         |Loads the value in the address in MAR to the AC                                 | 
|Store        |Stores the value in the AC to the address in MAR                                |
|Add          |Adds the value in the address in MAR to the AC                                  |
|Subtract     |Subtracts the value in the address in MAR from the AC                           |
|Input        |Takes user input and stores in the AC                                           |
|Output       |Outputs the value in the AC to the console                                      |
|Fetch        |Fetches the instruction from the memory and decodes to binary then returns it   |
|Execute      |Executes the instruction based on the opcode                                    |
|RunProgram   |Runs the program by fetching and executing instructions in a loop               |
|LoadProgram  |Loads a program into memory                                                     |

## Sample Program ##
### Driver Code ###
```Java
public class MarieDriver {
  public static void main(String[] args) {
    MarieOperations marie = new MarieOperations();
      int[] program = {
                0b010100000000, //Input
                0b001000001010, //Store
                0b010100000000, //Input
                0b001100001010, //Add
                0b011000000000, //Output
                0b111100000000  //Halt
            };
    
      marie.loadProgram(program);
      marie.runProgram();
  }
}
```
### Loading the Program ###
```Java
public void loadProgram(int[] program){
          for(int i = 0; i < program.length; i++){
                    memory[i] = program[i];
          }
}
```
### Running the Program ###
```Java
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
```
### Fetching Instruction ###
```Java
public int fetch(){
          MAR = PC;
          IR = memory[MAR];
          PC++;
          return IR;
}
```
### Executing Opcode ###
```Java
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
          } else {
                    System.out.println("Invalid instruction");
          }
}
```
### Instruction Set Methods ###

<details>
  <summary><strong>Load</strong></summary>

  <pre><code class="language-java">
  public void load(int address){
      MAR = address;
      MDR = memory[MAR];
      AC = MDR;
      System.out.println("Load:" + AC);
  }
  </code></pre>
</details>

<details>
  <summary><strong>Store</strong></summary>

  <pre><code class="language-java">
  public void store(int address){
      MAR = address;
      memory[MAR] = AC;
      System.out.println("Store :" + AC );
  }
  </code></pre>
</details>

<details>
  <summary><strong>Add</strong></summary>

  <pre><code class="language-java">
  public void add(int address){
      MAR = address;
      MDR = memory[MAR];
      AC += MDR;
      System.out.println("Add : " + AC);
  }
  </code></pre>
</details>

<details>
  <summary><strong>Subtract</strong></summary>

  <pre><code class="language-java">
  public void subtract(int address){
      MAR = address;
      MDR = memory[MAR];
      AC -= MDR;
      System.out.println("Subtract : " + AC);
  }
  </code></pre>
</details>

<details>
  <summary><strong>Input</strong></summary>

  <pre><code class="language-java">
  public void input(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a value to input into AC: ");
      int value = sc.nextInt();
      AC = value;
      System.out.println("Input : " + AC);
  }
  </code></pre>
</details>

<details>
  <summary><strong>Output</strong></summary>

  <pre><code class="language-java">
  public void output(){
      System.out.println("Output : " + AC);
  }
  </code></pre>
</details>

### Sample Program Operation Summary ###
|Operation    |Output                                   |
|-------------|-----------------------------------------|
|Input        |Allows user to input value               |
|Store        |Stores the previous input                |
|Input        |Allows user to input value               |
|Add          |Adds input value with store value        |
|Output       |Displays value                           |
|Halt         |Program Halted                           |

## Setup ##
Follow these steps to run the program locally
### 1. Clone the Repository ###
```bash
git clone https://github.com/Owen-Reynolds/Marie.git
cd Marie
```
### 2. Compile the Program ###
```bash 
javac MarieOperations.java MarieDriver.java
```
### 3. Run Program ###
```bash
java MarieDriver
```
### Requirements ###
Java JDK 8 or later  
A terminal or IDE  

## Sources ##
https://medium.com/@manurahimsara/beginners-guide-to-marie-assembly-language-a22a8f04df8a  
https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax  
https://www.geeksforgeeks.org/how-to-git-clone-a-remote-repository/  

