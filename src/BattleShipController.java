import java.util.List;

public interface BattleShipController {
	void updateMyField(GridStatus[][] gridData);
	void updateRivalField(GridStatus[][] gridData);
	void gameFinished(int who); // 0 for people win, 1 for computer win.
}
