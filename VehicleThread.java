package firmatransportowa;

import java.util.List;

public class VehicleThread extends Thread {
	
	private TransportCompany transportCompany;
	private Vehicle vehicle;
	private TransportTask currentTransportTask;

	public VehicleThread(TransportCompany transportCompany,Vehicle vehicle) {

		
		this.transportCompany = transportCompany;
		this.vehicle = vehicle;
		System.out.println("Vehicle "+vehicle.getId() + " started!" + " (Fuel: "+ vehicle.getFuel() + "L)");
	}



	public void sleep()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		while (true)
		{
			if (currentTransportTask == null)
			{
				TransportTask task = transportCompany.lookForTask(vehicle);
				if (task == null)
				{
					System.out.println("No job for : " + this.vehicle.getName());
					sleep();
					
				}
				else
				{
					System.out.println("Job received!" + this.vehicle.getName());
					currentTransportTask = task;
					runTransport();
					sleep();
				}
			}
		}
	}
	
	
	public void runTransport()
	{
		int currentStation = 0;
		List <GasStation> gasStationList = currentTransportTask.getGasStationList();
		int distanceBetweenStations = gasStationList.get(0).getMeanDistanceToEnd();
		
		while (true)
		{
			if (currentStation < gasStationList.size())
			{
			System.out.println("FUEL IN: "+ vehicle.getFuel());
			
			if (vehicle.getFuel() > distanceBetweenStations)
			{
				System.out.println("Skip current station: "+ currentStation);
				
			}
			else
			{
				vehicle.setMaxFuel();
				System.out.println("Tanked in current station" + currentStation);
			}
			
			System.out.println("DIS:"+distanceBetweenStations);
			vehicle.setFuel(vehicle.getFuel() - distanceBetweenStations);
			
			System.out.println("FUEL OUT: "+ vehicle.getFuel());
			
			currentStation++;
		
			sleep();
			
			}
			else
			{
				currentTransportTask = null;
				break;
			}
			
		}
		
		
	}
	

}
