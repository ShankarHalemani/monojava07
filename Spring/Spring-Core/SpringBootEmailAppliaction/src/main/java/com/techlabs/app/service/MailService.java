package com.techlabs.app.service;

import jakarta.mail.MessagingException;

public interface MailService {
    public void mailWithAttachment(String to, String subject, String body, String filePath) throws MessagingException;
}
