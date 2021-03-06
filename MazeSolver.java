/**
  Returns a boolean for this statement: Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from explorer's current position to treasure”


 
 */

public class MazeSolver{
    
    //private static Boolean navigable;
    
    private static Maze inProgress;
    
    private static int[] directions;
  
    private static int stepsTaken = 0;

    public MazeSolver(Maze maze){
        inProgress = new Maze(maze);
        directions = new int[] {Maze.NORTH, Maze.EAST, Maze.SOUTH, Maze.WEST};
    }

    public static Boolean solver(){
//        System.out.println( inProgress.explorerIsOnA());
//        return inProgress.explorerIsOnA() == Maze.TREASURE;
        
        if (inProgress.explorerIsOnA() == Maze.TREASURE)
            return true;
        else if (inProgress.explorerIsOnA() == Maze.WALL)
            return false;
        else{
            for(int dir: directions) {
                Maze snapshot = new Maze(inProgress);
                inProgress.dropA(inProgress.WALL);
                inProgress.go(dir);
                stepsTaken++;
                if (solver())
                    return true;
                else {inProgress = snapshot;
                      stepsTaken--;
                     }
                }
           return false;
            }
    }
  
   public static int stepsTaken(){
       if (solver())
           return stepsTaken;
       else return -1;
     
   }
       
    
}
