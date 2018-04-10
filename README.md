# LordOfTheRingsReference

Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from explorer's current position to treasure”

## personnel
Henry He and Xiaoke Luo

## statement of problem

Find a legal travel path from a starting point to treasure.

legal
 * no crossing walls
 * right-angle turns only
 * cannot go through same point twice

## recursive abstraction

When we are asked to determine if there is a legal travel path from explorer's current position to treasure, the recursive abstraction can determine if there is a legal travel path from explorer's current position to treasure after I take a legal step"

## base case

If the current position is at the treasure, return true
If the current position is at a wall return false

## english or pseudocode description of algorithm

for each direction (up, right, down, left, in that order):
 * if the next step in that direction is legal, take a step in that direction and call the recursive abstraction
 * if path in that direction doesn't work, take a step back
 * Recursive backtracking tries the following directions (should do this even if previous step isLegal)
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
