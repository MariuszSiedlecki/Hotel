package mario.mappers;

import mario.UtilsMapper.Mapper;
import mario.models.dao.Address;
import mario.models.dao.Hotel;
import mario.models.dto.AddressDto;
import mario.models.dto.HotelDto;
import mario.models.dto.RoomDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper implements Mapper<Hotel, HotelDto> {

    private AddressMapper addressMapper;
    private RoomMapper roomMapper;

    public HotelMapper(AddressMapper addressMapper, RoomMapper roomMapper) {
        this.addressMapper = addressMapper;
        this.roomMapper = roomMapper;
    }


    @Override
    public HotelDto map(Hotel from) {
        List<RoomDto> rooms = from.getRooms()
                .stream()
                .map(roomMapper::map)
                .collect(Collectors.toList());

        return HotelDto
                .builder()
                .title(from.getTitle())
                .partnerCode(from.getPartnerCode())
                .country(from.getCountry())
                .rate(from.getRate())
                .address(addressMapper.map(from.getAddress()))
                .rooms(rooms)
                .build();
    }

    @Override
    public Hotel revers(HotelDto to) {
//        Hotel hotel = new Hotel();
//        Address address = getAddressFromDto(to.getAddress());
//        hotel.setTitle(to.getTitle());
//        hotel.setCountry(to.getCountry());
//        hotel.setRate(to.getRate());
//
//        to
//        hotel.setAddress();
        return null;
    }

    public Address getAddressFromDto(AddressDto from) {
        Address address = new Address();
        address.setEmail(from.getEmail());
        address.setUrl(from.getUrl());
        address.setPhone(from.getPhone());
        String[] addr = from.getPostalAddress().trim().split(",");
        address.setCity(addr[0]);
        address.setStreet(addr[1]);
        address.setStreetNumber(addr[2]);
        return address;
    }


// ---już nie potrzebny ------
//    private enum RoomsToString implements Function<Room, String> {
//        INSTANCE;
//
//        @Override
//        public String apply(Room room) {
//            return room.toString();
//        }

}
