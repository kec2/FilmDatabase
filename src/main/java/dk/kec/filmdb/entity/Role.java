package dk.kec.filmdb.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"actor_id", "movie_id"}, name = "role_actor_id_movie_id_unique")})
public class Role extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "actor_id")
    private Actor actor; // Arnold Schwarzenegger

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie; // Terminator

    @Column(nullable = false)
    private String name; // Terminator T800

    private String title; // (actor, director, bla bla)
}
