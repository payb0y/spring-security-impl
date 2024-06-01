package douane.gov.ma.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customs/v1/classement")
public class DocumentCtrl {
    private final DocumentService documentService;

    @Autowired
    public DocumentCtrl(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getListDocuments(){
        return documentService.getListDocuments();
    }


}
