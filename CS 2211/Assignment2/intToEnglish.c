//The name of this program is called "intToEnglish". THe purpose of the 
//program is to convert an int into english
//Ex: 345 == Three hundred fourty five
//My name is Sergio Rangel Camacho, I am the author of this program
//My student number is 251174481
//If you have any other qeustion please feel free to contact me, thanks
//My email is srangel@uwo.ca thanks!
#include <stdio.h>

int main(void){
    
    char result[90] = "";
	int flag = 0;
	int array[3];
	int num;
	
	for(int i = 0; i < 1000000; i++){
	    
	    printf("Please enter a value (1-999, 0 to quit): ");
	    scanf(" %d", &num);
	    
	    if(num == 0){
	        printf("You have exited the program. \n");
	        break;
	    }
	    
	    else if(num > 999 || num < 1){
	        printf("You entered an invalid number. \n");
	        continue;
	    }

	    for(int i = 2; i >= 0; i--){
	        array[i] = num % 10;
	        num /= 10;
	    }
	    printf("You entered: ");
	    
	    if(array[0] > 0){
	        
	        if(array[0] == 1){
	            printf("one hundred");
	        }
	        
	        else if(array[0] == 2){
	            printf("two hundred");
	        }
	        
	        else if(array[0] == 3){
	            printf("three hundred");
	        }
	        
	        else if(array[0] == 4){
	            printf("four hundred");
	        }
	        
	        else if(array[0] == 5){
	            printf("five hundred");
	        }
	        
	        else if(array[0] == 6){
	            printf("six hundred");
	        }
	        
	        else if(array[0] == 7){
	            printf("seven hundred");
	        }
	        
	        else if(array[0] == 8){
	            printf("eight hundred");
	        }
	        
	        else if(array[0] == 9){
	            printf("nine hundred");
	        }
	    }
	    
		if(array[1] > 0){
		    
		    if(array[1] == 1 && array[2] == 0){
				printf(" ten");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 1){
				printf(" eleven");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 2){
				printf(" twelve");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 3){
				printf(" thirteen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 4){
				printf(" fourteen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 5){
				printf(" fifteen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 6){
				printf(" sixteen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 7){
				printf(" seventeen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 8){
				printf(" eighteen");
				flag++;
			}

			else if(array[1] == 1 && array[2] == 9){
				printf(" nineteen");
				flag++;
			}
		    
		    else if(array[1] == 2){
		        printf(" twenty");
		    }
		    
		    else if(array[1] == 3){
		        printf(" thirty");
		    }
		    
		    else if(array[1] == 4){
		        printf(" fourty");
		    }
		    
		    else if(array[1] == 5){
		        printf(" fifty");
		    }
		    
		    else if(array[1] == 6){
		        printf(" sixty");
		    }
		    
		    else if(array[1] == 7){
		        printf(" seventy");
		    }
		    else if(array[1] == 8){
		        printf(" eighty");
		    }
		    else if(array[1] == 9){
		        printf(" ninety");
		    }
		    
		}
		
		if(array[2] > 0 && flag == 0){

			if(array[2] == 1){
				printf(" one");
			}

			else if(array[2] == 2){
				printf(" two");
			}

			else if(array[2] == 3){
				printf(" three");
			}

			else if(array[2] == 4){
				printf(" four");
			}

			else if(array[2] == 5){
				printf(" five");
			}

			else if(array[2] == 6){
				printf(" six");
			}

			else if(array[2] == 7){
				printf(" seven");
			}

			else if(array[2] == 8){
				printf(" eight");
			}

			else if(array[2] == 9){
				printf(" nine");
			}
		}
		printf(" \n");
		flag = 0;
	
	}
	return 0;
}