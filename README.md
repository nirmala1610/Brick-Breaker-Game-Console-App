## Brick Breaker – Console Based Java Application
## Project Overview

The Brick Breaker Console Application is a simple Java-based game simulation implemented using arrays and Java collections.
The game is played on a 7×7 grid, where the player controls the direction of a ball to break bricks.

Each brick has a strength value representing the number of hits required to destroy it. When the ball hits a brick, its strength decreases by 1, and the brick disappears once the strength reaches 0.

The player starts with 5 balls (lives). The objective is to destroy all bricks before running out of balls.

## Technologies Used

    Java
    
    Java Collections Framework
    
    HashMap
    
    2D Arrays
    
    Console Input/Output
    
    Eclipse IDE

## Game Board Structure

The game board is represented using a 7 × 7 2D array.

Symbols Used
Symbol	Meaning
W	Wall surrounding the game area
g	Ground
o	Ball starting position
1,2,3...	Brick strength
(space)	Empty space
Initial Game Grid
W W W W W W W
W           W
W   1 1 1   W
W   1 1 1   W
W           W
W           W
W g g o g g W
Initial Conditions

Grid Size: 7 × 7

Number of Bricks: 6

Brick Positions:

(2,2)

(2,3)

(2,4)

(3,2)

(3,3)

(3,4)

Ball Lives: 5

Ball Movement Commands

The user controls the ball using three commands:

Command	Direction
St	Straight Up
Lt	Left Diagonal
Rt	Right Diagonal
Example
Enter Command (St, Lt, Rt)
Lt

The ball moves in the chosen direction until it hits:

A brick

A wall

The top boundary

Brick Mechanics

Each brick has a strength value.

## Example:

1 → destroyed in 1 hit
2 → destroyed in 2 hits
3 → destroyed in 3 hits

When the ball hits a brick:

brick strength = brick strength - 1

If strength becomes 0, the brick is removed from the grid.

## Game Flow

Game board is initialized.

Bricks are placed in the grid.

Player enters a movement command.

Ball moves in the specified direction.

If the ball hits a brick:

Brick strength decreases.

Ball count decreases after each move.

The game continues until:

All bricks are destroyed (Player Wins), or

Ball lives reach 0 (Game Over).

Program Structure

The project mainly consists of a Service Class.

BrickBreakerService

This class contains all the game logic.

## Main Methods:

    Method	Description
    initializeBoard()	Creates the grid and places walls, ground, ball, and bricks
    addBrick()	Adds bricks and stores strength using HashMap
    printGrid()	Displays the current game board
    moveBall()	Handles ball movement and collision detection
    hitBrick()	Reduces brick strength when hit
    startGame()	Controls the game loop


## Example Entry:

"2,3" → 1

This helps quickly check if a brick exists at a position and update its strength.

Winning Condition
All bricks destroyed

Output:

You Win !!!
Losing Condition
Ball count becomes 0

Output:

Game Over

## Screenshots

<img width="967" height="706" alt="image" src="https://github.com/user-attachments/assets/682b067d-4a25-47ca-a0ff-facfa5eccbc1" />


<img width="1116" height="600" alt="image" src="https://github.com/user-attachments/assets/a7fb1b63-fd21-48b1-b47c-15e7d6f1d612" />

