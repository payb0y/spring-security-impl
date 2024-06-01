package douane.gov.ma.documents;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocumentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository docRepository) {
        return
                args->{
            Document document1= new Document(
                    "circulaire_1234",
                    "/Users/hindhlam/Downloads/circulaire_92238.pdf",
                    ""
            );
            Document document2=new Document(
                    "circulaire_12345",
                    "/Users/hindhlam/Downloads/circulaire_92241.pdf",
                    ""
                    );
            Document document3=new Document(
                            "circulaire_1249",
                            "/Users/hindhlam/Downloads/circulaire_92238.pdf",
                            ""
                    );
            Document document4=new Document(
                            "circulaire_12350",
                            "/Users/hindhlam/Downloads/circulaire_92241.pdf",
                            ""
                    );
                    docRepository.saveAll(
                            List.of(document1,document2,document3,document4)
                    );
        };

    }

}
