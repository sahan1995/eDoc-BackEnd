package lk.eDoc.repository;

import lk.eDoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
