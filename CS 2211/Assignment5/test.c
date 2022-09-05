//#include "sport_events.h"

/* dump: Dumps contents of the event_tbl to specified
 *       file. Prints error message and does not
 *       terminate program upon failure. Does not store
 *       next pointer.
 */

#include <stddef.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


struct event {
	int number;
	char *name[50];
	int event_size;
	char gender;
	struct event *next;
	};

    struct athlete {
	int number;
	char *name[50];
	int age;
	char gender;
	struct athlete *next;
	};	

void insert_event(struct event **event_tbl){
    
    struct event *cur, *prev, *new_node;
    new_node = malloc(sizeof(struct event));
    
    if (new_node == NULL) {
        printf("Database is full; can't add more parts.\n");
        return;
    }
    
    printf("        Enter event code: ");
    scanf(" %d", &new_node->number);
    printf("        Enter event name: ");
    scanf(" %s", new_node->name);
    printf("        Enter number of competitors: ");
    scanf(" %d", &new_node->event_size);
    printf("        Enter the gender");
    scanf(" %c", &new_node->gender);
    
    for (cur = event_tbl, prev = NULL;
        cur != NULL && new_node->number > cur->number;
        prev = cur, cur = cur->next){
            
        if (cur != NULL && new_node->number == cur->number) {
            printf("Part already exists.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->number < 0){
            printf("Invalid event code.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->event_size < 10 || 
        cur != NULL && new_node->event_size > 99){
            printf("Invalid competitor count.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->gender != 'M' ||
        cur != NULL && new_node->gender != 'W' ||
        cur != NULL && new_node->gender != 'X'){
            printf("Invalid gender.\n");
            free(new_node);
            return;
        }
    }
    
    new_node->next = cur;
    
    if (prev == NULL){
        event_tbl = new_node;
    }
    else{
        prev->next = new_node;
    }
    
}

void search_event(struct event **event_tbl){

    struct event *p;
    int number;
    printf("Enter event code: ");
    scanf("%d", &number);
    
    for (p = event_tbl; p != NULL && p->number; p = p->next){

	if (p != NULL && number > p->number) {
            
            printf("Event Code   Event Name                  Competitors                  Gender\n");
	    printf(
    "      %-8d%-55s%-12d%c\n",
           p->number,
           p->name,
           p->event_size,
           p->gender
           );
           return;
    }

            
        
	
        else {
            printf("Nothing found, please try again.\n");
        }
    }
    
}

void update_event(struct event **event_tbl){
    struct event *cur, *prev, *new_node;
    new_node = malloc(sizeof(struct event));
    
    if (new_node == NULL) {
        printf("Database is full.\n");
        return;
    }
    
    printf("        Enter event code: ");
    scanf(" %d", &new_node->number);
    printf("        Enter event name: ");
    scanf(" %s", new_node->name);
    printf("        Enter number of competitors: ");
    scanf(" %d", &new_node->event_size);
    printf("        Enter the gender");
    scanf(" %c", &new_node->gender);
    

    for (cur = event_tbl, prev = NULL;
        cur != NULL && new_node->number > cur->number;
        prev = cur, cur = cur->next){
            
        if (cur != NULL && new_node->number == cur->number) {
            printf("Entry already exists.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->number < 0){
            printf("Invalid event code.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->event_size < 10 || 
        cur != NULL && new_node->event_size > 99){
            printf("Invalid competitor count.\n");
            free(new_node);
            return;
        }
        
        else if(cur != NULL && new_node->gender != 'M' ||
        cur != NULL && new_node->gender != 'W' ||
        cur != NULL && new_node->gender != 'X'){
            printf("Invalid gender.\n");
            free(new_node);
            return;
        }
    }
    
    new_node->next = cur;
    
    if (prev == NULL){
        event_tbl = new_node;
    }
    else{
        prev->next = new_node;
    }
}

void erase_event(struct event **event_tbl){
    struct event *cur, *prev;
    for (cur = event_tbl, prev = NULL;
        cur != NULL && cur->value != n;
        prev = cur, cur = cur->next){
        if (cur == NULL) {
            return event_tbl; /* n was not found */
        }
        if (prev == NULL) {
            event_tbl = event_tbl->next; /* n is in the first node */
        }
        else {
            prev->next = cur->next; /* n is in some other node */
        }
    }
    free(cur);
    return event_tbl;}

void print_event(struct event **event_tbl){

    struct event *p;
    printf("Event Code   Event Name                  Competitors                  Gender\n");
        
    for (p = event_tbl; p != NULL; p = p->next) {
        printf(
    "      %-8d%-55s%-12d%c\n",
           p->number,
           p->name,
           p->event_size,
           p->gender
           );
    }
    
}

int main(void)
{
    

    struct event *event_tbl = NULL;   /* points to first event */
    struct athlete *athlete_tbl = NULL;   /* points to first athlete */

    char entity, code;
    printf("****************************\n");
    printf("* 2211 Winter Olympics!    *\n");
    printf("****************************\n\n\n");

    for (;;) {
        printf("Enter entity type (h for help, q to quit, e for events, a for athletes): ");
        scanf(" %c", &entity);
        while (getchar() != '\n')   /* skips to end of line */
        ;
        if (entity == 'h'){
            print_help();
        }
        else if (entity == 'e'){
            printf("Event:\n\t");
            printf("Enter operation code\n\t(i to insert, s to search,\n\tu to update, p to print,\n\td to dump, r to restore,\n\te to erase): ");
            scanf(" %c", &code);
            while (getchar() != '\n')   /* skips to end of line */
                ;

            switch (code) {
                case 'i': insert_event(&event_tbl);
                            break;
                case 's': search_event(&event_tbl);
                            break;
                case 'u': update_event(&event_tbl);
                            break;
                case 'p': print_event(&event_tbl);
                            break;
                case 'e': erase_event(&event_tbl);
                            break;
                default:  printf("Illegal code\n");
            }
        }
        
        else if (entity == 'q'){
            return 0;
        }
        else{
            printf("Illegal entity\n");
        }
        printf("\n");
    }
}

void print_help(void){
    printf("\nEnter e for event, a for athlete, then\n");
    printf("Enter operation code\n\t(i to insert, s to search,\n\tu to update, p to print,\n\td to dump, r to restore,\n\te to erase)\n\n ");
}