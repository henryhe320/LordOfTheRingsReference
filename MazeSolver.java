/**
  Returns a boolean for this statement: Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from explorer's current position to treasure”


 
 */

public class MazeSolver{
    
    private static Boolean navigable;

//    public MazeSolver(String sourceFilename
//		      , int explorerRank, int explorerFile){
//	Maze inProgress = new Maze(sourceFilename, explorerRank, explorerFile);
//	solver();
//    }

//    public String toString(){
//        return (String)solver();
//    }

    public static Boolean solver(Maze inProgress){
        if (inProgress.explorerIsOnA() == inProgress.TREASURE)
            navigable = true;
        else if (inProgress.explorerIsOnA() == inProgress.WALL)
            navigable = false;
        else{
            Maze snapShot = new Maze(inProgress);
            for(int i = 1; i < 9; i = i * 2){
                inProgress.dropA(inProgress.WALL);
                inProgress.go(i);
                if(inProgress.explorerIsOnA() == inProgress.STEPPING_STONE){
                    System.out.println("step successful");
                    solver(inProgress);
                }
                inProgress = snapShot;
            }
        }
        return navigable;
    }
}
