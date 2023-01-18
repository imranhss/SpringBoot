package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryRepo extends JpaRepository<Inventory, Integer> {

}
