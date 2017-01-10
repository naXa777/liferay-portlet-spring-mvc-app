package by.naxa.liferay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author phomal
 */
@Entity
@Table(name = "record")
@Getter
@Setter
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long recordId;

    @Column(name = "name")
    private String name;

}
