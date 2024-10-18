package jdmorantesv.ips_authorization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jdmorantesv.ips_authorization.model.City.TABLE_NAME;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class City {
    public static final String TABLE_NAME = "city";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long idDepartment;

    @Column(nullable = false)
    private String name;
}
