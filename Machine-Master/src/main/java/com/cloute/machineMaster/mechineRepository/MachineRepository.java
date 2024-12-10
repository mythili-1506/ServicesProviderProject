package com.cloute.machineMaster.mechineRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloute.machineMaster.mechineEntity.MachineMaster;


@Repository
public interface MachineRepository extends JpaRepository <MachineMaster,Long>{

	Optional<MachineMaster> findByMachineId(Long machineId);

	List<MachineMaster> findByStatus(int i);

	
}