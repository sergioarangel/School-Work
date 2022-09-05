    //The name of this program is called "Converter". The purpose of the
    //program is to converter a value from one unit to another.
    //Some examples include: Miles to Kilometre, Litre to Gallon,...
    //My name is Sergio Rangel Camacho, and I am the author of this program
    //My student number is 251174481
    //If you have any other questions please feel free to contact me at any time
    //My email is srangel@uwo.ca thanks
    
    #include <stdio.h>

	int main(void){
		
		int input = 0;
		char type;
		float amount;
		float conversion;
		
		for(int i = 0; i < 100000; i++){
    
            printf("Please enter the integer corresponding");
		    printf(" with the conversion you would like to make: \n");
		    printf("- (1) for conversion between Kilometre and Mile \n");
		    printf("- (2) for conversion between Litres and Gallons\n");
		    printf("- (3) for conversion between Hectares and Acres\n");
		    printf("- (4) for conversion between Kilograms and Pounds\n");
		    printf("- (5) for quit\n");
		    scanf(" %d", &input);

			if(input == 1){
				printf("Please enter the Character corresponding with the conversion type you would like to make: \n");
				printf("- (K) for conversion from Kilometre to Mile \n");
				printf("- (M) for conversion from Mile to Kilometre\n");
				scanf(" %c", &type);
				if(type == 'K' || type == 'k'){
				    printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount * 0.621371;
					printf("%f Kilometre(s) == %f Mile(s)\n", amount, conversion);
			    	}
				
				else if(type == 'M' || type == 'm'){
				    printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount / 0.621371;
					printf("%f Mile(s) == %f Kilometre(s)\n", amount, conversion);
				}
            
				else{
					printf("Invalid input. Please try again.\n");
				}
			    	
			}
			else if(input == 2){
			    printf("Please enter the Character corresponding with the conversion type you would like to make: \n");
				printf("- (L) for conversion from Litres to Gallons \n");
				printf("- (G) for conversion from Gallons to Litres\n");
				scanf(" %c", &type);
				
				if(type == 'L' || type == 'l'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount * 0.264172;
					printf("%f Litre(s) == %f Gallon(s)\n", amount, conversion);
				}
				
				else if(type == 'G' || type == 'g'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount / 0.264172;
					printf("%f Gallon(s) == %f Litre(s)\n", amount, conversion);
				}
				
				else{
					printf("Invalid input. Please try again.\n");
				}
					
			}
			else if(input == 3){

				printf("Please enter the Character corresponding with the conversion type you would like to make: \n");
				printf("- (H) for conversion from Hectares to Acres \n");
				printf("- (A) for conversion from Acres to Hectares\n");
				scanf(" %c", &type);

				if(type == 'H' || type == 'h'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount * 2.47105;
					printf("%f Hectare(s) == %f Acre(s)\n", amount, conversion);
				}
				
				else if(type == 'A' || type == 'a'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount / 2.47105;
					printf("%f Acre(s) == %f Hectare(s)\n", amount, conversion);
				}
				
				else{
					printf("Invalid input. Please try again.\n");
				}
			}
			else if(input == 4){
				printf("Please enter the Character corresponding with the conversion type you would like to make: \n");
				printf("- (K) for conversion from Kilograms to Pounds \n");
				printf("- (P) for conversion from Pounds to Kilograms\n");
				scanf(" %c", &type);

				if(type == 'K' || type == 'k'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount * 2.20462;
					printf("%f Kilogram(s) == %f Pound(s)\n", amount, conversion);
				}
				
				else if(type == 'P' || type == 'p'){
					printf("Please enter the value of the conversion.\n");
					scanf(" %f", &amount);
					conversion = amount / 2.20462;
					printf("%f Pound(s) == %f Kilogram(s)\n", amount, conversion);
				}
				
				else{
					printf("Invalid input. Please try again.\n");
				}
			}
			
			else if(input == 5){
				break;
			}
			
			else{
			    printf("Invalid input. Please try again.");
			}

	}

		return 0;
	}


