package mario.controllers.dao;

import mario.models.dao.Address;
import mario.services.Dao.AddressServiceDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AddressController {

    private AddressServiceDao addressServiceDao;

    public AddressController(AddressServiceDao addressServiceDao) {
        this.addressServiceDao = addressServiceDao;
    }

    @GetMapping("/address")
    public List<Address> getAddresses(){
        return addressServiceDao.getAddress();
    }
}
