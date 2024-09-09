// animals.c
#include <stdio.h>
#include <stdlib.h>
#include "animals.h"

int update_hare(int current_position)
{
    // Generate a random float between 0 and 1
    float val = ((float)rand() / (float)(RAND_MAX));
    if (0 <= val && val < 0.25)
    { // 25% chance for the hare to sleep (no movement)
        current_position = current_position;
    }
    else if (0.25 <= val && val < 0.45)
    { // 20% chance for the hare to make a Big Hop (forward 9 spaces)
        current_position = current_position + 9;
    }
    else if (0.45 <= val && val < 0.55)
    { // 10% chance for the hare to make a Big Slip (backwards -10 spaces)
        current_position = current_position - 10;
    }
    else if (0.55 <= val && val < 0.8)
    { // 25% chance for the hare to make a Small Hop (forward 2 spaces)
        current_position = current_position + 2;
    }
    else if (0.8 <= val && val <= 1)
    { // 20% chance for the hare to make a Small Slip (backwards -3 spaces)
        current_position = current_position - 3;
    }

    if (current_position < 0)
    { // Set the position to 0 if it is less than 0
        current_position = 0;
    }

    // return the position of the hare after the move
    return current_position;
}

int update_tortoise(int current_position)
{
    // Generate a random float between 0 and 1
    float val = ((float)rand() / (float)(RAND_MAX));
    if (0 <= val && val < 0.45)
    { // 45% chance for the tortoise to make a Fast Plod (forward 3 spaces)
        current_position = current_position + 3;
    }
    else if (0.45 <= val && val < 0.65)
    { // 20% chance for the tortoise to Slip (backwards 5 spaces)
        current_position = current_position - 5;
    }
    else if (0.65 <= val && val <= 1)
    { // 35% chance for the tortoise to make a Slow Plod (forward 1 space)
        current_position = current_position + 1;
    }

    if (current_position < 0)
    { // Set the position to 0 if it is less than 0
        current_position = 0;
    }

    // Return the position of the tortoise after the move
    return current_position;
}

int update_bee(int current_position)
{
    // Generate a random float between 0 and 1
    float val = ((float)rand() / (float)(RAND_MAX));
    if (0 <= val && val < 0.30)
    { // 30% chance for the bee to Fly fast (forward 2 spaces)
        current_position = current_position + 2;
    }
    else if (0.3 <= val && val < 0.50)
    { // 20% chance for the bee to Fly slow (forward 1 space)
        current_position = current_position + 1;
    }
    else if (0.50 <= val && val <= 1)
    { // 50% chance for the bee to Rest (no movement)
        current_position = current_position;
    }

    if (current_position < 0)
    { // Set the position to 0 if it is less than 0
        current_position = 0;
    }

    // Return the position of the bee after the move
    return current_position;
}
