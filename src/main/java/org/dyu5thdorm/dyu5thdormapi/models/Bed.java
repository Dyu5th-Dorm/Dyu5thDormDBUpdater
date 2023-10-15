package org.dyu5thdorm.dyu5thdormapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "bed")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bed {
    @Id
    @Column(name = "bed_id")
    String bedId;
}
