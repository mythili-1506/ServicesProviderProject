package com.example.machineMaster.mechineRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.machineMaster.mechineEntity.MachineMaster;

@Repository
public interface MachineRepository extends JpaRepository<MachineMaster, Long>{

	Optional<MachineMaster> findByCustID(long custID);

	List<MachineMaster> findByStatus(int i);
	
}
