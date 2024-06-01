package douane.gov.ma.documents;

import jakarta.persistence.*;

@Entity
@Table
public class Document {
    @Id
    @SequenceGenerator(
            name ="document_sequence",
            sequenceName = "document_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "document_sequence"
    )
    private Long id;
    private String file_key;
    private String file_name;
    private String process_statut;


    public Document() {
    }

    public Document(String file_key, String file_name, String process_statut) {
        this.file_key = file_key;
        this.file_name = file_name;
        this.process_statut = process_statut;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile_key() {
        return file_key;
    }

    public void setFile_key(String file_key) {
        this.file_key = file_key;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getProcess_statut() {
        return process_statut;
    }

    public void setProcess_statut(String process_statut) {
        this.process_statut = process_statut;
    }
}
