package org.dyu5thdorm.dyu5thdormapi.repositories;

import org.dyu5thdorm.dyu5thdormapi.models.LivingRecord;
import org.dyu5thdorm.dyu5thdormapi.models.LivingRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LivingRecordRepository extends JpaRepository<LivingRecord, LivingRecordId> {
}
