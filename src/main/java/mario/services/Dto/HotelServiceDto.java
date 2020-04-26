package mario.services.Dto;

import mario.exceptions.ResourceNotFoundException;
import mario.mappers.HotelMapper;
import mario.models.dao.Address;
import mario.models.dao.Hotel;
import mario.models.dto.HotelDto;
import mario.repository.AddressRepository;
import mario.repository.HotelRepository;
import mario.repository.RoomRepository;
import mario.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceDto implements HotelService<HotelDto> {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceDto.class);

    private HotelRepository hotelRepository;
    private AddressRepository addressRepository;
    private HotelMapper hotelMapper;
    private RoomRepository roomRepository;

    public HotelServiceDto(HotelRepository hotelRepository, AddressRepository addressRepository, HotelMapper hotelMapper, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
        this.hotelMapper = hotelMapper;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<HotelDto> getHotels() {

        return hotelRepository.findAllHotels()
                .stream()
                .map(hotelMapper::map)
                .collect(Collectors.toList());
    }
//---------------------------- druga opcja powyższej metody
//        List<HotelDto> hotels = hotelRepository.findAll()
//                .stream()
//                .map(hotelMapper::map)
//                .collect(Collectors.toList());
//        return hotels;
//    }

    @Override
    public List<HotelDto> getHotelsByCountry(String country) {

        return hotelRepository.findByCountry(country)
                .stream()
                .map(hotelMapper::map)
                .collect(Collectors.toList());
    }
    //--------------------------------druga opcjapowyższej metody-----
//    List<HotelDto> listcountry = hotelRepository.findByCountry(country)
//            .stream()
//            .map(hotelMapper::map)
//            .collect(Collectors.toList());
//        return listcountry;
//}

    @Override
    public List<HotelDto> getHotelsByCity(String city) {

//        return null;
//    }
        // ------------------------------------------moje wypociny
        return hotelRepository.findHotelByAddress_City(city)
                .stream()
                .map(hotelMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDto> getHotelsByRate(String rate) {
        return null;
    }

    @Override
    public List<HotelDto> getHotelsByRoomType(String type) {
        return null;
    }

    @Override
    public HotelDto getHotelByPartnerCode(String partnerCode) {
        Optional<Hotel> hotel = hotelRepository.findHotelByPartnerCode(partnerCode);
        return hotelMapper.map(hotel.get());
    }

    @Override
    public void deleteHotelByPartnerCode(String partnerCode) {
        hotelRepository.deleteHotelByPartnerCode(partnerCode);

    }

    @Override
    public void addHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setTitle(hotelDto.getTitle());
        hotel.setCountry(hotelDto.getCountry());
        hotel.setRate(hotelDto.getRate());
        hotel.setPartnerCode(hotelDto.getPartnerCode());
        hotel.setRooms(roomRepository.findAll());//todo trzeba zrobić konwersje rooms dto na dao
        Hotel result = hotelRepository.save(hotel);

        Address address = hotelMapper.getAddressFromDto(hotelDto.getAddress());
        address.setHotel(result);
        addressRepository.save(address);
    }

    public HotelDto updateHotel(HotelDto hotelDto){
        System.out.println(hotelDto);
        Optional<Hotel> before = hotelRepository.findHotelByPartnerCode(hotelDto.getPartnerCode());
        before.orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
        before.get().setTitle(hotelDto.getTitle());
        before.get().setCountry(hotelDto.getCountry());
        before.get().setRate(hotelDto.getRate());
        before.get().getAddress().setEmail(hotelDto.getAddress().getEmail());
        hotelRepository.save(before.get());
        return hotelMapper.map(before.get());
    }
}
