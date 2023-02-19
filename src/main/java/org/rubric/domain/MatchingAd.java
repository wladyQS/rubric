package org.rubric.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "matching_ad")
public class MatchingAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_ad_id")
    int id;

    @Version
    int version;

    String title;

    @Column(name = "price_from")
    BigDecimal priceFrom;

    @Column(name = "price_to")
    BigDecimal priceTo;

    @ManyToOne
    @JoinColumn(name = "FK_MatchingAd_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_MatchingAd_Rubric")
    Rubric rubric;
}
