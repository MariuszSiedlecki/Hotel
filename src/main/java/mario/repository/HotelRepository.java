package mario.repository;

import mario.models.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCountry(String country);

    List<Hotel> findByCountryAndRate(String country, String rate);

    List<Hotel> findHotelByAddress_City(String city);

    @Query(value = "select h from Hotel h where h =(select a.hotel from Address a where a.city='?1')")
    List<Hotel> findHotelByAddressCity(String city);

    @Transactional
//    @Modifying
//    @Query(value = "delete from Hotel h where h.partnerCode =?1")//JPQL
    void deleteHotelByPartnerCode(String partnerCode);

    @Query(value = "select h from Hotel h")
//JpQl
    List<Hotel> findAllHotels();

    Optional<Hotel> findHotelByPartnerCode(String partnerCode);
}
