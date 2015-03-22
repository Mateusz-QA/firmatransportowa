package firmatransportowa;

public class GasStation {

	private int distanceToEnd;
	private int meanDistanceToEnd;
	/*public synchronized void getFuelForVehicle(Vehicle vehicle)
	{
		if (vehicle != null)
		{
			int vehicleFuel = vehicle.getFuel();
			int vehicleFuelTank = vehicle.getFuelTank();
			
			vehicle.setFuel(vehicleFuelTank - vehicleFuel);
			System.out.println("Vehicle "+vehicle.getId() + " get fuel form gas station : "+ vehicleFuel + "/" + vehicleFuelTank);
			
		}
		
	}*/
	
	public int getDistanceToEnd()
	{
		return distanceToEnd;
	}

	public void setDistanceToEnd(int distanceToEnd) {
		this.distanceToEnd = distanceToEnd;
	}

	public int getMeanDistanceToEnd() {
		return meanDistanceToEnd;
	}

	public void setMeanDistanceToEnd(int meanDistanceToEnd) {
		this.meanDistanceToEnd = meanDistanceToEnd;
	}
	
	
}
