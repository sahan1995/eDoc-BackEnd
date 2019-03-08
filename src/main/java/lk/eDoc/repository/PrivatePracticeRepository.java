package lk.eDoc.repository;

import lk.eDoc.entity.PrivatePrictice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PrivatePracticeRepository extends JpaRepository<PrivatePrictice,String> {


    @Query(value = "SELECT * FROM PrivatePrictice WHERE  DID=:DID",nativeQuery = true)
    Optional<PrivatePrictice> hasPP(@Param("DID") String DID);

    @Query(value = "SELECT count(DID) FROM PrivatePrictice",nativeQuery = true)
    String getCount();


}
