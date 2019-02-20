package lk.eDoc.repository;

import lk.eDoc.entity.OrderDetail;
import lk.eDoc.entity.OrderDetail_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail_PK> {


}
