//register.c
#include <stdlib.h>
#include <stdio.h>
#include "register.h"

void print_item(int rows, int cols, int data[][cols]){
    //Prompts the user for which item they want to print 
    puts("Which item?");
    int item;
    scanf("%d", &item);

    //Prints a header line
    puts("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");

    //Loops through the 2D array, printing the sales data from each month, with tabs in between
    for(int i = 0; i < cols; i++){
        printf("%d\t", data[item][i]);
    }
    puts("");
}

void total_sales(int rows, int cols, int data[][cols]){
    //Creates a File object, with the file name sales.txt
    FILE* sales = fopen("sales.txt", "w");
    //Prints a header line
    fprintf(sales, "Item\tSales\n");

    //Loops through each item, and sets total to 0 at the start of each iteration
    for(int i = 0; i < rows; i++){
        int total = 0; 
        //Retrieves the sales of an item in each month, and adds it to the total
        for(int j = 0; j < cols; j++){
            total += data[i][j];
        }
        //Prints the total amount of sales besides the item number in the sales.txt file
        fprintf(sales, "%02d\t%4d\n", i, total);
    }
}

void top_overall(int rows, int cols, int data[][cols]){
    //Sets the most_popular item to item 0
    int most_popular = 0;
    //Sets the most_sales per item to 0
    int most_sales = 0;

    //Loops through each item, and sets current_sales to 0 for each iteration
    for(int i = 0; i < rows; i++){
        int current_sales = 0; 
        //Sums the sales for each item
        for(int j = 0; j < cols; j++){
            current_sales += data[i][j];
        }
        //If the sales for the item in the current interation is greater than the item with most sales
        //Set most popular to the item number, and most sales to the the number of sales
        if(current_sales > most_sales){
            most_popular = i;
            most_sales = current_sales;
        }
    }

    //Print the most popular item
    printf("The most popular item is item %d.", most_popular);
    puts("");

}