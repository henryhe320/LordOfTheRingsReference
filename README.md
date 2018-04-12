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

for each direction (N, E, S, W, in that order):
 * take a step in that direction and if the step is legal, call the recursive abstraction
 * if the step is not legal, take a step back (restore snapshot)
 * Recursive backtracking tries the following directions (should do this even if previous step isLegal)
 
## class(es), with fields and methods
 * Class: Solver
 * inProgress Maze Field
 * snapShot Maze Field
 * solver Method
 * toString()


 * Class:Maze
 * 2D Maze Array
 * advance method (i.e go)
 * backtrack method (i.e copyconstructor and restoration of a snapshot)
 * toString method
## version *n* wish list

 * display actual path
 * perhaps find multiple solutions

## known bugs
