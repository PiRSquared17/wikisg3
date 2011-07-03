package pos.dao;

import pos.domain.CreditCard;

public interface CreditCardDAO {

	public void saveCreditCard(CreditCard c);
	public CreditCard getCreditCard(Integer id);
	
}
