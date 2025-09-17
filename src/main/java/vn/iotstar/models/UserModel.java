package vn.iotstar.models;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    private int userId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String code;
    private Integer roleId; // 1-user, 2-manager, 3-admin
    private String images;
    private String phone;
    

	private Boolean isEdit=false;
}
