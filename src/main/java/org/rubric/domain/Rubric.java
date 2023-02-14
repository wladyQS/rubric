package org.rubric.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "rubric")
public class Rubric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rubric_id")
    int id;

    @Version
    int version;

    String name;
}
