package genericUtilities;

import java.time.LocalDateTime;
import java.util.Random;

public class Java_utility {

	public int getRandomNum() {
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		return ranDomNum;

		/**
		 * this method is used to fetch the random class 
		 * @author Danish
		 */
	}
	public String  getSystemDate() {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		return timeStamp;
	}
	

}



