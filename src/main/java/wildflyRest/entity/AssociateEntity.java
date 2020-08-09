package wildflyRest.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "associate")
public class AssociateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "associate_id")
    private UUID id;

    @Column(name = "associate_cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "associate_name", nullable = false)
    private String name;

    public AssociateEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
