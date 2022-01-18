import java.util.ArrayList;
import java.util.List;

public class BattleShipLogic {

	public static BattleShipLogic instance= null;
	
	private BattleShipController controller;
	
	public static BattleShipLogic getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new BattleShipLogic();
		}
		return instance;
	}
	
	public static BattleShipLogic getInstance(BattleShipController controller) {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new BattleShipLogic();
			instance.controller = controller;
		}
		return instance;
	}
	
	

	public int toss() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setShipPlacements(List<ShipPlacement> ships) throws InvalidShipPlacementException {
		// TODO Auto-generated method stub
		
		//this.controller.updateMyField(gridData);
	}


	public GridStatus[][] getGridData(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BattleShipController getGuiController() {
		return this.controller;
	}

	public void fire(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
