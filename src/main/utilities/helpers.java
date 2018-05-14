package src.main.utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class helpers extends BaseClass{
	
	@Before
	public void launchBrowser(){
		try {
			openBrowser(Browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Close Application */
	@After
	public static void closeApp(){
		try{
			tearDownApp();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
