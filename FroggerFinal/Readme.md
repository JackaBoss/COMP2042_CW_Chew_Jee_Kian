# CW Software Maintenance Spec Sheet
# Frogger game SoftWare Maintainence
### Chew Jee Kian 
### 10346178

## Main.Java
+ Moved into a package called application
+ Resized the frogger background map to fit the aspect ratio better.
+ Moved the end goals into the correct position on the frogger background
+ Renamed some values to be more readable or makes more sense. 
+ Replacced and modified so that a string will contain the location of common obstacles and platforms for the player to stand on  *(the logs the player stands on and the floating turtles)*

## GoalState.java
+ Moved into a package called application
+ Used to be named End.java

## ScoreDisplay.java
+ Moved into a package called application
+ Used to be named Digit.java

## World.java
+ Moved into a package called application

## MyStage.java
+ Moved into a package called application

## Actor.java
+ Moved into a package called actors

## BackgroundImage.java
+ Moved into a package called actors
+ Renamed w and h to width and height for easier understanding

## Obstacle.java
+ Moved into a package called actors

## Player.java
+ Moved into a package called actors
+ Used to be named Animal.java
+ Renamed some values to be more understanding

#### Example:

        Image imgW1;

            to

        Image ImageFront;

## Turtle.java
+ Moved into a package called actors
+ Renamed some values to be more understanding

## WetTurtle.java
+ Moved into a package called actors
+ Renamed some values to be more understanding










