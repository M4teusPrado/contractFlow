package com.attus.contractFlow.repository;

import com.attus.contractFlow.modal.contract.entitys.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}