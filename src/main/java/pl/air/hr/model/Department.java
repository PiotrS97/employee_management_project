package pl.air.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor

public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "location")
    private String location;
}
