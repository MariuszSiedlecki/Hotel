package mario.services;

import mario.models.dto.HotelDto;

import java.util.List;

public interface HotelService <T>{

    List<T> getHotels();
    List<T> getHotelsByCountry(String country);
    List<T> getHotelsByCity(String city);
    List<T> getHotelsByRate(String rate);
    List<T> getHotelsByRoomType(String type);

    HotelDto getHotelByPartnerCode(String partnerCode);


    void deleteHotelByPartnerCode(String partnerCode);

    void addHotel(HotelDto hotelDto);

}
