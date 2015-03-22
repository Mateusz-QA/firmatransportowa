package firmatransportowa;

import java.util.List;

public class TransportTask {
	
	private int fromID;
	private int toID;
	private int distance;
	private List <GasStation> gasStationList;
	
	
	public int getFromID() {
		return fromID;
	}
	public void setFromID(int fromID) {
		this.fromID = fromID;
	}
	public int getToID() {
		return toID;
	}
	public void setToID(int toID) {
		this.toID = toID;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<GasStation> getGasStationList() {
		return gasStationList;
	}
	public void setGasStationList(List<GasStation> gasStationList) {
		this.gasStationList = gasStationList;
	}
	
	public String toString()
	{
		return "Task: from: "+fromID + " to: " + toID + " distance: "+ distance + " gas stations: "+gasStationList.size();
		
	}

}
