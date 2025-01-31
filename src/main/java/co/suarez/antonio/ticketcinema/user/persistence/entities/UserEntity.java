package co.suarez.antonio.ticketcinema.user.persistence.entities;

import co.suarez.antonio.ticketcinema.common.audit.AuditableEntity;

import co.suarez.antonio.ticketcinema.ticket.persistence.entities.TicketEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity
public class UserEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    private String name;

    private String lastname;

    private String email;

    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<TicketEntity> tickets;

}

  