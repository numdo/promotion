package com.promotion.contact.controller;

// src/main/java/com/promotion/contact/controller/ContactController.java

import com.promotion.contact.dto.request.ContactRequestDTO;
import com.promotion.contact.dto.response.ContactResponseDTO;
import com.promotion.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody ContactRequestDTO contactRequestDTO) {
        ContactResponseDTO responseDTO = contactService.createContact(contactRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // 예외 처리 핸들러 (선택 사항)
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append(" ");
        });
        return new ResponseEntity<>(errors.toString().trim(), HttpStatus.BAD_REQUEST);
    }
}
