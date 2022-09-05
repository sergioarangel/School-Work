CC=gcc
CFLAGS=-Wall -Wpedantic -Wextra -std=c99

default:
	make all

clean:
	rm -f *.o sport_events sport_athlete sport_db

# To be implemented

sport_db: sport_db.o sport athlete.o sport_events.o
	gcc -o sport_db sport _db.o sport_athlete.o sport_events.o

sport_db.o: sport_db.c sport_db.h sport_athlete.h sport_events.h
	gcc -c sport_db.c

sport_athlete.o:
	gcc -c sport_athlete.c

sport_events.o: sport_events.c sport_events.h
	gcc -c sport_events.c
	
