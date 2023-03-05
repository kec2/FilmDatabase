package dk.kec.filmdb.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Actor extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Sam Worthington

    private String externalId; // fx imdb::nm0941777 or dvdfr::s50519-sam-worthington(.html)???

    private String imgUrl; // https://m.media-amazon.com/images/M/MV5BZWUwNmEwZT…XkEyXkFqcGdeQXVyMTM1MjAxMDc3._V1_FMjpg_UX567_.jpg

    @OneToMany(mappedBy = "actor")
    private List<Role> roles;

}
