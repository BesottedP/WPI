#include "shopQueue.h"
#include <iostream>
#include <vector>
#include <fstream>
#include <iomanip>

int getShortestQueue(const vector<ShopQueue>);

int main(int argc, char *argv[]){
    //Prints an error message if the wrong number of arguments is given
    if (argc != 7){
        cout << "Error: Wrong number of arguments!" << endl;
        cout << "Usage: ./run_simulation <seed> <total_min> <arrival_prob> <order_prob> <num_queues> <outputFile>" << endl;
    }

    // Sets variables for each argument
    int seed = atoi(argv[1]);
    int total_min = atoi(argv[2]);
    float arrival_prob = atof(argv[3]);
    float order_prob = atof(argv[4]);
    int num_queues = atoi(argv[5]);
    string outputFile = argv[6];

    //Indexes the customer count, starting at 0
    int customerNum = 0;
    //Sets a random seed
    srand(seed);

    //Prints info to terminal
    cout << "Welcome to Gompei Coffee Shop!" << endl;
    cout << "-- # of Checkout Queues: " << num_queues << " --" << endl;

    //Declaring and initializing vectors
    vector<ShopQueue> queues;
    vector<shared_ptr<Customer>> completed;
    vector<int> cashierNums;
    for (int i = 0; i < num_queues; i++){
        cashierNums.push_back(0);
    }

    for(int i = 0; i < num_queues; i++){
        ShopQueue queue;
        queues.push_back(queue);
    }

    //Main for loop, each iteration is a "minute" in the simulation
    for(int time = 0; time < total_min; time++){
        //Creates a random number between 0 and 1
        float random_arrive = ((float) rand())/(float) (RAND_MAX);
        //if the random number is lower than the arrival probability, add the customer to the shortest queue,
        //  increment the customer count, and print info to terminal 
        if(time == 0 || random_arrive < arrival_prob){
            queues[getShortestQueue(queues)].addNewCustomer(time, -1, -1, customerNum);
            customerNum++;
            cout << "New customer at t = " << time << "." << endl;
        }
        //For each tick, update the info in each queue
        for(int i = 0; i < queues.size(); i++){
            //If a queue is filled, do these operations
            if(queues[i].isEmpty() == false){
                //Set the start time for a customer if it hasn't been already
                if(queues[i].peekFrontCustomer() ->startTime < 0){
                    queues[i].peekFrontCustomer()->startTime = time;
                }
                //Creates a random number between 0 and 1
                float random_finish = ((float) rand())/(float) RAND_MAX;
                //If the number is lower than the order probability, do the following 
                if(random_finish < order_prob){
                    //increment the number of customers finished for the current queue
                    cashierNums[i]++;
                    //add the completed customer to the completed vector
                    completed.push_back(queues[i].peekFrontCustomer());
                    //update the completion time on the customer
                    queues[i].peekFrontCustomer()-> completedTime = time;
                    //Print info to terminal
                    cout << "Customer #" << queues[i].peekFrontCustomer()->ID 
                        << " was served from t = " << queues[i].peekFrontCustomer()->startTime 
                        << " to " << queues[i].peekFrontCustomer()->completedTime
                        << endl;
                    //remove the customer from the queue
                    queues[i].removeFrontCustomer();
                    //If the queue still has a customer, set the current time to its start time
                    if(queues[i].isEmpty() == false){
                        queues[i].peekFrontCustomer()->startTime = time;
                    }
                }
            }
        }
    }
    //for each queue, print the remainaing customers after the time has ended
    for(int i = 0; i < queues.size(); i++){
        cout << "After "<< total_min << " minutes, " << queues[i].getLength() << " customers remain in queue #"<< i << endl;
    }

    //for each cashier, print the number of customers finished after the time has ended
    for(int i = 0; i < queues.size(); i++){
        cout << "Cashier "<< i << " served " << cashierNums[i] << " customers" << endl;
    }

    //In an output file, print the ID, arrival time, start time, and leave time of each customer
    ofstream output;
    output.open(outputFile);
    output << setw(8) << "ID" << setw(8) << "Arrive" << setw(8) << "Start" << setw(8) << "Leave" << endl;
    for(auto& customerPtr : completed){
        Customer& customer = *customerPtr;
        output << setw(8) << customer.ID 
                << setw(8) << customer.arrivalTime
                << setw(8) << customer.startTime 
                << setw(8) << customer.completedTime 
                << endl;
    }

}


/***************************************************
 * int getShortestQueue(vector<ShopQueue> queues)
 * returns the index of the ShopQueue with the least customers in the given vector
 * Parameters:
 *      queues: a vector containing ShopQueue objects
 * Returns:
 *      shortestQueue: the index of the ShopQueue with the least customers
 * ************************************************/

int getShortestQueue(vector<ShopQueue> queues){
    int shortestQueue = 0;
    int shortestQueueLength = queues[0].getLength();
    for(int i = 1; i < queues.size(); i++){
        if(queues[i].getLength() < shortestQueueLength){
            shortestQueue = i;
            shortestQueueLength = queues[i].getLength();
        }
    }
    return shortestQueue;
}