package ru.mtuci.rbpo_2024_praktika.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "license_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LicenseType {
    @Id
    @GeneratedValue
    private long id;

    private int default_duration;
    private String description;
}
