package tron2d;

/**
 *
 * @author Tuna Uygun
 */
public class Player {
    //public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public int playerPointsX[] = new int[1250];
    public int playerPointsY[] = new int[1250];
    public boolean alive = true;
    public boolean leftDirection = false;
    public boolean rightDirection = false;
    public boolean upDirection = false;
    public boolean downDirection = true;
    public int length = 1;
    
    
    public Player(int initX, int initY){
        playerPointsX[0] = initX;
        playerPointsY[0] = initY; 
    }
        
    public void move() {
        if (leftDirection) {
            playerPointsX[length] =  playerPointsX[length-1] - GameBoard.gridSize;
            playerPointsY[length] =  playerPointsY[length-1];
            length += 1;
        } else if (rightDirection) {
            playerPointsX[length] =  playerPointsX[length-1] + GameBoard.gridSize;
            playerPointsY[length] =  playerPointsY[length-1];
            length += 1;
        }else if (upDirection) {
            playerPointsY[length] =  playerPointsY[length-1] - GameBoard.gridSize;
            playerPointsX[length] =  playerPointsX[length-1];
            length += 1;
        }else if (downDirection) {
            playerPointsY[length] =  playerPointsY[length-1] + GameBoard.gridSize;
            playerPointsX[length] =  playerPointsX[length-1];
            length += 1;
        }else{
            System.out.println("Direction Error: All Directions are set to false");
        }
    }
    
    public void checkInternalCollision() {
        for (int i = length-2; i>0; i--) {
            if ((playerPointsX[length-1] == playerPointsX[1]) && (playerPointsY[length-1] == playerPointsY[1])) {
                alive = false;
                System.out.println("D1");
            }
        }

        if (playerPointsY[length-1] >= GameBoard.boardWidth) {
            alive = false;
        } else if (playerPointsY[length-1] < 0) {
            alive = false;
        } else if (playerPointsX[length-1] >= GameBoard.boardWidth) {
            alive = false;
        } else if (playerPointsX[length-1] < 0 && playerPointsX[length-1] != -100 && playerPointsX[length-1] != -200) {
            alive = false;
        } else{
            alive = true; 
        }
    }
    

}
