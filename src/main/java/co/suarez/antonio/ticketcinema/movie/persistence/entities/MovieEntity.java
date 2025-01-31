package co.suarez.antonio.ticketcinema.movie.persistence.entities;

import co.suarez.antonio.ticketcinema.common.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movies")
@Entity
public class MovieEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    private String title;

    private String genre;

    private Double duration;


}

  