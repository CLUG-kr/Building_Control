#include<stdio.h>
#include<wiringPi.h>
#include<softPwm.h>

#define SERVO 1

int main()
{
	int num;

	if(wiringPiSetup()==-1)
		return 1;

	softPwmCreate(SERVO,0,200);

	scanf("%d", &num);

	if(num==1){
		softPwmWrite(SERVO,22);
		delay(300);
		softPwmWrite(SERVO,15);
		delay(300);
		softPwmWrite(SERVO,30);
		delay(300);
		softPwmWrite(SERVO,15);
		delay(300);
		softPwmWrite(SERVO,30);
		delay(300);
		softPwmWrite(SERVO,15);
		delay(300);
		softPwmWrite(SERVO,30);
		delay(300);
		softPwmWrite(SERVO,22);
		delay(500);
	}
	else return 0;


	return 0;
}
