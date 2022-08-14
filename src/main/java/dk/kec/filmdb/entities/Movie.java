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
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie extends Auditing {

    @Id
    @GeneratedValue
    private Long id;

    private String md5;

    private String title;

    private String subtitle;

    private String language; // maybe this should be a reference to another table???? Maybe a comma separated list???

    private String diskId;

    private String comment;

    private String diskLabel;

    private String externalId; // engine:id. fx imdb:tt12345678

    private Integer year;

    private String imgUrl;

    @OneToMany(mappedBy = "movie")
    private List<Role> roles;

    private Integer runtime; // in minutes

    private String country; // maybe this should be a reference to another table????

    private String plot;

    private Double rating;

    private String fileName;
    private Long fileSize;
    private Timestamp fileDate;
    private String audioCodec;
    private String videoCodec;
    private Integer videoWidth;
    private Integer videoHeight;

    private Boolean isTv;

    @OneToOne
    private MediaType mediaType;

    @OneToOne
    private Owner owner;
}
