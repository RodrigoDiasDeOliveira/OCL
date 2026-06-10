package com.triminds.rfid.service;

import com.triminds.rfid.model.RfidTag;
import com.triminds.rfid.repository.RfidTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RfidTagService {

    @Autowired
    private RfidTagRepository repository;

    // 📌 buscar todas as tags
    public List<RfidTag> findAll() {
        return repository.findAll();
    }

    // 📌 salvar ou atualizar tag
    public RfidTag save(RfidTag tag) {
        return repository.save(tag);
    }

    // 📌 buscar por ID lógico da tag
    public Optional<RfidTag> findByTagId(String tagId) {
        return repository.findByTagId(tagId);
    }

    // 📌 deletar por entidade
    public void delete(RfidTag tag) {
        repository.delete(tag);
    }
}