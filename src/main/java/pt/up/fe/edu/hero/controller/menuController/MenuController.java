package pt.up.fe.edu.hero.controller.menuController;

import pt.up.fe.edu.hero.MainGame;
import pt.up.fe.edu.hero.controller.Controller;
import pt.up.fe.edu.hero.gui.GUI;
import pt.up.fe.edu.hero.model.menu.LevelSelect;
import pt.up.fe.edu.hero.model.menu.Menu;
import pt.up.fe.edu.hero.state.MenuState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu){super(menu);}
    @Override
    public void step(MainGame game, GUI gui, long time) throws IOException{
        switch (gui.getNextAction()){
            case UP : getModel().previousEntry();
                break;
            case DOWN : getModel().nextEntry();
                break;
            case SELECT :
                if (getModel().isSelected(2)) game.setState(null);
                if(getModel().isSelected(0)) game.setState(new MenuState(new LevelSelect()));


        }
    }
}
