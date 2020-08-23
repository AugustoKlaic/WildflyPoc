package wildflyRest.associate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate")
public class AssociateEntity {

    @Id
    @Column(name = "associate_cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "associate_name", nullable = false)
    private String name;

    public AssociateEntity() {
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
