package wildflyRest.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "associates")
public class AssociateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "associates_id")
    private UUID id;

    @Column(name = "associates_cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "associates_name", nullable = false)
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
