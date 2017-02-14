package Projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PresidentsMethods2 {
	public List<Presidents> presidentArray() {
		List<Presidents> presidents = new ArrayList<>();
		int term = 0;
		int startYear = 0;
		int endYear = 0;
		String firstName = "";
		String middleName = null;
		String lastName = "";
		String party = "";

		try (BufferedReader br = new BufferedReader(new FileReader("presidents.txt"))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(" ");
				
				if(fields.length==6){
				
					term = Integer.parseInt(fields[0]);
					String[] years = fields[4].split("-");
					startYear = 0;
					endYear = 0;
				
					//if year-year
					if(years.length==2){
						startYear = Integer.parseInt(years[0]);
						endYear = Integer.parseInt(years[1]);
					}
					//If only 1 year
					else{
						startYear = Integer.parseInt(years[0]);
						endYear = Integer.parseInt(years[0]);
					}

					party = fields[5].substring(1, fields.length-1);
					System.out.println(party);
					Presidents president  = new Presidents(term, fields[1], fields[2], fields[3], startYear, endYear, fields[5]  );
					System.out.println(president);
					presidents.add(president);
				}	
	
				if (fields.length == 5){
					term = Integer.parseInt(fields[0]);
					String[] years = fields[3].split("-");
					startYear = 0;
					endYear = 0;
					try{
					
						//if year-year
						if(years.length==2){
							startYear = Integer.parseInt(years[0]);
							endYear = Integer.parseInt(years[1]);
						}
						//If only 1 year
						else{
						startYear = Integer.parseInt(years[0]);
						endYear = Integer.parseInt(years[0]);
						}
						party = fields[4].substring(1, fields.length-1);
						System.out.println(party);
						}
						catch(Exception e){
							String[] words = fields[4].split("Democrat");
							//if year-year
							years = words[0].substring(0, words[0].length()-1).split("-");
							if(years.length==2){
								startYear = Integer.parseInt(years[0]);
								endYear = Integer.parseInt(years[1]);
							}
							//If only 1 year
							else{
							startYear = Integer.parseInt(years[0]);
							endYear = Integer.parseInt(years[0]);
							}
							party = fields[4].substring(0, fields.length-1);
							System.out.println(party);
						}
					}
				
				
				Presidents president  = new Presidents(term, fields[1], fields[2], startYear, endYear, fields[4]  );
				System.out.println(president);
				presidents.add(president);
					
				}
					

		
	}catch (IOException e) {
			System.err.println(e);
		}
		return presidents;
	}

	public void displayMethod(List<Presidents> presidents) {
		for (int i = 0; i < presidents.size(); i++) {
			System.out.println(presidents.get(i));
		}
		System.out.println("**********/n");
	}

	public void displayWhig(List<Presidents> presidents) {
		for (Presidents pres : presidents) {

			if (pres.getParty().equals("Whig")) {
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
	}

	public void displayMiddle(List<Presidents> presidents) {
		for (Presidents pres : presidents) {

			if (!pres.getMiddleName().isEmpty()) {
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}

	public void display4years(List<Presidents> presidents) {
		for (Presidents pres : presidents) {
			if ((pres.endYear - pres.startYear) < 4) {
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}

	public void displayR(List<Presidents> presidents) {
		for (Presidents pres : presidents) {
			if (pres.lastName.charAt(0) == 'R' || pres.lastName.charAt(0) == 'r') {
				System.out.println(pres);
			}
		}
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
		System.out.println("**********");
	}

	public void writeWhig(List<Presidents> presidents) {
		try {

			PrintWriter pw = new PrintWriter("whig.txt");
			for (Presidents pres : presidents) {
				if (pres.party.equals("Whig")) {
					pw.println(pres.lastName + " " + pres.firstName);
				}
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void writeRepub(List<Presidents> presidents) {
		try {

			PrintWriter pw = new PrintWriter("republican.txt");
			for (Presidents pres : presidents) {
				if (pres.party.equals("Republican")) {
					pw.println(pres.lastName + " " + pres.firstName);
				}
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void writeDemo(List<Presidents> presidents) {
		try {

			PrintWriter pw = new PrintWriter("democrat.txt");
			for (Presidents pres : presidents) {
				if (pres.party.equals("Democrat")) {
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
