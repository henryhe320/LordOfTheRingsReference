# LordOfTheRingsReference

Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from start point to existing treasure”

## personnel
Henry He and Xiaoke Luo

## statement of problem

Find a legal travel path from a starting point to treasure.

legal
 * no crossing walls
 * right-angle turns only
 * cannot go through same point twice

## recursive abstraction

Finds a legal path from the position I ended up in my last step to the treasure.

## base case

If the current position is at the treasure, there is a solution

## english or pseudocode description of algorithm

for each direction (up, right, down, left, in that order):
 * if the next step in that direction is legal, take a step in that direction and call the recursive abstraction
 * take a step back
 * Recursive backtracking tries the following directions (should not do this if previous step isLegal)
 * Should not take a step in the opposite direction if legal.
 
## class(es), with fields and methods
 * Class: Solver
 * Maze Field
 * An Arraylist of Maze Field
 * SolutionFinderForMaze Method


 * Class:Maze
 * BlockedYcor Array Field
 * BlockedXcor Array Field
 * VerticalDistanceTraveled or ycor Field
 * HorizontalDistanceTravelel or xcor Field
 * advance method
 * backtrack method
 * isValid Method
 * treasureReached method
 * toString method
## version *n* wish list
