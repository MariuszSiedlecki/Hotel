package mario.services;

import mario.models.Hotel;
import mario.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService  {
    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels(){
      List<Hotel>hotels =hotelRepository.findAll();
        logger.debug("Hotels {}",hotels);
        return hotels;

    }
}
