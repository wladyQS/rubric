package org.rubric.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
    int id;

    @Version
    int version;

    String name;

    LocalDate date;

    String text;

    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Rubric")
    Rubric rubric;
}
