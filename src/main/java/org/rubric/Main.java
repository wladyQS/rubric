package org.rubric;

import org.rubric.config.ConfigApp;
import org.rubric.dao.CrudDAO;
import org.rubric.dao.EmailDAO;
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

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        CrudService<Author> authorService = context.getBean(AuthorServiceImpl.class);

        System.out.println();

/*      Email email = Email
                .builder()
                .email("vovawestland@gmail.com")
                .build();

        Email email2 = Email
                .builder()
                .email("vfsdfds@gmail.com")
                .build();

        Address address = Address
                .builder()
                .city("Dortmund")
                .build();

        CrudService<Rubric> rubricService = new RubricServiceImpl();

        Author author = Author
                .builder()
                .name("Andrey")
                .email(email)
                .address(address)
                .phones(List.of(Phone.builder().phoneNumber("38908900").build()))
                .build();

        Author author2 = Author
                .builder()
                .name("Andrey")
                .email(email2)
                .phones(List.of(Phone.builder().phoneNumber("3890fsd0").build()))
                .build();

        Rubric rubric = Rubric
                .builder()
                .name("websites")
                .build();

        authorService.save(author);
        authorService.save(author2);
        rubricService.save(rubric);*/

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

        EmailDAO emailDAO = new EmailDAOImpl();
        AdService adService = new AdServiceImpl();
//        emailDAO.sendEmails(adService.findById(1));


    }
}
