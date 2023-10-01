package com.flight.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartFileReader {

	public static void main(String[] args) {

		{

			System.out.println(args[0]);

			List<FlightData> flightsList = new ArrayList<>();

			readFileData(flightsList);

			List<FlightData> selectedFlights = searchFlights(flightsList, "FRA", "LHR", "0600");

			// Collections.sort(selectedFlights,new DateComparator());

			Collections.sort(selectedFlights, new TimeAndFareComparator());

			for (FlightData flightData : selectedFlights) {
				System.out.println(flightData);
			}
		}
	}

	private static List<FlightData> searchFlights(List<FlightData> flightsList, String startLocation,
			String endLocation, String time) {

		List<FlightData> selectedFlights = new ArrayList<>();

		for (FlightData flight : flightsList) {

			if (flight.getDepartureLocation().equals(startLocation) && flight.getArrivalLocation().equals(endLocation)
					&& flight.getTime().equals(time)) {

				selectedFlights.add(flight);
			}
		}

		return selectedFlights;
	}

	private static void readFileData(List<FlightData> flightsList) {
		String line = "";
		try {

			// parsing a CSV file into BufferedReader
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\npandita\\Desktop\\Practice\\flights.csv"));
			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value

			{
				String[] flights = line.split("\\|"); // use | as separator
				// System.out.println(flights[0]);

				FlightData flightData = new FlightData();
				flightData.setFlightNum(flights[0]);
				flightData.setDepartureLocation(flights[1]);
				flightData.setArrivalLocation(flights[2]);
				flightData.setValidity((flights[3]));
				flightData.setTime((flights[4]));
				flightData.setDuration((flights[5]));
				flightData.setFare(Integer.parseInt(flights[6]));

				flightsList.add(flightData);

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("error while reading file");
		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}

class DateComparator implements Comparator<FlightData> {

	@Override
	public int compare(FlightData o1, FlightData o2) {
		return o1.getDuration().compareTo(o2.getDuration());
	}

}

class TimeAndFareComparator implements Comparator<FlightData> {

	@Override
	public int compare(FlightData o1, FlightData o2) {

		if (o1.getFare().equals(o2.getFare())) {
			// compare flight duration if fare is same
			return o1.getDuration().compareTo(o2.getDuration());
		} else {

			return o1.getFare().compareTo(o2.getFare());
		}

	}

}

class FlightData {

	private String flightNum;

	private String departureLocation;

	private String arrivalLocation;

	private String validity;

	private String time;

	private String duration;

	private Integer fare;

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "FlightData [flightNum=" + flightNum + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", validity=" + validity + ", time=" + time + ", duration=" + duration + ", fare="
				+ fare + "]";
	}

}
