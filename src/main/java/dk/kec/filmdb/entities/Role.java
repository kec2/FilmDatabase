package dk.kec.filmdb.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"actor_id", "movie_id"}, name = "role_actor_id_movie_id_unique")})
public class Role extends Auditing {

    @Id
    @GeneratedValue
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
