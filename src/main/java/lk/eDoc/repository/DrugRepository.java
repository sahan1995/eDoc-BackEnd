package lk.eDoc.repository;

import lk.eDoc.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug,Integer> {
}
