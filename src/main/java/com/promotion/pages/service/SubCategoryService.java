package com.promotion.pages.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.promotion.global.exception.ResourceNotFoundException;
import com.promotion.pages.dto.request.SubCategoryRequestDTO;
import com.promotion.pages.dto.response.SubCategoryResponseDTO;
import com.promotion.pages.model.MainCategory;
import com.promotion.pages.model.SubCategory;
import com.promotion.pages.repository.MainCategoryRepository;
import com.promotion.pages.repository.SubCategoryRepository;

//src/main/java/com/promotion/service/SubCategoryService.java

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final MainCategoryRepository mainCategoryRepository;

    // 생성(Create)
    public SubCategoryResponseDTO createSubCategory(SubCategoryRequestDTO requestDTO) {
        MainCategory mainCategory = mainCategoryRepository.findById(requestDTO.getMainCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("MainCategory not found with id: " + requestDTO.getMainCategoryId()));

        SubCategory subCategory = new SubCategory();
        subCategory.setName(requestDTO.getName());
        subCategory.setDescription(requestDTO.getDescription());
        subCategory.setMainCategory(mainCategory);

        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        return new SubCategoryResponseDTO(savedSubCategory);
    }
    // MainCategory ID로 SubCategory 목록 조회
    public List<SubCategoryResponseDTO> getSubCategoriesByMainCategory(Long mainCategoryId) {
        List<SubCategory> subCategories = subCategoryRepository.findByMainCategoryId(mainCategoryId);
        return subCategories.stream()
                .map(SubCategoryResponseDTO::new)
                .collect(Collectors.toList());
    }
    // 조회(Read) - 전체
    public List<SubCategoryResponseDTO> getAllSubCategories() {
        return subCategoryRepository.findAll()
                .stream()
                .map(SubCategoryResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 조회(Read) - 단일
    public SubCategoryResponseDTO getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));
        return new SubCategoryResponseDTO(subCategory);
    }

    // 수정(Update)
    public SubCategoryResponseDTO updateSubCategory(Long id, SubCategoryRequestDTO requestDTO) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));

        MainCategory mainCategory = mainCategoryRepository.findById(requestDTO.getMainCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("MainCategory not found with id: " + requestDTO.getMainCategoryId()));

        subCategory.setName(requestDTO.getName());
        subCategory.setDescription(requestDTO.getDescription());
        subCategory.setMainCategory(mainCategory);

        SubCategory updatedSubCategory = subCategoryRepository.save(subCategory);
        return new SubCategoryResponseDTO(updatedSubCategory);
    }

    // 삭제(Delete)
    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
