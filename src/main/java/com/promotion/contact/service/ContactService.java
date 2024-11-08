package com.promotion.contact.service;

// src/main/java/com/promotion/contact/service/ContactService.java

import com.promotion.contact.dto.request.ContactRequestDTO;
import com.promotion.contact.dto.response.ContactResponseDTO;
import com.promotion.contact.model.Contact;
import com.promotion.contact.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactResponseDTO createContact(ContactRequestDTO contactRequestDTO) {
        Contact contact = new Contact(
                contactRequestDTO.getName(),
                contactRequestDTO.getContact(),
                contactRequestDTO.getInquiry(), // 수정: getContact() -> getInquiry()
                contactRequestDTO.getDate()
        );

        Contact savedContact = contactRepository.save(contact); // 수정: contactRepository 인스턴스 사용

        return new ContactResponseDTO(
                savedContact.getId(),
                savedContact.getName(),
                savedContact.getContact(),
                savedContact.getInquiry(), // 수정: getContact() -> getInquiry()
                savedContact.getDate(),
                savedContact.getCreatedAt().toString()
        );
    }
}
