package controller.command;

import model.game.Game;

public abstract class GameCommand extends Command{
    protected final Game game;

    public GameCommand(Game game) {
        super(game);
        this.game = game;
    }

    @Override
    public abstract void execute();


}
