package controller.command;

import model.Position;
import model.game.Game;

public class FlagCommand extends GameCommand {
    private final int row;
    private final int col;

    public FlagCommand(Game game, int row, int col) {
        super(game);
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        game.getBoard().getCell(new Position(row,col)).flag();
    }
}
