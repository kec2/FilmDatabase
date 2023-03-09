package dk.kec.filmdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EqualsAndHashCode(callSuper = false)
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
