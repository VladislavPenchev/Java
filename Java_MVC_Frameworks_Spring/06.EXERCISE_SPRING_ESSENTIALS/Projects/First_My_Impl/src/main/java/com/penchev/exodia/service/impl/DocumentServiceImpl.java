package com.penchev.exodia.service.impl;

import com.penchev.exodia.domain.entities.Document;
import com.penchev.exodia.domain.models.sevice.ScheduleServiceModel;
import com.penchev.exodia.repository.DocumentRepository;
import com.penchev.exodia.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleServiceModel scheduleImport(ScheduleServiceModel scheduleServiceModel) {

        Document document = this.modelMapper.map(scheduleServiceModel, Document.class);

        try{
            this.documentRepository.saveAndFlush(document);

            return this.modelMapper.map(document, ScheduleServiceModel.class);
        } catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }
}
