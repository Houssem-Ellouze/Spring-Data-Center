package tn.esprit.springdatacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springdatacenter.entity.DataCenter;

@Repository
public interface DataCenterRepository extends JpaRepository<DataCenter, Integer> {
}
