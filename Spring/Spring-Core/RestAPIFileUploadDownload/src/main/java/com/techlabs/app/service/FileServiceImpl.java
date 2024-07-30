package com.techlabs.app.service;

import com.techlabs.app.entity.FileItem;
import com.techlabs.app.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {
    private FileRepository repository;

    public FileServiceImpl(FileRepository repository) {
        this.repository = repository;
    }

    @Override
    public FileItem saveFile(FileItem file) {
        return repository.save(file);
    }

    @Override
    public Optional<FileItem> getFileByName(String fileName) {
        Optional<FileItem> item = repository.findByName(fileName);
        return item;
    }


}
