package firmatransportowa;

import java.util.List;

public class Vehicle extends Thread{


		private int fuel;
		private int fuelTank;
		private int vehicleID;

		public int getVehicleID() {
			return vehicleID;
		}
		public void setVehicleID(int vehicleID) {
			this.vehicleID = vehicleID;
		}
		public int getFuel() {
			return fuel;
		}
		public void setFuel(int fuel) {
			this.fuel = fuel;
		}
		public int getFuelTank() {
			return fuelTank;
		}
		public void setFuelTank(int fuelTank) {
			this.fuelTank = fuelTank;
		}

		public void setMaxFuel()
		{
			this.fuel = this.fuelTank;
		}
		
		
}
