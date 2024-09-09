#include "rational.h"

Rational create_rational(const int num, const int denom){
    // Creates a rational number with the given numerator and denominator.
    Rational tmp;
    tmp.numerator = num;
    tmp.denominator = denom;
    //Simplifies the rational
    simplify(&tmp);
    return tmp;
}

Rational copy_rational(const Rational *orig){
    // Creates a copy of the given rational number.
    Rational new = create_rational(orig->numerator, orig->denominator);
    return new;
}

void simplify(Rational *r){
    // Simplifies the given rational number by dividing both numerator and denominator
    // by their greatest common divisor.
    int div = gcd(r->numerator, r->denominator);
    r->numerator /= div;
    r->denominator /= div;

    //If the numerator and denominator are negative, then make both positive
    if (r->denominator < 0 && r->numerator < 0){
        r->denominator = abs(r->denominator);
        r->numerator = abs(r->numerator);
    }
    //If just the denominator is negative, make the numerator negative and denominator positive
    else if (r->numerator < 0){
        r->numerator = -(r->numerator);
        r->denominator = abs(r->denominator);
    }
    
}

Rational add(const Rational *num1, const Rational *num2){
    Rational result;

    // Finds a common denominator of both Rationals.
    int common_denom = lcm(num1->denominator, num2->denominator);

    // Adjusts numerators to have the Rationals have the same denominator.
    int num1_num = num1->numerator * (common_denom / num1->denominator);
    int num2_num = num2->numerator * (common_denom / num2->denominator);

    // Creates a new rational with the sum.
    result = create_rational(num1_num + num2_num, common_denom);
    return result;
}

Rational subtract(const Rational *num1, const Rational *num2){
    Rational result;

    // Finds a common denominator for subtraction.
    int common_denom = lcm(num1->denominator, num2->denominator);

    // Adjusts numerators to have the Rationals have the same denominator.
    int num1_num = num1->numerator * (common_denom / num1->denominator);
    int num2_num = num2->numerator * (common_denom / num2->denominator);

    // Creates a new rational with the difference.
    result = create_rational(num1_num - num2_num, common_denom);
    return result;
}

Rational multiply(const Rational *num1, const Rational *num2){
    Rational result;

    // Multiplies numerators and denominators separately.
    int numerator = num1->numerator * num2->numerator;
    int denominator = num1->denominator * num2->denominator;

    // Creates a new rational.
    result = create_rational(numerator, denominator);
    return result;
}

Rational divide(const Rational *num1, const Rational *num2){
    Rational result;

    // Multiplies the first Rational with the reciprocal of the second Rational.
    int numerator = num1->numerator * num2->denominator;
    int denominator = num1->denominator * num2->numerator;

    // Creates a new rational.
    result = create_rational(numerator, denominator);
    return result;
}

void print(FILE *file, const Rational *rational){
    // Copy the given rational
    Rational new_rational = copy_rational(rational);

    // Prints the rational number to the given file.
    if (new_rational.denominator == 1){ //Prints just the numerator if the denominator is 1.
        fprintf(file, "%d", new_rational.numerator);
    }
    else{//Prints numerator/denominator otherwise.
        fprintf(file, "%d/%d", new_rational.numerator, new_rational.denominator);
    }
}

bool equal(const Rational *num1, const Rational *num2){
    // Copies and compares the numerators of each rational.
    Rational new_num1 = copy_rational(num1);
    Rational new_num2 = copy_rational(num2);
    if (new_num1.numerator == new_num2.numerator &&
        new_num1.denominator == new_num2.denominator){//return true if the ratioals match, otherwise false
        return true;
    }
    return false; 
}

int compare(const Rational *num1, const Rational *num2){
    // Copies and compares the numerators of each rational.
    Rational new_num1 = copy_rational(num1);
    Rational new_num2 = copy_rational(num2);
    if (new_num1.numerator == new_num2.numerator &&
        new_num1.denominator == new_num2.denominator){ //Returns 0 if numerators match
        return 0;
    }
    else if (new_num1.numerator > new_num2.denominator){ //Returns 1 is num1 is greater than num 2
        return 1;
    }
    return -1; //return -1 otherwise
}

int gcd(int a, int b){
    // Calculates the greatest common divisor.
    if (b == 0){
        return a;
    }
    else{
        return gcd(b, a % b);
    }
}

int lcm(int a, int b){
    // Calculates the least common multiple.
    return ((a * b) / gcd(a, b));
}
