package pl.air.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor

public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "start_date")
    private LocalDate startDate;

    @Column (name = "end_date")
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name ="project_id", referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    )
    private List<Employee> employees = new ArrayList<>();
}
