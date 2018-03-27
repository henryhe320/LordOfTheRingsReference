# LordOfTheRingsReference

Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from start point to existing treasure”

## Problem: 

Find a legal path from a starting point to treasure.

legal
 * no crossing walls
 * right-angle turns only
 * cannot go through same point twice

## Recursive abstraction: 

Finds a legal path from the position I ended up in my last step to the treasure.
