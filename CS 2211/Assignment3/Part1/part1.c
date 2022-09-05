//The purpose of this program is to allow the user to input a series of numbers
//seperated by spaces and it will put it into an array from which it will
//complete a series of tasks that were instructed

//My name is Sergio Rangel Camacho Student Number: 251174481


#include <stdio.h>

int length;

int part1(int array[]){
    int byteSize = length * 4;
    printf("    Your array is:");
    for(int i = 0; i < length; i++){
        printf(" %d", array[i]);
    }
    printf("\n    Your array has %d elements", length);
    printf("\n    The size of the array is %d bytes", byteSize);
}

int part2(int array[]){
    printf("    Your array in reverse is:");
    for(int i = length - 1; i >= 0; i--){
        printf(" %d", array[i]);
    }
}

int part3(int array[]){
    int smallNum = array[0];
    for(int i = 0; i < length; i++){
        if(array[i] < smallNum){
            smallNum = array[i];
        }
    }
    
    printf("    The smallest value in your array is: %d", smallNum);
    
}

int part4(int array[]){
    int totalVal = 0;
    for(int i = 0; i < length; i++){
        totalVal += array[i];
    }
    
    printf("    The sum of all values in your array is %d", totalVal);
    
}

int part5(int array[]){
    printf("    Your array with first and last element switched is:");
    for(int i = 0; i < length; i++){
        
        if(i == 0){
            printf(" %d", array[length - 1]);
        }
        
        else if(i == length - 1){
            printf(" %d", array[0]);
        }
        
        else{
            printf(" %d", array[i]);
        }
    }
}

int part6(int array[]){
    int temp = 0;
    printf("    Your array in sorted order is:");
    
    int arrayCopy[length];
    
    for(int i = 0; i < length; i++){
        arrayCopy[i] = array[i];
    }

    for(int i = 0; i < length; i++){
        for(int j = i + 1; j < length; j++){
            if(arrayCopy[i] > arrayCopy[j]){
                temp = arrayCopy[i];
                arrayCopy[i] = arrayCopy[j];
                arrayCopy[j] = temp;
            }
        }
    }
    for(int d = 0; d < length; d++){
        printf(" %d", arrayCopy[d]);
    }
}

int main(){
    printf("Please enter your integers separated by spaces: ");
    
    int size;
    int arr[100000];
    
    char temp; 
    do { 
        scanf("%d%c", &arr[size], &temp); 
        size++;
    } 
    
    while(temp != '\n'); 
    
    int array[size];
    for(int e = 0; e < size; e++){
        array[e] = arr[e];
    }
    
    length = sizeof(array) / sizeof(array[0]);
    
    printf("\nPart 1: \n");
    int result1 = part1(array);
    printf("\n \n Part 2: \n");
    int result2 = part2(array);
    printf("\n \n Part 3: \n");
    int result3 = part3(array);
    printf("\n \n Part 4: \n");
    int result4 = part4(array);
    printf("\n \n Part 5: \n");
    int result5 = part5(array);
    printf("\n \n Part 6: \n");
    int result6 = part6(array);

    return 0;
}