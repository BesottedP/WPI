//register.h

/***************************************************
 * void print_item(int rows, int cols, int data[][cols])
 * Prints the sales of an item for each month 
 * Parameters:
 *      rows: the number of rows in the passed in array
 *      cols: the number of columns in the passed in array
 *      data[][cols]: A 2D array containing sales data
 * Returns:
 *      void function. No returned value
 * Notes:
 *      Prompts the user for which item they would like to display.
 *      Prints the sales of an item, underneath the respective month.
 * ************************************************/
void print_item(int rows, int cols, int data[][cols]);

/***************************************************
 * void total_sales(int rows, int cols, int data[][cols])
 * Creates a text file with the total sales of each item 
 * Parameters:
 *      rows: the number of rows in the passed in array
 *      cols: the number of columns in the passed in array
 *      data[][cols]: A 2D array containing sales data
 * Returns:
 *      void function. No returned value
 * Notes:
 *      Writes the total sales of each item into a file named sales.txt
 * ************************************************/
void total_sales(int rows, int cols, int data[][cols]);

/***************************************************
 * void top_overall(int rows, int cols, int data[][cols])
 * Prints the item with the most sales 
 * Parameters:
 *      rows: the number of rows in the passed in array
 *      cols: the number of columns in the passed in array
 *      data[][cols]: A 2D array containing sales data
 * Returns:
 *      void function. No returned value
 * Notes:
 *      Prints the following: "The most popular item is item x",
 *      where x is the item with the most sales
 * ************************************************/
void top_overall(int rows, int cols, int data[][cols]);