/**
  Test MazeSolver class.

  G
  o  the name of a file containing a maze.
  o  the rank and file where an explorer is starting

 
       java UserOfMazeSolver 94_MazeSolverSupport/mazes/4cell_treasureWest.txt 0 0  # at treasure
 
       java UserOfMazeSolver 94_MazeSolverSupport/mazes/4cell_treasureWest.txt -1 -1  # inside wall
 
       java UserOfMazeSolver 94_MazeSolverSupport/mazes/4cell_treasureWest.txt 0 1  # one step from treasure
 
       java UserOfMazeSolver 94_MazeSolverSupport/mazes/intersection_treasureNorth.txt 1 0  # choice to make
 */

public class UserOfMazeSolver {
    private static Displayer displayer;

    public static void main(String[] commandLine)
       throws java.io.FileNotFoundException {
        System.out.println();

        MazeSolver test = new MazeSolver( commandLine[0]
                            , Integer.parseInt( commandLine[1])
                            , Integer.parseInt( commandLine[2])
                            );
       if (test.solver()){
           System.out.println("maze has a solution");
       } else {
           System.out.println("maze has no solution");
       }
           
           
    }



}
