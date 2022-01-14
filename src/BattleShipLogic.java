import java.util.ArrayList;

public class BattleShipLogic {

	public static BattleShipLogic instance= null;
	
	public static BattleShipLogic getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new BattleShipLogic();
		}
		return instance;
	}

	public int toss() {
		// TODO Auto-generated method stub
		return 0;
	}

	public HitStatus computerPlay() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setShipPlacements(ArrayList<ShipPlacement> ships) throws InvalidShipPlacementException {
		// TODO Auto-generated method stub
		
	}

}
