package mario.services.Dao;

import mario.exceptions.ResourceNotFoundException;
import mario.mappers.HotelMapper;
import mario.models.dao.Hotel;
import mario.repository.AddressRepository;
import mario.repository.HotelRepository;
import mario.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceDao {
    private static final Logger logger = LoggerFactory.getLogger(HotelServiceDao.class);

    private HotelRepository hotelRepository;
    private AddressRepository addressRepository;
    private HotelMapper hotelMapper;
    private RoomRepository roomRepository;

    public HotelServiceDao(HotelRepository hotelRepository, AddressRepository addressRepository, HotelMapper hotelMapper, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
        this.hotelMapper = hotelMapper;
        this.roomRepository = roomRepository;
    }

    public HotelServiceDao() {

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
//    ----------Dto service-------
//
//    public List<HotelDto> getHotelsDto(){
//        List<Hotel>hotels =hotelRepository.findAll();
//
//        return hotels
//                .stream()
//                .map(hotelMapper::map)
//                .collect(Collectors.toList());
//
//    }
}
