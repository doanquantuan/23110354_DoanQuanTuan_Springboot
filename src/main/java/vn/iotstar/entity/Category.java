package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
	private int categoryId;
	
	@Column(name = "CategoryName", columnDefinition = "NVARCHAR(MAX)")
	private String categoryName;
	
	@Column(name = "Images", columnDefinition = "NVARCHAR(MAX)")
	private String images;
	
	@Column(name = "Status", columnDefinition = "INT")
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "UserID", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Video> videos;


}
