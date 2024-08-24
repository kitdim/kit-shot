package kit.org.app.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "links")
@Getter
@Setter
public class Link {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String shortName;
    private String originalName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
