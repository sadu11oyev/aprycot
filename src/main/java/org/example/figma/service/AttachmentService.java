package org.example.figma.service;

import org.example.figma.entity.Attachment;

import java.util.UUID;

public interface AttachmentService {
    Attachment findById(UUID id);
}