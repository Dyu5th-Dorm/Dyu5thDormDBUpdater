package org.dyu5thdorm.dyu5thdormapi.repositories;

import org.dyu5thdorm.dyu5thdormapi.models.SchoolTimestamp;
import org.dyu5thdorm.dyu5thdormapi.models.SchoolTimestampId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTimestampRepository extends JpaRepository<SchoolTimestamp, SchoolTimestampId> {
}
