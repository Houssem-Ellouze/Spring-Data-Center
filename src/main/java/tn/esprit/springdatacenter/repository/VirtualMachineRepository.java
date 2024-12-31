package tn.esprit.springdatacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springdatacenter.entity.VirtualMachine;

import java.util.Optional;

@Repository
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, Integer> {


}
