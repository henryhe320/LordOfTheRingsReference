/**
  Test MazeSolver class.

  G
  o  the name of a file containing a maze.
  o  the rank and file where an explorer is starting

 
       java UserOfMazeSolver mazes/4cell_treasureWest.txt 0 0  # at treasure
 
       java UserOfMazeSolver mazes/4cell_treasureWest.txt -1 -1  # inside wall
 
       java UserOfMazeSolver mazes/4cell_treasureWest.txt 0 1  # one step from treasure
 
       java UserOfMazeSolver mazes/intersection_treasureNorth.txt 1 0  # choice to make
 
       java UserOfMazeSolver mazes/intersection_treasureNorth.txt 0 0  # dropped on a wall that's inside the maze

 */

public class UserOfMazeSolver {
     private static Displayer displayer = new Displayer(24);

    public static void main(String[] commandLine)
       throws java.io.FileNotFoundException {
        System.out.println();

        Maze test = new Maze( commandLine[0]
                            , Integer.parseInt( commandLine[1])
                            , Integer.parseInt( commandLine[2])
                            );
        
        MazeSolver testSolve =  new MazeSolver(test);
           
           displayer.atTopOfWindow(test + "step ");
        
//           testSolve.solver();
           

        if (testSolve.solver()){
            System.out.println("maze has a solution");
        } else {
            System.out.println("maze has no solution");
        }
           
           
    }



}
