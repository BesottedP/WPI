# This makefile is used as follows to regenerate files for the run_simulation program:
#   make run_simulation    --  Regenerates the executable run_simulation file by compiling
#	make o. -- Regenerations all object files by compiling
#	make clean      --  Removes the compiled files and the executable run_simulation file
#   make              --  Same as "make run_simulation"

SRCS = simulation.cpp shopQueue.cpp
OBJS = $(SRCS:.cpp=.o)

run_simulation: $(OBJS)
	g++ -Wall -std=c++11 -o $@ $(OBJS)

%.o: %.cpp customer.h shopQueue.h
	g++ -Wall -std=c++11 -c $< -o $@

clean:
	rm -f $(OBJS) run_simulation
