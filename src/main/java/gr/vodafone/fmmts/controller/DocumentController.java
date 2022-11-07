package gr.vodafone.fmmts.controller;

import gr.vodafone.fmmts.ReadFileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Value("${management.file-location:LineTransferOfficeDoublePlayApplication-14-1.pdf}")
    private String documentPath;

    @GetMapping
    public ResponseEntity downloadStuff() throws IOException {

        InputStream readFile = ReadFileUtils.getFileFromResourceAsStream(documentPath);
        HttpHeaders header = new HttpHeaders();
      //  header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
              //  .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(readFile.readAllBytes());
    }
}
