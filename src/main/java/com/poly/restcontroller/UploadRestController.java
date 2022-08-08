package com.poly.restcontroller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.service.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin("*")
@RestController
public class UploadRestController {
    @Autowired
    UploadService uploadService;

    @PostMapping("/rest/upload/{folder}")
    public JsonNode upload(@PathVariable("file")MultipartFile file,
                           @PathVariable("folder")String folder){
        File savedFile = uploadService.save(file, folder);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name",savedFile.getName());
        node.put("size",savedFile.length());
        return node;
    }
}
