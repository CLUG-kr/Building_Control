#include<stdio.h>

#include<wiringPi.h>

int main()

{

	int button;


   	if(wiringPiSetup()==-1) return -1;

	pinMode(27,OUTPUT);

	while(1)
	{
		scanf("%d",&button);
		if(button==1)
		{

      			digitalWrite(27,1);

     			delay(500);

		}
		else
		{
			digitalWrite(27,0);
			delay(500);
		}
	}

   	return 0;

}
