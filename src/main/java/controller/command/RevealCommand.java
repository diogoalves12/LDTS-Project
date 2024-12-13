package controller.command;

import model.Position;
import model.game.Game;

public class RevealCommand extends GameCommand{
    private final int row;
    private final int col;

    public RevealCommand(Game game, int row, int col) {
        super(game);
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {

        game.getBoard().getCell(new Position(row,col)).reveal();          //yet to be implemented
    }

}
