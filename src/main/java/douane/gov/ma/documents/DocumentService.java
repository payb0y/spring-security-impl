package douane.gov.ma.documents;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getListDocuments(){
       return  documentRepository.findAll();
    }
}






//Liste static
/*     return List.of(
             new Document(
                        1L,
                                "circulaire_1234",
                                "/Users/hindhlam/Downloads/circulaire_92238.pdf",
                                ""
    ),
                new Document(
                        2L,
                                "circulaire_12345",
                                "/Users/hindhlam/Downloads/circulaire_92241.pdf",
                                ""
    )
        );*/


