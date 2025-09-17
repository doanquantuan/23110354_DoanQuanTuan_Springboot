package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Column(name = "UserName", columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(name = "PassWord", columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(name = "FullName", columnDefinition = "NVARCHAR(MAX)")
    private String fullName;

    @Column(name = "Email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "Code", columnDefinition = "VARCHAR(50)")
    private String code;

    @Column(name = "RoleID")
    private int roleId; // 1-user, 2-manager, 3-admin

    @Column(name = "Images")
    private String images;
	
    @Column(name = "Phone")
    private String phone;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Category> categories;
   
}
