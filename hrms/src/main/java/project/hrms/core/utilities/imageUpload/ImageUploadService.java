package project.hrms.core.utilities.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {

	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
