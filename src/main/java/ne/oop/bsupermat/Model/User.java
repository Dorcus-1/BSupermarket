package ne.oop.bsupermat.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
//@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "email" , nullable = false)//    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    private String firstName;
    private String lastName;
    @Column(name = "profile_picture", nullable = true)
    private String profilePicture = null;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles = new HashSet<Role>();
}