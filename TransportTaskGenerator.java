package firmatransportowa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransportTaskGenerator extends Thread {

	
	private TransportCompany transportCompany;
	private List <Integer> receiverList;
	private List <Integer> giverCount;
	
	

	
	
	
	


	public TransportTaskGenerator(TransportCompany transportCompany,
			List<Integer> receiverList, List<Integer> giverCount) {
		super();
		this.transportCompany = transportCompany;
		this.receiverList = receiverList;
		this.giverCount = giverCount;
	}




	public void run()
	{
		while (true)
		{
			transportCompany.addTransportTask(generateTransportTask(getRandomFromList(giverCount),getRandomFromList(receiverList)));
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}


	public int getRandomFromList(List <Integer> list)
	{
		Random random = new Random();
		return random.nextInt(list.size()-1);
		
	}



	public TransportTask generateTransportTask(int fromId,int toId)
	{

		TransportTask transportTask = new TransportTask();
		transportTask.setFromID(fromId);
		transportTask.setToID(toId);
		
		///generate distance between 100 and 1000 km
		int distance = getRandomInt(100,1000);

		//generate gas stations count between 1 and 10
		int gasStationsCount = getRandomInt(2,10);

		
		List <GasStation> gasStationList = new ArrayList<GasStation>();
		
		int currentDistance = distance;
		
		while(true)
		{
			GasStation gasStation = new GasStation();
			currentDistance = currentDistance- distance/gasStationsCount;

			
			if (currentDistance >= 0)
			{
				gasStation.setDistanceToEnd(currentDistance);
				gasStation.setMeanDistanceToEnd(distance/gasStationsCount);
				gasStationList.add(gasStation);
				
				
			}
			else break;
		}
		
		transportTask.setGasStationList(gasStationList);
		transportTask.setDistance(distance);
		
		return transportTask;
		
		
	}
	
	public int getRandomInt(int min,int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	
}
