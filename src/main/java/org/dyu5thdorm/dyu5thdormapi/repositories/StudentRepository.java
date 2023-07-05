package org.dyu5thdorm.dyu5thdormapi.repositories;

import org.dyu5thdorm.dyu5thdormapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
