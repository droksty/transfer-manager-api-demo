package io.droksty.transfersdemo.repository;

import io.droksty.transfersdemo.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findAllByPickupDateEqualsOrderByPickupTimeAsc(LocalDate date);
    List<Transfer> findAllByPickupDateBetweenOrderByPickupDateAscPickupTimeAsc(LocalDate from, LocalDate to);

}
