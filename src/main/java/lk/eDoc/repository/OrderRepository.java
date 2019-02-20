package lk.eDoc.repository;

import lk.eDoc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
