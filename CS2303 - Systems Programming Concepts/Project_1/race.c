// race.c
#include <stdlib.h>
#include <stdio.h>
#include "animals.h"

int main(void)
{
    // Prompts the user to enter a random number seed
    puts("Please enter a random number seed.");
    int seed;
    scanf("%d", &seed);
    srand(seed);

    // Initializes variables used for race tracking and leader tracking
    int greatest_position = 0;
    int time = 0;
    int current_leader = -1;

    // Initializes positions for each animal
    int hare_position = 0;
    int tortoise_position = 0;
    int bee_position = 0;

    // Continues the race until an animal reaches position 70 or greater
    while (greatest_position < 70)
    {
        // Increment the time for each interation
        time++;

        // Update the positions for each animal
        hare_position = update_hare(hare_position);
        tortoise_position = update_tortoise(tortoise_position);
        bee_position = update_bee(bee_position);

        // Determine which animal has the greatest position
        // When a new animal takes the lead, print out the time, animal, and position
        if (hare_position > tortoise_position && hare_position > bee_position)
        {
            greatest_position = hare_position;
            if (current_leader != 1)
            {
                printf("At t = %d, the hare (square %d) has taken the lead.\n", time, hare_position);
            }
            current_leader = 1;
        }
        else if (tortoise_position > hare_position && tortoise_position > bee_position)
        {
            greatest_position = tortoise_position;
            if (current_leader != 0)
            {
                printf("At t = %d, the tortoise (square %d) has taken the lead.\n", time, tortoise_position);
            }
            current_leader = 0;
        }
        else if (bee_position > hare_position && bee_position > tortoise_position)
        {
            greatest_position = bee_position;
            if (current_leader != 2)
            {
                printf("At t = %d, the bee (square %d) has taken the lead.\n", time, bee_position);
            }
            current_leader = 2;
        }
    }

    // Prints out the winner of the race
    switch (current_leader)
    {
    case 1:
        printf("After %d seconds, the hare wins!!\n", time);
        break;
    case 0:
        printf("After %d seconds, the tortoise wins!!\n", time);
        break;
    case 2:
        printf("After %d seconds, the bee wins!!\n", time);
        break;
    default:
        puts("Error");
        break;
    }
}
