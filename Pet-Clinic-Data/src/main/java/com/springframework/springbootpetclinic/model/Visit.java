package com.springframework.springbootpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL) // solve issue with saving visit
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

}
