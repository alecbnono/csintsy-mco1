package solver;

import java.util.HashSet;

public class GameState {
    /*
     * States Needed for the Game State:
     * 1. Player Position using Point probably use a class for points
     * 2. Box Position use a Hashset for uniqueness
     * 3. Goal Position as well with Hashset uniqueness
     * 4. Char move. ex: up = u, down = d, left = l, right = r
     */

    /*
     * Algorithm Plans to use:
     * 1. IDA*
     */

    private Point playerPosition;
    private HashSet<Point> boxPosition;
    private HashSet<Point> goalPosition;
    private GameState parent; // to backtrack the solution after knowing if its solvable
    private int cost; // g(n)
    private char validMove;

    public GameState(Point playerPosition, HashSet<Point> boxPosition, HashSet<Point> goalPosition, char validMove,
            GameState parent) {
        this.playerPosition = playerPosition;
        this.boxPosition = boxPosition;
        this.goalPosition = goalPosition;
        this.validMove = validMove;
        this.parent = parent;
        this.cost = (parent == null) ? 0 : parent.cost + 1;
    }

    public Point getPlayerPosition() {
        return playerPosition;
    }

    public HashSet<Point> getBoxLocations() {
        return this.boxPosition;
    }

    public char getValidMode() {
        return validMove;
    }

    // public boolean isValidAction(char direction) {

    // }

    // public String validActions() {

    // // Start out with 4 moves (up, down, left, right)
    // //
    // // Check if already explored based on coords
    // // (use hashmap to stored visited states)
    // //
    // // Check validity of action
    // //
    // // 1. Do I move into a wall? POP IF YES
    // // 2. Do I push a box? -> Is the box infront of a wall or another box? POP IF
    // // YES
    // // If NO to both questions -> VALID ACTION

    // }

    // public boolean isGoalState() {

    // }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(playerPosition, boxPosition, goalPosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof GameState))
            return false;

        GameState other = (GameState) obj;

        return playerPosition.equals(other.playerPosition) && boxPosition.equals(other.boxPosition)
                && goalPosition.equals(other.goalPosition);

    }

}
