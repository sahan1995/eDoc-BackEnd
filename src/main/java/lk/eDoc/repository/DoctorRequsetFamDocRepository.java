package lk.eDoc.repository;

import lk.eDoc.entity.DoctorRequestForFamDoc;
import lk.eDoc.entity.DoctorRequestForFamDoc_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRequsetFamDocRepository extends JpaRepository<DoctorRequestForFamDoc,DoctorRequestForFamDoc_PK> {


    @Query(value = "SELECT * FROM  DoctorRequestForFamDoc dr WHERE dr.DID=:DID AND dr.isAccept=:isAccept",nativeQuery = true)
    List<DoctorRequestForFamDoc> findDoctorRequest(@Param("DID") String DID, @Param(("isAccept")) boolean isAccept);

    @Modifying
    @Query(value = "UPDATE DoctorRequestForFamDoc SET isAccept=:isAccept WHERE DID=:DID AND PID=:PID",nativeQuery = true)
    void updateIsAccept(@Param("isAccept") boolean isAccept,@Param("DID") String DID,@Param("PID") String PID);

}
