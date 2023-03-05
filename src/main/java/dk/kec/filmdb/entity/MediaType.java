package dk.kec.filmdb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MediaType extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // dvd, blu-ray, ...
}
