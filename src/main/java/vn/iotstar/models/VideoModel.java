package vn.iotstar.models;

import java.io.Serializable;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    
    private int videoId;

    
    private String title;

    
    private String description;

  
    private String url;
    
	private int status;
	

	private Boolean isEdit=false;
}
