package com.example.library.service;

import com.example.library.model.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PublisherService implements IPublisherService{

    PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return (List<Publisher>) publisherRepository.findAll() ;
    }

    @Override
    public Publisher findById(Long aLong) {
        return publisherRepository.findById(aLong).orElse(null);
    }

    @Override
    public Publisher save(Publisher object) {
        return publisherRepository.save(object);
    }

    @Override
    public void delete(Publisher object) {
        publisherRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        publisherRepository.deleteById(aLong);
    }
}
