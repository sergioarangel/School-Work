#include "sport_events.h"

/* dump: Dumps contents of the event_tbl to specified
 *       file. Prints error message and does not
 *       terminate program upon failure. Does not store
 *       next pointer.
 */
void dump_event(struct event **event_tbl)
{
    FILE *fp;
    char filename[255];
    struct event **node = event_tbl;

    printf("Enter name of output file: ");
    read_line(filename, 255);

    if ((fp = fopen(filename, "wb")) == NULL)
    {
        fprintf(stderr, "File %s could not be written\n", filename);
        return;
    }

    while (*node)
    {
        fwrite(*node, sizeof(struct event) - sizeof(struct event *), 1, fp);
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

/* restore: Restores contents from specified file. Does
 *          not terminate upon file open failure, but
 *          terminates upon malloc failure.
 */
void restore_event(struct event **event_tbl)
{
    FILE *fp;
    char filename[255];
    struct event buffer;
    struct event *temp;
    struct event **node;

    printf("Enter name of input file: ");
    read_line(filename, 255);

    if ((fp = fopen(filename, "rb")) == NULL)
    {
        fprintf(stderr, "Error: file %s cannot be opened\n", filename);
        return;
    }

    while (*event_tbl)
    {
        temp = *event_tbl;
        *event_tbl = (*event_tbl)->next;
        free(temp);
    }

    node = event_tbl;

    while (fread(&buffer,sizeof(struct event) - sizeof(struct event *),1,fp) == 1)
    {
        if ((*node = malloc(sizeof(struct event))) == NULL)
        {
            fprintf(stderr, "Error: malloc failed in restore\n");
            exit(EXIT_FAILURE);
        }
        (*node)->number = buffer.number;
        strcpy((*node)->name, buffer.name);
        (*node)->event_size = buffer.event_size;
        (*node)->gender = buffer.gender;
        (*node)->next = NULL;
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

//To be implemented
