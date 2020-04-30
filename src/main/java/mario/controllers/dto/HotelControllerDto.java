package mario.controllers.dto;


import mario.models.dto.HotelDto;
import mario.services.Dto.HotelServiceDto;
import mario.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/dto")
public class HotelControllerDto implements HotelService<HotelDto> {
    private static final Logger logger = LoggerFactory.getLogger(HotelControllerDto.class);

    private HotelServiceDto hotelServiceDto;

    public HotelControllerDto(HotelServiceDto hotelServiceDto) {
        this.hotelServiceDto = hotelServiceDto;
    }

    @Override
    @GetMapping("/hotels")
    public List<HotelDto> getHotels() {
        return hotelServiceDto.getHotels();
    }

    @Override
    @GetMapping("/hotels/country/{country}")
    public List<HotelDto> getHotelsByCountry(@PathVariable String country) {
        return hotelServiceDto.getHotelsByCountry(country);
    }

    @Override
    @GetMapping("/hotels/city/{city}")
    public List<HotelDto> getHotelsByCity(@PathVariable String city) {
        return hotelServiceDto.getHotelsByCity(city);
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
        return null;
    }

    @Override
    @DeleteMapping("/hotels")
    public void deleteHotelByPartnerCode(@RequestParam(name = "delete") String partnerCode) {
        hotelServiceDto.deleteHotelByPartnerCode(partnerCode);

    }

    @Override
    @PostMapping("/hotels")
    public void addHotel(@RequestBody HotelDto hotelDto) {
        hotelServiceDto.addHotel(hotelDto);

    }


}
