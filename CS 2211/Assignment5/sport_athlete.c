#include "sport_athlete.h"

/* dump: Dumps contents of the athlete_tbl to specified
 *       file. Prints error message and does not
 *       terminate program upon failure. Does not store
 *       next pointer.
 */
void dump_athlete(struct athlete **athlete_tbl)
{
    FILE *fp;
    char filename[255];
    struct athlete **node = athlete_tbl;

    printf("Enter name of output file: ");
    read_line(filename, 255);

    if ((fp = fopen(filename, "wb")) == NULL)
    {
        fprintf(stderr, "File %s could not be written\n", filename);
        return;
    }

    while (*node)
    {
        fwrite(*node, sizeof(struct athlete) - sizeof(struct athlete *), 1, fp);
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

/* restore: Restores contents from specified file. Does
 *          not terminate upon file open failure, but
 *          terminates upon malloc failure.
 */
void restore_athlete(struct athlete **athlete_tbl)
{
    FILE *fp;
    char filename[255];
    struct athlete buffer;
    struct athlete *temp;
    struct athlete **node;

    printf("Enter name of input file: ");
    read_line(filename, 255);

    if ((fp = fopen(filename, "rb")) == NULL)
    {
        fprintf(stderr, "Error: file %s cannot be opened\n", filename);
        return;
    }

    while (*athlete_tbl)
    {
        temp = *athlete_tbl;
        *athlete_tbl = (*athlete_tbl)->next;
        free(temp);
    }

    node = athlete_tbl;

    while (fread(&buffer,sizeof(struct athlete) - sizeof(struct athlete *),1,fp) == 1)
    {
        if ((*node = malloc(sizeof(struct athlete))) == NULL)
        {
            fprintf(stderr, "Error: malloc failed in restore\n");
            exit(EXIT_FAILURE);
        }
        (*node)->number = buffer.number;
        strcpy((*node)->name, buffer.name);
        (*node)->age = buffer.age;
        (*node)->gender = buffer.gender;
        (*node)->next = NULL;
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}


void insert_athlete(struct athlete ** athlete_tbl){
	
}

void search_athlete(struct athlete ** athlete_tbl){
	
}

void update_athlete(struct athlete ** athlete_tbl){
	
}

void print_athlete(struct athlete ** athlete_tbl) {
	
}

void erase_athlete(struct athlete ** athlete_tbl){
	struct node *cur, *prev;
    	for (cur = , prev = NULL;
        cur != NULL && cur->value != n;
        prev = cur, cur = cur->next){
        	if (cur == NULL) {
            		return list; /* n was not found */
        	}
        	if (prev == NULL) {
            		list = list->next; /* n is in the first node */
        	}
        	else {
            		prev->next = cur->next; /* n is in some other node */
        	}
   	}
    	free(cur);
    	return list;
}