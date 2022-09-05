//This is Assignment 4 for Cs 2211
//I am Sergio Rangel Camacho student number: 251174481
//This program makes a database of sports, gender, competitors, and event code
//It can print, insert, update, search variables in the database.
//If you have any other question please feel free to contact me, thanks.
#include <stdio.h>
#include <string.h>

char name[100][50];
int checker = 0;
int partI(int code[], int competitors[], char gender[], int position){
    char tmpName[100];
    int tmpCode;
    int tmpComp;
    char tmpGender;
    int flag = 0;
    int saver = 0;
    printf("\nEnter event code: ");
    scanf(" %d", &tmpCode);
    printf("Enter event name: ");
    scanf(" %[^\n]", tmpName);
    printf("Enter number of competitors: ");
    scanf(" %d", &tmpComp);
    printf("Enter the gender: ");
    scanf(" %c", &tmpGender);
    for(int i = 0; i < position; i++){
        if(tmpCode == code[i]){
            flag++;
        }
    }
    if(tmpCode < 0 || tmpCode > 99 || flag != 0){
        printf("Event Code Error: Please try again");

    }
    
    else if(tmpComp < 10 || tmpComp > 99){
        printf("Competitors Number Error: Please try again");
    }

    else{
        code[position] = tmpCode;
        competitors[position] = tmpComp;
        gender[position] = tmpGender;
        strcpy(name[position], tmpName);
        checker++;
    }

    return 0;
}

int partS(int code[], int competitors[], char gender[], int position){
    int tmpCode;
    int found = 0;
    printf("\nEnter event code: ");
    scanf(" %d", &tmpCode);
    for(int i = 0; i < position; i++){
        if(tmpCode == code[i]){
            printf("Event Code   Event Name                  Competitors                  Gender\n");
            printf("%*d", 6, code[i]);
            printf("%*s", 16, name[i]);
            printf("%*d", 25, competitors[i]);
            printf("%*c\n", 27, gender[i]);
            found++;
        }
    }
    if(found == 0){
        printf("Nothing found, please try again.");
    }
    return 0;
}

int partU(int code[], int competitors[], char gender[], int position){
    char tmpName[100];
    int tmpCode;
    int tmpComp;
    char tmpGender;
    int flag = 0;
    int saver = 0;
    printf("\nEnter event code: ");
    scanf(" %d", &tmpCode);
    printf("Enter event name: ");
    scanf(" %[^\n]", tmpName);
    printf("Enter number of competitors: ");
    scanf(" %d", &tmpComp);
    printf("Enter the gender: ");
    scanf(" %c", &tmpGender);
    for(int i = 0; i < position; i++){
        if(code[i] == tmpCode){
            flag += i;
        }
    }
    if(tmpCode < 0 || tmpCode > 99){
        printf("Event Code Error: Please try again");

    }
    
    else if(tmpComp < 10 || tmpComp > 99){
        printf("Competitors Number Error: Please try again");
    }

    else{
        code[flag] = tmpCode;
        competitors[flag] = tmpComp;
        gender[flag] = tmpGender;
        strcpy(name[flag], tmpName);
    }
    return 0;
}

int partP(int code[], int competitors[], char gender[], int position){
    
    printf("Event Code   Event Name                  Competitors                  Gender\n");
    
    for(int i = 0; i < position; i++){
        printf("%*d", 6, code[i]);
        printf("%*s", 16, name[i]);
        printf("%*d", 25, competitors[i]);
        printf("%*c\n", 27, gender[i]);
    }
    
    return 0;
}

int main()
{
    printf("*************************");
    printf("\n* 2211 Winter Olympics! *\n");
    printf("*************************");
    
    int code[100];

    int competitors[100]; 
    char gender[100];
    int position = 0;
    char program = 0;
    char tmp[] = "";
    
    
    while (program != 'q' || program != 'Q'){
        
        printf("\n\nEnter operation code: ");
        scanf(" %c", &program);

        if(program == 'q' || program == 'Q'){
            break;
        }
        
        else if(program == 'i' || program == 'I'){
            partI(code, competitors, gender, position);
            if(checker != 0){
                position++;
                checker--;
            }

        }
        
        else if(program == 's' || program == 'S'){
            partS(code, competitors, gender, position);
        }
        
        else if(program == 'u' || program == 'U'){
            partU(code, competitors, gender, position);
        }
        
        else if(program == 'p' || program == 'P'){
            partP(code, competitors, gender, position);
        }
        
        else{
            printf(" ERROR: You have entered an invalid input please try again. \n");
        }
        
    }
    return 0;
}