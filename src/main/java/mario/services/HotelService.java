package mario.services;

import mario.exceptions.ResourceNotFoundException;
import mario.models.Hotel;
import mario.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService  {
    public static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels(){
      List<Hotel>hotels =hotelRepository.findAll();
        logger.debug("Hotels:{}",hotels);
        MDC.clear();
        return hotels;
    }

    public Hotel getHotelById(Long id){
        return hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not found hotel by  id" + id));

    }
    public List<Hotel>getHotelByCountry(String country){
        return hotelRepository.findByCountry(country);
    }

    public List<Hotel>getHotelByCountryAndRate(String country, String rate){
        return hotelRepository.findByCountryAndRate(country,rate);
    }
}
