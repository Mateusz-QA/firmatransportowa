package firmatransportowa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransportCompany {

	private List <Vehicle> vehicleList;
	private List <VehicleThread> vehicleThreadList;
	private List <Integer> receiverList;
	private List <Integer> giverList;
	private List <TransportTask> transportTaskList;
	
	public TransportCompany(int vehicles, int maxFuelInFuelTank,int receiverCount, int giverCount)
	{
		createVehicles(vehicles,maxFuelInFuelTank);
		createVehiclesThreads(vehicleList);
		createGiverList(giverCount);
		createReceiverList(receiverCount);
		transportTaskList = new ArrayList<TransportTask>();
		TransportTaskGenerator generator = new TransportTaskGenerator(this,receiverList,giverList);
		generator.start();
		
		runVehicles();
		
	
	}
	
	
	private void runVehicles() {
		
		for (VehicleThread vehicleThread: vehicleThreadList)
		{
			vehicleThread.start();
		}
		
		
	}


	private void createVehiclesThreads(List<Vehicle> vehicleList) {
		this.vehicleThreadList = new ArrayList<VehicleThread>();
		for (Vehicle vehicle: vehicleList)
		{
			vehicleThreadList.add(new VehicleThread(this,vehicle));
		}

		
	}


	private void createReceiverList(int receiverCount) {
		this.receiverList = new ArrayList<Integer>();
		
		for (int i = 0; i<receiverCount ;i++)
		{
			receiverList.add(i);
		}
		
		
	}


	private void createGiverList(int giverCount) {
		this.giverList = new ArrayList<Integer>();
		for (int k=0;k<giverCount;k++)
		{
			giverList.add(k);
		}
		
	}


	public synchronized void addTransportTask(TransportTask task)
	{
		System.out.println("New task: \n\t" + task);
		transportTaskList.add(task);
		
	}
	
	
	
	

	
	
	public void createVehicles(int vehicles,int maxFuelInFuelTank)
	{
		vehicleList = new ArrayList<Vehicle>();
		for (int i=0;i<vehicles;i++)
		{
			Vehicle vehicle = new Vehicle();

			int maxFuel = getRandomInt(10,maxFuelInFuelTank);
			
			vehicle.setFuel(maxFuel);
			vehicle.setFuelTank(maxFuel);
			vehicle.setVehicleID(i);
			
			vehicleList.add(vehicle);
		}
	}
	
	
	public int getRandomInt(int min,int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	
	public synchronized TransportTask lookForTask(Vehicle vehicle)
	{

			for (int i=0;i<transportTaskList.size();i++)
			{
				TransportTask task = transportTaskList.get(i);
				int distanceBetweenGasStations = task.getGasStationList().get(0).getMeanDistanceToEnd();
				
				
				
				if (vehicle.getFuelTank()> distanceBetweenGasStations)
				{
					return transportTaskList.remove(i);
					
				}
				
			}
			return null;

	
	}
	
	
}
