package pos.dao;

import pos.domain.Address;

public interface AddressDAO {

	public void saveAddress(Address address);
	
	public Address getAddress(Integer id);
	
}
