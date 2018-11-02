package myJavaTraining.projects.carRental;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;

public class RentApp implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Scanner sc = new Scanner(System.in);

	private static HashMap<String, String> rentedCars = new HashMap<>(100, 0.5f);
	private static HashMap<String, RentedCars> ownerList = new HashMap<>();


	public static void main(String[] args) throws IOException {
		rentedCars = readRentedCars();
		ownerList = readOwnerList();
		
		if(rentedCars == null) init();		

		boolean quit = false;
		while(!quit) {
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String command = sc.nextLine().toLowerCase();
			switch(command) {
			case "help":
				printCommandsList();
				break;
			case "add":
				rentCar(getPlateNo(), getOwnerName());
				break;
			case "check":
				System.out.println(isCarRent(getPlateNo()));
				break;
			case "remove":
				returnCar(getPlateNo());
				break;
			case "getowner":
				String owner = getCarRent(getPlateNo());
				if(owner == null)
					System.out.println("Ne pare rau, dar masina cu numarul introdus nu figureaza in baza noastra de date, incearca alt numar.");
				else 
					System.out.println("Proprietarul curent este: " + owner);
				break;
			case "getcarsno":
				owner = getOwnerName();
				if(!ownerList.containsKey(owner))
					System.out.println("Ne pare rau, persoana introdusa nu figureaza in baza noastra de date.");
				else 
					System.out.println("Numarul de masini inchiriate de " + owner + " este: " + getOwnerList(owner).getCarsNo());
				break;
			case "getcarslist":
				owner = getOwnerName();
				if(!ownerList.containsKey(owner))
					System.out.println("Ne pare rau, persoana introdusa nu figureaza in baza noastra de date.");
				else 
					System.out.println("Masinile inchiriate de " + owner + " sunt:\n" + getOwnerList(owner).getCarList());
				break;
			case "totalrented":
				System.out.println("Numarul total de masini inchiriate este: " + rentedCars.size());
				break;
			case "reset":
				rentedCars = null;
				ownerList = null;
				init();
				break;
			case "quit":
				System.out.println("Aplicatia se inchide...");
				writeBinaryFile(rentedCars, ownerList);
				quit = true;
				break;
			default:
				System.out.println("Unknown command. Choose from:");
				printCommandsList();
			}
		}
	}
	
	private static void writeBinaryFile (HashMap<String, String> rentedCars, HashMap<String, RentedCars> ownerList) throws IOException {
		try(ObjectOutputStream fileOut1 = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream("C:\\Users\\Vikroom\\eclipse-workspace\\C20\\src\\rentedCars.dat")));
			ObjectOutputStream fileOut2 = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream("C:\\Users\\Vikroom\\eclipse-workspace\\C20\\src\\ownerList.dat")))) {
			
			fileOut1.writeObject(rentedCars);
			fileOut2.writeObject(ownerList);
		}
	}
	
	private static HashMap<String, String> readRentedCars() throws IOException {
		HashMap<String, String> rentedCars = null;
		
		try(ObjectInputStream fileIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:\\Users\\Vikroom\\eclipse-workspace\\C20\\src\\rentedCars.dat")))) {
				
				try {
					rentedCars = (HashMap<String, String>) fileIn.readObject();

				} catch (EOFException e) {}
				
		} catch (FileNotFoundException e) {}
		
		catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		}
		
		return rentedCars;
	}
	
	private static HashMap<String, RentedCars> readOwnerList() throws IOException {
		HashMap<String, RentedCars> ownerList = null;
		
		try(ObjectInputStream fileIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:\\Users\\Vikroom\\eclipse-workspace\\C20\\src\\ownerList.dat")))) {
				
				try {
					ownerList = (HashMap<String, RentedCars>) fileIn.readObject();

				} catch (EOFException e) {}
				
		} catch (FileNotFoundException e) {}
		
		catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		}
		
		return ownerList;
	}
	
	
	private static void init() {
		rentedCars = new HashMap<>(100, 0.5f);
		ownerList = new HashMap<>();
	}


	private static String getPlateNo() {
		System.out.println("Introduceti numarul de inmatriculare:");
		return sc.nextLine();
	}

	private static String getOwnerName() {
		System.out.println("Introduceti numele proprietarului:");
		return sc.nextLine();
	}

	// search for a key in hashtable
	private static boolean isCarRent(String plateNo) {
		return rentedCars.containsKey(plateNo);
	}

	private static boolean isOwnerRegistered(String ownerName) {
		return ownerList.containsKey(ownerName);
	}


	// get the value associated to a key
	private static String getCarRent(String plateNo) {
		return rentedCars.get(plateNo);
	}

	private static RentedCars getOwnerList(String ownerName) {
		return ownerList.get(ownerName);
	}

	// add a new (key, value) pair
	private static void rentCar(String plateNo, String ownerName) {
		if(isCarRent(plateNo))
			System.out.println("Masina " + plateNo + " nu este disponibila. Alege alta masina.");
		else {
			rentedCars.put(plateNo, ownerName);
			if(isOwnerRegistered(ownerName)) {
				getOwnerList(ownerName).addCar(plateNo);
			} else {
				ownerList.put(ownerName, new RentedCars());
				getOwnerList(ownerName).addCar(plateNo);
			}
		}		
	}

	// remove an existing (key, value) pair
	private static void returnCar(String plateNo) {
		if (!rentedCars.containsKey(plateNo)) 
			System.out.println("Masina cu numarul " + plateNo + " nu exista in baza de date, introdu alt numar.");
		else {
			getOwnerList(rentedCars.get(plateNo)).removeCar(plateNo);
			rentedCars.remove(plateNo);
			System.out.println("Masina cu numarul " + plateNo + " a fost restituita cu succes.");
		}

	}

	private static void printCommandsList() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua pereche (masina, sofer)");
		System.out.println("check        - Verifica daca o masina este deja luata");
		System.out.println("remove       - Sterge o masina existenta din hashtable");
		System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
		System.out.println("getCarsNo    - Afiseaza numarul masinilor inchiriate de catre o persoana");
		System.out.println("getCarsList  - Afiseaza lista masinilor inchiriate de catre o persoana");
		System.out.println("totalRented  - Afiseaza proprietarul curent al masinii");
		System.out.println("reset        - Reseteaza aplicatia");
		System.out.println("quit         - Inchide aplicatia");
	}


}