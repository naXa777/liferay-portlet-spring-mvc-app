package by.naxa.liferay.model;

import javax.persistence.*;

/**
 * Created by phomal on 1/10/2017.
 */
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long recordId;

    @Column(name = "name")
    private String name;

}
