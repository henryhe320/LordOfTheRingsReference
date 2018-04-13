/**
  Returns a boolean for this statement: Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from explorer's current position to treasure”


 
 */

public class MazeSolver{
    
    //private static Boolean navigable;
    
    private Maze inProgress;
    
    private int[] directions;

    public MazeSolver(Maze maze){
        Maze inProgress = new Maze(maze);
        directions = new int[] {Maze.NORTH, Maze.EAST, Maze.SOUTH, Maze.WEST};
    }

    public static Boolean solver(){
        if (inProgress.explorerIsOnA() == Maze.TREASURE)
            return true;
        else if (inProgress.explorerIsOnA() == Maze.WALL)
            return false;
        else{
            Maze snapshot = new Maze(inProgress);
            for(int dir: directions) {
                inProgress.dropA(inProgress.WALL);
                inProgress.go(dir);
                if (inProgress.explorerIsOnA() == Maze.STEPPING_STONE){
//                    System.out.println("step successful");
                    return solver();
                }
                inProgress = snapshot;
            }
        }
    }
}
