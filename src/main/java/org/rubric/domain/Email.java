package org.rubric.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    int id;

    @Column(name = "email_address")
    String emailAddress;
}
