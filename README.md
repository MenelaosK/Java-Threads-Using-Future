# Java-Threads-Using-Future
A program using the java.util.concurrent.Future package 

This example simulates how to slice big calculations in parts that are calculated by threads.
These threads return their results using Java futures and conclude the overall calculation.
This example tries to calculate pi. It takes into consideration the available cores of the system and
has a number of steps, which determines how accurate the calculation will be. The calculation is sliced and
each thread take and calculates each own part and returns the result. All the results are added to create the overall result.
The result is compared with the pi from math.PI.Due to the small number of steps the result in the image below is not very accurate.


![alt text](https://github.com/MenelaosK/Java-Threads-Using-Future/blob/master/pi.png)
