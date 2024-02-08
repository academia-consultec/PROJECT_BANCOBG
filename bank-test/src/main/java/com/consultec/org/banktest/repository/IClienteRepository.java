package com.consultec.org.banktest.repository;

import com.consultec.org.banktest.repository.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
