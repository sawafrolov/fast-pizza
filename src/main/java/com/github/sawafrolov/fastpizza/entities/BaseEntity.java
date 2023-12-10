package com.github.sawafrolov.fastpizza.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

/**
 * Базовая сущность
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * UUID сущности
     */
    @Id
    @UuidGenerator
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    /**
     * Признак удаленной сущности
     */
    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean deleted = false;

    /**
     * Признак readonly сущности
     */
    @Column(name = "protected_from_change", nullable = false, columnDefinition = "boolean default false")
    private Boolean protectedFromChange = false;
}
