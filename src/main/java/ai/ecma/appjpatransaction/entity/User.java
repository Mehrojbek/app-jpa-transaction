package ai.ecma.appjpatransaction.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "transaction_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double balance;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }
}
