package org.dyu5thdorm.dyu5thdormapi.repositories;

import org.dyu5thdorm.dyu5thdormapi.models.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, String> {
}
