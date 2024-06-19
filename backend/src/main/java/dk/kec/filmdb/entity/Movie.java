package dk.kec.filmdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String md5;

    private String title;

    private String subtitle;

    private String language; // maybe this should be a reference to another table???? Maybe a comma separated list???

    private String diskId;

    private String comment;

    private String diskLabel;

    private String externalId; // engine:id. fx imdb:tt12345678

    private Integer releaseYear;

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
