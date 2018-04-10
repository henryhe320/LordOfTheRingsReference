# classes to support `MazeSolver`

Classes and their public members.

## `Maze`

Represent a maze with an explorer in it.

- `Maze(`*file name for maze*`, `*explorer position*`)` 
   constructor: read a maze from a file and position an explorer in it.

- copy constructor 

- `toString()`

- named constants for the directions an explorer can move

- `go(`*direction*`)`: move the explorer one step

- named constants for the maze elements

- `explorerIsOnA()` returns the maze element in 
the cell that the explorer currently occupies.
If the explorer has taken a step outside the maze, 
`explorerIsOnA` returns a wall element, as if there were a moat of wall elements
around the specified maze. Returning a wall should allow
the user-programmer's logic for wall elements
to handle attempts by the explorer to leave the maze.

- `dropA(`*maze element*`)`:  Modify the maze to have a *maze element* in 
the cell that the explorer currently occupies.

#### "undoing" a modification to a `Maze`
In general, a programmer using the `Maze` class
cannot undo an explorer move by moving it in the opposite direction.
Moving back will work for some specific situations, 
but it fails when the original move takes the explorer outside the 
maze. Since the explorer then has no position in the maze, it cannot be moved.

Instead, a user-programmer employs the restore-from-snapshot paradigm:

0. Before a modification that might need undoing, take a snapshot of a maze 
instance, using the `Maze` copy constructor. 

0. To undo the move, copy-construct another maze from the snapshot.

This make sense as long as you remember that a Java variable of a 
reference type holds a **reference** to an instance of that type.
For example, a variable of type `Maze` holds a reference to a `Maze` instance.
A program can assign the variable a different reference.
The variable then refers to a different instance.
For example...

```java
Maze candidate = new Maze(...
candidate.go(...  // Process the Maze that candidate refers to.

Maze snapshot = new Maze( candidate);

candidate.go(...  /* Modify the Maze that candidate refers to 
   without modifying the Maze that snapshot refers to. */

candidate = new Maze( snapshot);  /* "Undo" modifications by
   making candidate refer to a copy of the unmodified maze. */

candidate.go(...  // Process the maze in its form before modification.
```

## `Displayer`

Display a String of a few lines and pad them sufficiently
so that they take up an entire shell window. Pause until the person running the
program has assimilated the content.

Repeated invocations of the Displayer
with slightly-changed versions of the String will over-write previous displays, 
resulting in an approximation of animation.

## `UserOfMaze` 

Used in
[hw94](http://www.davidmholmes.net/Stuy/ap/hw.html#94) 
to learn and test `Maze` via incremental development.

Demo use of `Displayer`.


## implementation

A single maze is represented different ways in differing contexts.
 This is common in programming. For another example, recall the board in
[*n*-queens](https://github.com/stuyvesant-cs/libraryHolmes/tree/master/90_NQueensSolver),
which was represented in memory by a 1-D array of file numbers, but represented
in String form by a lines of `Q` and `_` characters.

Mazes use a third form, too: a representation in a text file, read as input
to the program.

### for input, represent a maze in a text file
- `0` means "treasure"
- `*` means "stepping stone"
- *space*, or anything else, means "wall"

See samples in the [mazes](mazes/) subdirectory.

### during program execution, represent a maze in memory

The `Maze` class represents a maze and explorer inside the program.

The user-programmer is expected to be able to use the `Maze` class
without changes. 
The user-programmer *can* modify their
copy of this class, but my solution works with the current form.

The `Maze` class contains an inner class called `Vector`, representing a 
[displacement](https://en.wikipedia.org/wiki/Displacement_(vector))
in the maze. 


### for debugging, represent a maze in a text string

`Maze.toString()` output resembles the input file. There are two differences:

##### borders
The `toString()` representation of a maze is bordered by lines,
so that the user can notice spaces.

>For example, for maze whose input is
```
0** 
```
has a hard-to-see space at the end of the line, indicating a wall element.
(Your browser will probably show the space if you select the text.)
The border that `toString()` produces makes the space more obvious:
```
------
|0** |
------
```

##### explorer on maze element

How can the output of `toString()` show that a cell contains both
a maze element and the explorer?

Answer: For such a cell, `toString()` shows a character that differs from
the element's representation in the input file:

- explorer on a stepping stone is shown as `e`, rather than `*`
- explorer on a wall element is shown as `E`, rather than *space*
- explorer on treasure is shown as `!`, rather than `0`

Using the maze above for example, starting an explorer in each of the cells
left-to-right would cause `toString()` to produce...
```
------
|!** |
------

------
|0e* |
------

------
|0*e |
------

------
|0**E|
------
```

An explorer that has stepped out of the maze has no location,
and so is not shown.
