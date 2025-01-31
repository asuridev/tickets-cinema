package co.suarez.antonio.ticketcinema.ticket.persistence.entities;

import co.suarez.antonio.ticketcinema.common.audit.AuditableEntity;
import co.suarez.antonio.ticketcinema.movie.persistence.entities.MovieEntity;
import co.suarez.antonio.ticketcinema.user.persistence.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tickets")
@Entity
public class TicketEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    private String seat;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @JsonIgnore
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @JoinColumn(name="movie_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private MovieEntity movie;

}

  