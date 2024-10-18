package jdmorantesv.ips_authorization.model;

import jakarta.persistence.*;
import lombok.*;

import static jdmorantesv.ips_authorization.model.Address.TABLE_NAME;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TABLE_NAME)
public class Address {
    public static final String TABLE_NAME = "address";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idCity;

    @Column(nullable = false)
    private String address;
}
