#include <string.h>
#include "rational.h"

int read_rational(FILE * f1, int * n1, int * d1, int * n2, int * d2, char op[]);

int main(int argc, char *argv[]) {
    //Instantiate parsed variables
    int n1;
    int n2;
    int d1;
    int d2;
    char op[3];

    //Instantiate File variables
    FILE* input;
    FILE* output = fopen(argv[argc-1], "w");

    //Instantiate Rational variables
    Rational r1;
    Rational r2;
    Rational answer;

    //counter for while loop
    int i = 1;
  while(i < argc-1) { //Loop through each input file
    //set input to the correct input file
    input = fopen(argv[i], "r");
    while (read_rational(input, &n1, &d1, &n2, &d2, op) != 0){ //loop through each line in the file
      //create both rationals
      r1 = create_rational(n1, d1);
      r2 = create_rational(n2, d2);

      //Formatting prints
      print(output, &r1);
      fprintf(output, " %s ", op);
      print(output, &r2);
      fprintf(output, "\t: ");

      //Check which operator is being used, the call then the correct function(s)
      //Print the answer or true/false
      if (strcmp(op, "+") == 0){
        answer = add(&r1, &r2);
        print(output, &answer);
      }
      else if (strcmp(op, "-") == 0){
        answer = subtract(&r1, &r2);
        print(output, &answer);
    }
      else if (strcmp(op, "*") == 0){
        answer = multiply(&r1, &r2);
        print(output, &answer);
      }
      else if (strcmp(op, "/") == 0){
        answer = divide(&r1, &r2);
        print(output, &answer);
      }
      else if (strcmp(op, "==") == 0){
        if(equal(&r1, &r2)){
          fprintf(output, "true");
        }
        else{
          fprintf(output, "false");
        }
      }
      else if (strcmp(op, "!=") == 0){
        if(equal(&r1, &r2)){
          fprintf(output, "false");
        }
        else{
          fprintf(output, "true");
        }
      }
      else if (strcmp(op, ">") == 0){
        if(compare(&r1, &r2) == 1){
          fprintf(output, "true");
        }
        else{
          fprintf(output, "false");
        }
      }
      else if (strcmp(op, "<") == 0){
        if(compare(&r1, &r2) == -1){
          fprintf(output, "true");
        }
        else{
          fprintf(output, "false");
        }
      }
      else if (strcmp(op, ">=") == 0){
        if(compare(&r1, &r2) == 1 || equal(&r1, &r2)){
          fprintf(output, "true");
        }
        else{
          fprintf(output, "false");
        }
      }
      else if (strcmp(op, "<=") == 0){
        if(compare(&r1, &r2) == -1 || equal(&r1, &r2)){
          fprintf(output, "true");
        }
        else{
          fprintf(output, "false");
        }
      }
      //New line print
      fprintf(output, "\n");
    }
    //Increments the counter
    i++;
  }
}

int read_rational(FILE * f1, int * n1, int * d1, int * n2, int * d2, char op[]) {
  char line[100];
  char * s = fgets(line, 99, f1);
  if (s == NULL) {
    return 0;
  } else {
    // 1. rational1 op rational2
    if (sscanf(line, "%d/%d %s %d/%d", n1, d1, op, n2, d2) == 5) {
      return 5;
    }
    // 2. num1 op rational2
    else if (sscanf(line, "%d %s %d/%d", n1, op, n2, d2) == 4) {
      *d1 = 1;
      return 4;
    }
    // 3. rational1 op num2
    else if (sscanf(line, "%d/%d %s %d", n1, d1, op, n2) == 4) {
      *d2 = 1;
      return 4;
    }
    // 4. num1 op num2
    else if (sscanf(line, "%d %s %d", n1, op, n2) == 3) {
      *d1 = 1;
      *d2 = 1;
      return 3;
    }
    // 5. Error!
    else {
      return -1;
    }
  }
}