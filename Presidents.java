package Projects;

public class Presidents {

	int termNumber;
	String firstName;
	String middleName;
	String lastName;
	int startYear;
	int endYear;
	String party;
	
	public Presidents(int termNumber, String firstName, String middleName, String lastName, int startYear, int endYear, String party) {
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.party = party;
	}
	
	public Presidents(int termNumber, String firstName, String lastName, int startYear, int endYear, String party) {
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.party = party;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public String getParty() {
		return party;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public void setParty(String party) {
		this.party = party;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Presidents: ");
        builder.append(firstName + " " + middleName + " " + lastName);
        builder.append("\nStart Year: ");
        builder.append(startYear);
        builder.append("\nEnd Year: ");
        builder.append(endYear);
        builder.append("\nParty: ");
        builder.append(party);
        builder.append("\nTerm Limit: ");
        builder.append(termNumber);
        builder.append(" \n");
        return builder.toString();
        
    }
}
