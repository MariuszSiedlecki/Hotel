package mario.controllers.dao;

import mario.models.dao.Hotel;
import mario.services.Dao.HotelServiceDao;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class HotelController {
    public static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    private HotelServiceDao hotelServiceDao;

    public HotelController(HotelServiceDao hotelServiceDao) {
        this.hotelServiceDao = hotelServiceDao;
    }

//    @GetMapping("/hotels")
//    public List<Hotel> getHotels(HttpServletRequest request){
//        MDC.put("session",request.getSession().getId());
//        logger.debug("Received new request: {}",request.getRemoteAddr());
//        return hotelService.getHotels();
//    }

    @GetMapping("/hotels/{id}/id")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return ResponseEntity.ok(hotelServiceDao.getHotelById(id));
    }

    @GetMapping("/hotels/{country}/country")
    public ResponseEntity<List<Hotel>> getHotelByCountry(@PathVariable String country){
        return ResponseEntity.ok(hotelServiceDao.getHotelByCountry(country));
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getHotelByCountryAndRate(
            @RequestParam(required = false) String country ,
            @RequestParam(required = false) String rate){
        if(StringUtils.isNotBlank(country) && StringUtils.isNotBlank(rate)){
            return ResponseEntity.ok(hotelServiceDao.getHotelByCountryAndRate(country,rate));
        }
        return ResponseEntity.ok(hotelServiceDao.getHotels());

    }

//    @GetMapping("/hotels/dto")
//    public ResponseEntity<List<HotelDto>> getHotels(){;
//        return ResponseEntity.ok(hotelServiceDao.getHotelsDto());
//
//    }
}
