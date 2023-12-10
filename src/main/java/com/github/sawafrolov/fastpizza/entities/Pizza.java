package com.github.sawafrolov.fastpizza.entities;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

/**
 * Сущность пиццы
 */
@Getter
@Setter
@QueryEntity
@Entity(name = "pizza")
@SQLDelete(sql = "UPDATE pizza SET deleted = true WHERE uuid=?")
@Where(clause = "deleted=false")
public class Pizza extends BaseEntity {

    /**
     * Диаметр пиццы в сантиметрах
     */
    @NotNull
    @Positive
    @Column(name = "diameter")
    private Integer diameter;

    /**
     * Масса пиццы в граммах
     */
    @NotNull
    @Positive
    @Column(name = "weight")
    private Integer weight;

    /**
     * Цена пиццы
     */
    @NotNull
    @Positive
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Признак острой пиццы
     */
    @NotNull
    @Column(name = "is_hot")
    private Boolean isHot;

    /**
     * Признак вегетарианской пиццы
     */
    @NotNull
    @Column(name = "is_veggie")
    private Boolean isVeggie;
}
