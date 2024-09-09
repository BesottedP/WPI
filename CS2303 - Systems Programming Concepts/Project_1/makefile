# This makefile is used as follows to regenerate files for the theRace program:
#   make animals.o   --  Regenerates animals.o by compiling
#   make race.o   --  Regenerates race.o by compiling
#   make theRace    --  Regenerates the executable theRace file by compiling
#	make clean      --  Removes the compiled files and the executable theRace file
#   make              --  Same as "make theRace"

theRace: race.o animals.o
	gcc -g -Wall race.o animals.o -lm -o theRace
	
race.o: animals.h race.c
	gcc -g -Wall -c race.c

animals.o: animals.h animals.c
	gcc -g -Wall -c animals.c

clean:
	rm -f race.o animals.o theRace

all: theRace