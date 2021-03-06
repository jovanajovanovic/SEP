package rs.ac.uns.ftn.scientific_center.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    @ManyToMany
    private List<Role> roles;
    private String email;
    private String city;
    private String country;
    private String title;
    @ManyToMany
    private List<Magazine> magazines;
    @ManyToMany
    private List<ScientificField> scientificFields;
    @ManyToMany
    private List<Article> articles;
    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;
}
