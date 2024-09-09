# This makefile is used as follows to regenerate files for the rational_math program:
#   make rational.o   --  Regenerates rational.o by compiling
#   make test_rational.o   --  Regenerates test_rational.o by compiling
#   make rational    --  Regenerates the executable rational_math file by compiling
#	make clean      --  Removes the compiled files and the executable rational_math file
#   make              --  Same as "make rational"

rational: test_rational.o rational.o
	gcc -g -Wall test_rational.o rational.o -lm -o rational_math
	
test_rational.o: rational.h test_rational.c
	gcc -g -Wall -c test_rational.c

rational.o: rational.h rational.c
	gcc -g -Wall -c rational.c

clean:
	rm -f test_rational.o rational.o rational

all: rational