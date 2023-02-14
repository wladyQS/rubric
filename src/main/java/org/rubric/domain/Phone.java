package org.rubric.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@ToString(exclude = "author")
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    int id;

    @Version
    int version;

    @Column(name = "phone_number")
    String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "FK_Phone_Author")
    Author author;
}
