run_simulation.c
Ishaan Patel
03/02/2024

This program simulates a store, and produces data on a customers time in the store

To compile the program, run the command:
    make run_simulation

To run the program, run the command:
    ./run_simulation seed minutes arrival_prob order_prob numberQueues output.txt
    seed is the random generation seed
    minutes is how many iterations that the store run_simulation
    arrival_prob is a decimal number representing the probability of a customer entering the store in an iteration
    order_prob is a decimal number representing the probability of a customer finishing an order in an iteration
    numberQueues is the number of Queues a customer can enter
    output.txt is the name of the output file used for results

Sources:
    https://www.softwaretestinghelp.com/cpp-makefile-tutorial/
    