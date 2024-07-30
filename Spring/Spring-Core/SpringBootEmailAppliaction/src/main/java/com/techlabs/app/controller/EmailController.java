package com.techlabs.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techlabs.app.dto.EmailDTO;
import com.techlabs.app.service.MailServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private MailServiceImpl mailService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/sendWithAttachment")
    public ResponseEntity<String> sendMailWithAttachement(@RequestParam("emailDTO") String emailDTOStr,
                                                          @RequestPart("attachment") MultipartFile attachment) {
        try {
            EmailDTO emailDTO = objectMapper.readValue(emailDTOStr, EmailDTO.class);

            String tempFilePath = System.getProperty("java.io.tmpdir") + attachment.getOriginalFilename();
            attachment.transferTo(new java.io.File(tempFilePath));

            mailService.mailWithAttachment(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getBody(), tempFilePath);

            new java.io.File(tempFilePath).delete();

            return ResponseEntity.ok("Email Sent Successfully");
        } catch (MessagingException | IOException e) {
            return ResponseEntity.status(500).body("Error sending email : " + e.getMessage());
        }
    }
}
