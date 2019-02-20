package lk.eDoc.repository;

import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {


    @Query(value = "SELECT 1 FROM Appointment a WHERE a.DID= :DID AND a.date= :date AND a.time= :time AND a.isCheck= :isCheck",nativeQuery = true)
    String checkAppointmentAvalable(@Param("DID") String DID, @Param("date") String date, @Param("time") String time, @Param("isCheck") int isCheck);

    @Query(name = Appointment.Query)
    List<Appointment> getLastID(Pageable pageable);




}
