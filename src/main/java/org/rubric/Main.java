package org.rubric;

import org.rubric.config.ConfigApp;
import org.rubric.dao.CrudDAO;
import org.rubric.dao.EmailDAO;
import org.rubric.dao.impl.AdDAOImpl;
import org.rubric.dao.impl.EmailDAOImpl;
import org.rubric.domain.*;
import org.rubric.service.AdService;
import org.rubric.service.CrudService;
import org.rubric.service.impl.AdServiceImpl;
import org.rubric.service.impl.AuthorServiceImpl;
import org.rubric.service.impl.MatchingAdServiceImpl;
import org.rubric.service.impl.RubricServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

/*        AdService adService = new AdServiceImpl();

        Ad ad = Ad.builder()
                .name("Hello1")
                .date(LocalDate.now())
                .text("it happened Hello1 yesterday")
                .price(BigDecimal.valueOf(200))
                .author(new AuthorServiceImpl().findById(1))
                .rubric(new RubricServiceImpl().findById(18))
                .build();

        Ad ad2 = Ad.builder()
                .name("Hello2")
                .date(LocalDate.now())
                .text("Today")
                .price(BigDecimal.valueOf(200))
                .author(new AuthorServiceImpl().findById(1))
                .rubric(new RubricServiceImpl().findById(18))
                .build();

        adService.save(ad);
        adService.save(ad2);*/

/*        MatchingAd madAd = MatchingAd.builder()
                .title("Hello1")
                .rubric(new RubricServiceImpl().findById(18))
                .author(new AuthorServiceImpl().findById(5))
                .priceFrom(new BigDecimal(100))
                .priceTo(new BigDecimal(500))
                .build();

      */
/*        Address address = Address
                .builder()
                .city("Dortmund")
                .build();

        Email email2 = Email
                .builder()
                .emailAddress("america@gmail.com")
                .build();

        Author author = Author
                .builder()
                .name("Richard")
                .email(email2)
                .address(address)
                .phones(List.of(Phone.builder().phoneNumber("+49159064").build()))
                .build();

        Rubric rubric = Rubric
                .builder()
                .name("autos")
                .build();*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

/*        CrudService<Author> authorService = context.getBean(AuthorServiceImpl.class);

        CrudService<Rubric> rubricService = context.getBean(RubricServiceImpl.class);*/

/*        rubricService.save(rubric);

        authorService.save(author);*/

 /*       Ad ad = Ad.builder()
                .name("Car")
                .date(LocalDate.now())
                .text("Hello1 it is car")
                .price(BigDecimal.valueOf(300))
                .author(authorService.findById(1))
                .rubric(rubricService.findById(1))
                .build();*/

        AdService adService = context.getBean(AdServiceImpl.class);

/*        MatchingAd madAd = MatchingAd.builder()
                .title("Hello1")
                .rubric(rubricService.findById(1))
                .author(authorService.findById(1))
                .priceFrom(new BigDecimal(100))
                .priceTo(new BigDecimal(500))
                .build();
        CrudService<MatchingAd> matchingAdService = context.getBean(MatchingAdServiceImpl.class);*/

        EmailDAO emailDAO = context.getBean(EmailDAOImpl.class);
        emailDAO.sendEmails(adService.findById(1));
    }
}
