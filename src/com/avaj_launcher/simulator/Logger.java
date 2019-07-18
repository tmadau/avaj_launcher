package com.avaj_launcher.simulator;
import java.io.*;

public class Logger {
	
	private static Logger writefile = null;
	private static BufferedWriter bw = null;
	private static File file = null;
	private static FileWriter fw = null;
	private Logger() {}

	public static Logger getLogger() {
		if (writefile == null) {
			try{
				writefile = new Logger();
				file = new File("simulation.txt");
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
			} catch (IOException ioe) {
				System.out.println("An error occured: " + ioe);
			}
		}
		return writefile;
	}

	public void	logtofile(String str) {
		try {
			bw.write(str);
			bw.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void close() {
		try {
			if (bw != null)
				bw.close();
		} catch (Exception ex) {
			System.out.println("Error in closing the BufferedWriter: " + ex);
		}
	}
}
