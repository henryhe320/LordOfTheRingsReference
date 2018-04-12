/**
  Returns a boolean for this statement: Returns the Boolean value of the statement “the maze is navigable, having a legal travel path that is continuous from explorer's current position to treasure”


 
 */

public class MazeSolver{
    
    Boolean navigable;
    Maze inProgress;
    Maze snapShot;

    public MazeSolver(String sourceFilename
		      , int explorerRank, int explorerFile){
	Maze inProgress = new Maze(sourceFilename, explorerRank, explorerFile);
	solver();
    }

//    public String toString(){
//        return (String)solver();
//    }

    public Boolean solver(){
        if (inProgress.explorerIsOnA() == inProgress.TREASURE)
            navigable = true;
        else{
            for(int i = 1; i < 9; i = i * 2){
                snapShot = new Maze(inProgress);
                inProgress.dropA(inProgress.WALL);
                inProgress.go(i);
                if(inProgress.explorerIsOnA() == inProgress.STEPPING_STONE){
                    solver();
                }
                inProgress = snapShot;
            }
        }
        return navigable;
    }
}
