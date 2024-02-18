package com.adoption.kittenlove.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "adoptions")
@SequenceGenerator(
        name = "seq_generator",
        sequenceName = "SEQ_RENTS",
        initialValue = 4,
        allocationSize = 1
)
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    private int id;
    private LocalDate fromDate;
    private String toDate;

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Cat cat;

    @ManyToOne
    @JoinColumn(name = "guardian_id", referencedColumnName = "id")
    private Guardian guardian;


}
