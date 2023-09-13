import requests
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)

power = (26, 16)
interface = (19, 13, 6, 5)

for i in power:
        GPIO.setup(i, GPIO.OUT)
        GPIO.output(i, 1)

for i in interface:
        GPIO.setup(i, GPIO.OUT)
        GPIO.output(i, 0)

# 5 - prawo przód
# 19 - prawo tył
# 13 - lewo przód
# 6 - lewo tył

def leftMotor(value):
    if value == 0:
        GPIO.output(13, 0)
        GPIO.output(6, 0)

    elif(value) > 0:
        GPIO.output(13, 1)
        GPIO.output(6, 0)

    else:
        GPIO.output(13, 0)
        GPIO.output(6, 1)

def rightMotor(value):
    if(value == 0):
        GPIO.output(5, 0)
        GPIO.output(19, 0)

    elif value > 0:
        GPIO.output(5, 1)
        GPIO.output(19, 0)

    else:
        GPIO.output(5, 0)
        GPIO.output(19, 1)

try:
    while(True):
        
        response = requests.get("http://localhost:8080/tank")
        json = response.json()

        if response.status_code == 204:
            continue

        elif response.status_code == 200:
            left = json['left']
            right = json['right']
            leftMotor(left)
            rightMotor(right)

        # elif direction == "0":
        #     for i in interface:
        #             GPIO.output(i, 0)

        #     GPIO.cleanup()

        #     print("Quit!")
        #     break


except KeyboardInterrupt:

        for i in interface:
                GPIO.output(i, 0)

        GPIO.cleanup()
        print("interrupted!")
