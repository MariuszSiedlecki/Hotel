package mario.services.Dao;

import mario.models.dao.Address;
import mario.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDao {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceDao.class);

    private AddressRepository addressRepository;

    public AddressServiceDao(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
}
