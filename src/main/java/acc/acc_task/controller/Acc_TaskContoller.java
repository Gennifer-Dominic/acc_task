package acc.acc_task.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import acc.acc_task.payload.filestorage;

import acc.acc_task.controller.Acc_TaskContoller;

import acc.acc_task.payload.uploadfileresponse;

@RestController
public class Acc_TaskContoller {
	private static final Logger logger = LoggerFactory.getLogger(Acc_TaskContoller.class);
	
	@Autowired
    private filestorage filestore;
	
	@PostMapping("/uploadFile")
    public uploadfileresponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = filestore.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new uploadfileresponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	
	@PostMapping("/uploadMultipleFiles")
	public List<uploadfileresponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
		return Arrays.asList(files)
				.stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
	}
	
}

