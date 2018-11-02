package myJavaTraining.projects.carRental;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RentedCars implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> cars = new ArrayList<>();
	
	public void addCar(String plateNo) {
		cars.add(plateNo);
	}
	
	public void removeCar(String plateNo) {
		cars.remove(plateNo);
	}
	
	public int getCarsNo() {
		return cars.size();
	}
	
	public List<String> getCarList() {
		return cars;
	}
}


