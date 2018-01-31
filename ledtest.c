#include<stdio.h>

#include<wiringPi.h>

int main()

{

	int button;


   	if(wiringPiSetup()==-1) return -1;

	pinMode(29,OUTPUT);

	while(1)
	{
		scanf("%d",&button);
		if(button==1)
		{

      			digitalWrite(29,1);

     			delay(500);

		}
		else
		{
			digitalWrite(29,0);
			delay(500);
		}
	}

   	return 0;

}
