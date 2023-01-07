package org.idb.TestSpringBoot.repository;

import org.idb.TestSpringBoot.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    ConfirmationToken findByconfirmationToken(String token);


}
