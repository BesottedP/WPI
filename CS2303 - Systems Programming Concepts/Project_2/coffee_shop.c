//coffee_shop.c
#include <stdlib.h>
#include <stdio.h>
#include "register.h"

int main(void){

    //Creates a file variable for each data file
    FILE* jan = fopen("Jan_2023_data.txt", "r");
    FILE* feb = fopen("Feb_2023_data.txt", "r");
    FILE* mar = fopen("Mar_2023_data.txt", "r");
    FILE* apr = fopen("Apr_2023_data.txt", "r");
    FILE* may = fopen("May_2023_data.txt", "r");
    FILE* jun = fopen("Jun_2023_data.txt", "r");
    FILE* jul = fopen("Jul_2023_data.txt", "r");
    FILE* aug = fopen("Aug_2023_data.txt", "r");
    FILE* sep = fopen("Sep_2023_data.txt", "r");
    FILE* oct = fopen("Oct_2023_data.txt", "r");
    FILE* nov = fopen("Nov_2023_data.txt", "r");
    FILE* dec = fopen("Dec_2023_data.txt", "r");

    //An array of all file objects
    FILE* months[12] = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};

    //A 2D array to hold data from the files
    int data2D[50][12];

    //Loops through each file, then loops through each entry in the files
    for(int i = 0; i < 12; i++){
        for(int j = 0; j < 50; j++){
            //Adds an entry to the data array
            fscanf(months[i], "%*d %*s %d", &data2D[j][i]);
        }
        fclose(months[i]);
    }

    //Prompts the user for which program they wish to run
    puts("Which program would you like to run?\n(1) Output the monthly sales of an item.\n(2) Calculate overall sales for all items.\n(3) Find the most popular item.");
    int program;
    scanf("%d", &program);

    //Calls the appropriate function, or "error" if the use enters anything other than 1, 2 or 3.
    switch (program)
    {
    case 1:
        print_item(50, 12, data2D);
        break;
    case 2:
        total_sales(50, 12, data2D);
        break;
    case 3:
        top_overall(50, 12, data2D);
        break;
    default:
        puts("error");
        break;
    }
}