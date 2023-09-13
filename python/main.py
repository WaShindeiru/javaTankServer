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

def forward():
        GPIO.output(5, 1)
        GPIO.output(6, 0)
        GPIO.output(13, 1)
        GPIO.output(19, 0)

def backwards():
        GPIO.output(5, 0)
        GPIO.output(6, 1)
        GPIO.output(13, 0)
        GPIO.output(19, 1)

def right():
        GPIO.output(13, 1)
        GPIO.output(19, 1)
        GPIO.output(5, 0)
        GPIO.output(6, 0)

def left():
        GPIO.output(5, 1)
        GPIO.output(6, 1)
        GPIO.output(13, 0)
        GPIO.output(19, 0)

def stop():
	for i in interface:
		GPIO.output(i, 0)

try:
        while(True):
                direction = input("")

                if direction == "1":
                        forward()

                elif direction == "2":
                        backwards()

                elif direction == "3":
                        right()

                elif direction == "4":
                        left()

                elif direction == "5":
                        stop()

                elif direction == "0":
                        for i in interface:
                                GPIO.output(i, 0)

                        GPIO.cleanup()

                        print("Quit!")
                        break


except KeyboardInterrupt:

        for i in interface:
                GPIO.output(i, 0)

        GPIO.cleanup()
        print("interrupted!")
