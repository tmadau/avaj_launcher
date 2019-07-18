package com.avaj_launcher.simulator;
import com.avaj_launcher.exceptions.CustomFileErrorException;
import com.avaj_launcher.simulator.aircrafts.*;
import com.avaj_launcher.weather.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Simulator {

	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String arg[]) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				if (arg.length != 1) {
					throw new CustomFileErrorException("Please provide 1 scenario argument file: scenario.txt");
				}
				while ((line = reader.readLine()) != null) {
						Flyable flyable = AircraftFactory.newAircraft(
						line.split(" ")[0],
						line.split(" ")[1],
						Integer.parseInt(line.split(" ")[2]),
						Integer.parseInt(line.split(" ")[3]),
						Integer.parseInt(line.split(" ")[4]));
					if (flyable != null)
						flyables.add(flyable);
				}
				reader.close();

				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}
				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify simulation file");
		} catch (NullPointerException e) {
			System.out.println("value is null");
		} catch (NumberFormatException e) {
			System.out.println("not a valid number entered in file");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Logger.getLogger().close();
		}
	}
}
