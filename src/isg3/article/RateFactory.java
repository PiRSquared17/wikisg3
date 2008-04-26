package isg3.article;

import isg3.user.*;

public class RateFactory {

	/**
	 * 
	 * @param rate
	 * @param reason
	 * @param user
	 * @return
	 */
	public Rate createRate(int rate, String reason, User user){
		
		return new Rate(rate, reason, user);
		
	}
	
}
