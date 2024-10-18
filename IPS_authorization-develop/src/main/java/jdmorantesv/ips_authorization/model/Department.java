package jdmorantesv.ips_authorization.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jdmorantesv.ips_authorization.model.Department.TABLE_NAME;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name=TABLE_NAME)
public class Department {
    public static final String TABLE_NAME = "department";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;
}
