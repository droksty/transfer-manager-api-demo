package io.droksty.transfersdemo.repository;

import io.droksty.transfersdemo.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findAllByDateBetweenOrderByDateAscTimeAsc(LocalDate from, LocalDate to);
    List<Transfer> findAllByDateBetweenAndClientUidEqualsOrderByDateAscTimeAsc(LocalDate from, LocalDate to, String clientUid);
    List<Transfer> findAllByDateBetweenAndOperatorUidEqualsOrderByDateAscTimeAsc(LocalDate from, LocalDate to, String operatorUid);
    List<Transfer> findAllByDateBetweenAndClientUidEqualsOrOperatorUidEqualsOrderByDateAscTimeAsc(LocalDate from, LocalDate to, String clientUid, String operatorUid);
}
