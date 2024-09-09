//rational.h
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//Rational struct definition, takes in 2 ints, a numerator and a denominator
struct rational{
    int numerator;
    int denominator;
};

typedef struct rational Rational;

/***************************************************
 * Rational create_rational(const int num, const int denom)
 * Creates a rational number
 * Parameters:
 *      num: an integer representing the numerator of the rational number
 *      denom: an integer representing the denominator of the rational number
 * Returns:
 *      A Rational struct representing a rational number
 * ************************************************/
Rational create_rational(const int, const int);

/***************************************************
 * Rational copy_rational(const Rational* orig)
 * Creates a copy of a rational number
 * Parameters:
 *      orig: a pointer to a Rational struct representing the rational number to be copied
 * Returns:
 *      A copy of the input rational number as a Rational struct
 * ************************************************/
Rational copy_rational(const Rational*);

/***************************************************
 * void simplify(Rational* r)
 * Simplifies a rational number
 * Parameters:
 *      r: a pointer to a Rational struct representing the rational number to be simplified
 * Returns:
 *      void function. No returned value.
 * Notes:
 *      Uses the greatest common divisor helper function to find a common denominator.
 * ************************************************/
void simplify(Rational*);

/***************************************************
 * Rational add(const Rational* num1, const Rational* num2)
 * Adds two rational numbers
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      A Rational struct representing the sum of the two input rational numbers
 * Notes:
 *      Simplifies the Rational before returning.
 *      Uses the least common multiple helper function to find a common denominator before adding
 * ************************************************/
Rational add(const Rational*, const Rational*);

/***************************************************
 * Rational subtract(const Rational* num1, const Rational* num2)
 * Subtracts two rational numbers
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      A Rational struct representing the difference between num1 and num2
 * Notes:
 *      Simplifies the Rational before returning.
 *      Uses the least common multiple helper function to find a common denominator before subtracting
 * ************************************************/
Rational subtract(const Rational*, const Rational*);

/***************************************************
 * Rational multiply(const Rational* num1, const Rational* num2)
 * Multiplies two rational numbers
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      A Rational struct representing the product of the two input rational numbers
 * Notes:
 *      Simplifies the Rational before returning
 * ************************************************/
Rational multiply(const Rational*, const Rational*);

/***************************************************
 * Rational divide(const Rational* num1, const Rational* num2)
 * Divides two rational numbers
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      A Rational struct representing the quotient of the two input rational numbers
 * Notes:
 *      Simplifies the Rational before returning
 * ************************************************/
Rational divide(const Rational*, const Rational*);

/***************************************************
 * void print(FILE* file, const Rational* rational)
 * Prints a rational number to the specified file
 * Parameters:
 *      file: the file where the output will be printed
 *      rational: a pointer to a Rational struct representing the rational number to be printed
 * Returns:
 *      void function. No returned value.
 * Notes:
 *      Only prints the numerator if the denominator is 1
 *      Prints the rational number in the format "numerator/denominator" otherwise.
 *      Simplifies the Rational before printing
 *      Does NOT print a new line character at the end
 * ************************************************/
void print(FILE*, const Rational*);

/***************************************************
 * bool equal(const Rational* num1, const Rational* num2)
 * Checks if two rational numbers are equal
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      bool: true if the two rational numbers are equal, false otherwise
 * Notes:
 *      Simplifies both rationals before comparing
 *      Compares the numerators and denominators of the two rational numbers for equality.
 * ************************************************/
bool equal(const Rational*, const Rational*);

/***************************************************
 * int compare(const Rational* num1, const Rational* num2)
 * Compares two rational numbers
 * Parameters:
 *      num1: a pointer to a Rational struct representing the first rational number
 *      num2: a pointer to a Rational struct representing the second rational number
 * Returns:
 *      int: 0 if the two rational numbers are equal, -1 if num1 < num2, 1 if num1 > num2
 * Notes:
 *      Simplifies both rationals before comparing.
 * ************************************************/
int compare(const Rational*, const Rational*);

/***************************************************
 * int gcd(int a, int b)
 * Computes the greatest common divisor (GCD) of two integers
 * Parameters:
 *      a: an integer
 *      b: an integer
 * Returns:
 *      int: the greatest common divisor of a and b
 * Sources:
 *      https://en.wikipedia.org/wiki/Greatest_common_divisor
 * ************************************************/
int gcd(int a, int b);

/***************************************************
 * int lcm(int a, int b)
 * Computes the least common multiple (LCM) of two integers
 * Parameters:
 *      a: an integer
 *      b: an integer
 * Returns:
 *      int: the least common multiple of a and b
 * Sources:
 *      https://en.wikipedia.org/wiki/Least_common_multiple
 * ************************************************/
int lcm(int a, int b);

/***************************************************
 * int read_rational(FILE * f1, int * n1, int * d1, int * n2, int * d2, char op[]);
 * Parses through a line in a text file
 * Parameters:
 *      f1*: the file to be parsed
 *      n1,d1,n2,d2*: pointers to numerator 1, denominator 1,
 *                    numerator 2, and denominator 2, respectively
 *      op[]: a string representing the operation being done in the read line
 * Returns:
 *      int: the number of pointer values changed, or -1 if there is no text on a line
 * ************************************************/
int read_rational(FILE * f1, int * n1, int * d1, int * n2, int * d2, char op[]);