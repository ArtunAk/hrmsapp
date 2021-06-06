package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryManager;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	
	@Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dccjmysxd",
                "api_key", "695737689564184",
                "api_secret", "lW1yxM3X1t97VirKyG8ElYZXFMg"));
    }
	
	@Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }

}
