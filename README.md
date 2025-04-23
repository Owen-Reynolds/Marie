# Marie Simulator #

## Objective ##
Create a simple Marie Simulator that allows users to run and visualize the execution of Marie Assembley Code.

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
|Operation    |Output                                   |
|-------------|-----------------------------------------|
|Input 10     |Allows user to input value 10            |
|Store        |Stores the previous input                |
|Input 10     |Allows user to input value 10            |
|Add          |Adds input value with store value        |
|Output       |Displays value                           |
|Halt         |Program Halted                           |

## Setup ##



