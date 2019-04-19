package poj.math.basic.easy;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 纯数学问题，根据公式计算不同的变量
 * @author zhaohuiyang
 *
 */
public class P3299 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("E")) {
				sc.close();
				break;
			}
			String[] arr = line.split(" ");
			double v1 = Double.parseDouble(arr[1]);
			double v2 = Double.parseDouble(arr[3]);
			double temperature = 0;
			double dewpoint = 0;
			double humidex = 0;
			if(arr[0].equals("T") && arr[2].equals("D")) {
				temperature = v1;
				dewpoint = v2;
				getHumidex(temperature, dewpoint);
			}
			else if(arr[0].equals("D") && arr[2].equals("T")){
				temperature = v2;
				dewpoint = v1;
				getHumidex(temperature, dewpoint);
			}
			else if(arr[0].equals("T") && arr[2].equals("H")){
				temperature = v1;
				humidex = v2;
				getDewpoint(temperature, humidex);
			}
			else if(arr[0].equals("H") && arr[2].equals("T")){
				temperature = v2;
				humidex = v1;
				getDewpoint(temperature, humidex);
			}
			else if(arr[0].equals("D") && arr[2].equals("H")){
				dewpoint = v1;
				humidex = v2;
				getTemperature(dewpoint, humidex);
			}
			else{
				dewpoint = v2;
				humidex = v1;
				getTemperature(dewpoint, humidex);
			}
		}
	}
	
	
	private static void getHumidex(double temperature, double dewpoint) {
		double e = 6.11*Math.exp(5417.7530*((1/273.16) - (1/(dewpoint+273.16))));
		double h = 0.5555* (e - 10.0);
		double humidex = temperature + h;
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("T " + df.format(temperature) + " D " + df.format(dewpoint) + " H " + df.format(humidex));
	}
	
	
	private static void getDewpoint(double temperature, double humidex) {
		double h = humidex - temperature;
		double e = h/0.5555 + 10.0;
		double dewpoint = 1/(1/273.16 - Math.log(e/6.11)/5417.7530) - 273.16;
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("T " + df.format(temperature) + " D " + df.format(dewpoint) + " H " + df.format(humidex));
	}
	
	
	private static void getTemperature(double dewpoint, double humidex) {
		double e = 6.11*Math.exp(5417.7530*((1/273.16) - (1/(dewpoint+273.16))));
		double h = 0.5555* (e - 10.0);
		double temperature  = humidex - h;
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("T " + df.format(temperature) + " D " + df.format(dewpoint) + " H " + df.format(humidex));
	}
}
