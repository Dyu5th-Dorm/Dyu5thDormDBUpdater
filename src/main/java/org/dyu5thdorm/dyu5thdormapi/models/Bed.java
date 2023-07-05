package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bed")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bed {
    @Id
    @Column(name = "bed_id")
    String bedId;
}
