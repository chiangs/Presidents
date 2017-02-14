package Projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PresidentsMethods {

	public List<Presidents> presidentArray() {
		List<Presidents> presidents = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("presidents.csv"))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(", ");
				
				int term = Integer.parseInt(fields[0]);
				String[] years = fields[4].split("-");
				int startYear = Integer.parseInt(years[0]);
				int endYear = Integer.parseInt(years[1]);
				
				Presidents president  = new Presidents(term, fields[1], fields[2], fields[3], startYear, endYear, fields[5]  );
				presidents.add(president);
			}

		} catch (IOException e) {
			System.err.println(e);
		}
		return presidents;
	}
	
	public void displayMethod(List<Presidents> presidents){
		for (int i = 0; i < presidents.size(); i++) {
			System.out.println(presidents.get(i));
		}
		System.out.println("**********/n");
	}
	
	public void displayWhig(List<Presidents> presidents){
		for (Presidents pres : presidents){
			
		if (pres.getParty().equals("Whig")){
			System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
	}
	
	public void displayMiddle(List<Presidents> presidents){
		for (Presidents pres : presidents){
			
		if (!pres.getMiddleName().isEmpty()){
			System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}
	
	public void display4years(List<Presidents> presidents){
		for (Presidents pres : presidents){
			if ((pres.endYear - pres.startYear) < 4){
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}
	
	public void displayR(List<Presidents> presidents){
		for (Presidents pres : presidents){
			if (pres.lastName.charAt(0) == 'R' || pres.lastName.charAt(0) == 'r' ){
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}
	
	public void writeWhig(List<Presidents> presidents){
		try {
			
			PrintWriter pw = new PrintWriter("whig.txt");
			for (Presidents pres : presidents){
				if (pres.party.equals("Whig")){
				pw.println(pres.lastName + " " + pres.firstName);
				}
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void writeRepub(List<Presidents> presidents){
		try {
			
			PrintWriter pw = new PrintWriter("republican.txt");
			for (Presidents pres : presidents){
				if (pres.party.equals("Republican")){
				pw.println(pres.lastName + " " + pres.firstName);
				}
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void writeDemo(List<Presidents> presidents){
		try {
			
			PrintWriter pw = new PrintWriter("democrat.txt");
			for (Presidents pres : presidents){
				if (pres.party.equals("Democrat")){
				pw.println(pres.lastName + " " + pres.firstName);
				}
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
