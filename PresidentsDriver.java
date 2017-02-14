package Projects;

import java.util.ArrayList;
import java.util.List;

public class PresidentsDriver {
	List<Presidents> presidents;
	PresidentsMethods2 presMeth = new PresidentsMethods2();

	public static void main(String[] args) {
		PresidentsDriver driver = new PresidentsDriver();
		driver.start();
	}
	
	public PresidentsDriver() {
		presidents = presMeth.presidentArray();
	}
		
		
	public void start(){
		presMeth.displayMethod(presidents);
		
		presMeth.displayWhig(presidents);
		
		presMeth.displayMiddle(presidents);

		presMeth.display4years(presidents);

		presMeth.displayR(presidents);

		presMeth.writeWhig(presidents);
		
		presMeth.writeRepub(presidents);
		
		presMeth.writeDemo(presidents);

	}

	
}
