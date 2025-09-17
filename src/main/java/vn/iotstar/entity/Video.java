package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Videos")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideoID")
    private int videoId;

    @Column(name = "Title", columnDefinition = "NVARCHAR(100)")
    private String title;

    @Column(name = "Description", columnDefinition = "NVARCHAR(255)")
    private String description;

    @Column(name = "Url", columnDefinition = "NVARCHAR(500)")
    private String url;
    
    @Column(name = "Status", columnDefinition = "INT")
	private int status;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false) 
    private Category category;

}
