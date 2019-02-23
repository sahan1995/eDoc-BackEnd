package lk.eDoc.repository;

import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {


    @Query(value = "SELECT 1 FROM Appointment a WHERE a.DID= :DID AND a.date= :date AND a.time= :time AND a.isCheck= :isCheck AND a.isCancle=:isCancle ",nativeQuery = true)
    String checkAppointmentAvalable(@Param("DID") String DID, @Param("date") String date, @Param("time") String time,
                                    @Param("isCheck") int isCheck,@Param("isCancle") int isCancle);

    @Query(value = "SELECT COUNT(AppCode) FROM Appointment", nativeQuery = true)
    String getLastID();


    @Query(value = "SELECT  * FROM  Appointment a WHERE a.DID=:DID AND a.isCheck=:isCheck AND a.isCancle=:isCancle ",nativeQuery = true)
    List<Appointment> doctorAppointments(@Param("DID") String DID, @Param("isCheck") int isCheck,@Param("isCancle") int isCancle);

    @Query(value = "SELECT * FROM Appointment a WHERE a.AppType=:AppType AND a.DID =:DID AND a.isCancle=:isCancle AND a.isCheck=:isCheck",nativeQuery = true)
    List<Appointment> getByType(@Param("AppType") String appType, @Param("DID") String DID,@Param("isCancle") int isCancle,@Param("isCheck") int isCheck);

    @Query(value = "SELECT * FROM Appointment a WHERE a.date =:date AND a.DID =:DID AND a.isCheck =:isCheck AND a.isCancle =:isCancle ",nativeQuery = true)
    List<Appointment> findByDate(@Param("date") String date,@Param("DID") String DID, @Param("isCheck") int isCheck, @Param("isCancle") int isCancle);

    @Query(value = "SELECT * FROM Appointment a WHERE a.date =:date AND a.DID =:DID AND a.isCheck =:isCheck AND a.isCancle =:isCancle AND a.AppType = :AppType", nativeQuery = true)
    List<Appointment> findByDateAndType(@Param("date") String date,@Param("DID") String DID, @Param("isCheck") int isCheck, @Param("isCancle") int isCancle,@Param("AppType") String AppType);


    @Query(value = "SELECT  * FROM  Appointment a WHERE a.PID=:PID AND a.isCheck=:isCheck AND a.isCancle=:isCancle ",nativeQuery = true)
    List<Appointment> patientAppointments(@Param("PID") String PID, @Param("isCheck") int isCheck,@Param("isCancle") int isCancle);

    @Query(value = "SELECT * FROM Appointment a WHERE a.AppType=:AppType AND a.PID =:PID AND a.isCancle=:isCancle AND a.isCheck=:isCheck",nativeQuery = true)
    List<Appointment> getByTypePatient(@Param("AppType") String appType, @Param("PID") String PID,@Param("isCancle") int isCancle,@Param("isCheck") int isCheck);

    @Query(value = "SELECT * FROM Appointment a WHERE a.date =:date AND a.PID =:PID AND a.isCheck =:isCheck AND a.isCancle =:isCancle ",nativeQuery = true)
    List<Appointment> findByDatePatient(@Param("date") String date,@Param("PID") String PID, @Param("isCheck") int isCheck, @Param("isCancle") int isCancle);

    @Query(value = "SELECT * FROM Appointment a WHERE a.date =:date AND a.PID =:PID AND a.isCheck =:isCheck AND a.isCancle =:isCancle AND a.AppType = :AppType", nativeQuery = true)
    List<Appointment> findByDateAndTypePatient(@Param("date") String date,@Param("PID") String PID, @Param("isCheck") int isCheck, @Param("isCancle") int isCancle,@Param("AppType") String AppType);

//    @Query(value = "UPDATE Appointment a SET a.isCheck=:isCheck WHERE a.AppCode=:appCode",nativeQuery = true)
    @Modifying
    @Query(value = "update  Appointment set isCheck=:isCheck where AppCode=:AppCode",nativeQuery = true)
    void finishAppointment(@Param("isCheck") int isCheck,@Param("AppCode") String appCode);

}
