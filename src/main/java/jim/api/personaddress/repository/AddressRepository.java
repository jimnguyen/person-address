package jim.api.personaddress.repository;

import jim.api.personaddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByState(String state);

    @Query("SELECT a from Address a WHERE a.city = ?1 AND a.state = ?2")
    List<Address> addressInSameCity(String city, String state);
}
