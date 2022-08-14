package dk.kec.filmdb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Actor extends Auditing {

    @Id
    @GeneratedValue
    private Long id;

    private String name; // Sam Worthington

    private String externalId; // fx imdb::nm0941777 or dvdfr::s50519-sam-worthington(.html)???

    private String imgUrl; // https://m.media-amazon.com/images/M/MV5BZWUwNmEwZT…XkEyXkFqcGdeQXVyMTM1MjAxMDc3._V1_FMjpg_UX567_.jpg

    @OneToMany(mappedBy = "actor")
    private List<Role> roles;

}
