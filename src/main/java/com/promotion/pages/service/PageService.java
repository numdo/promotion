package com.promotion.pages.service;

import com.promotion.pages.dto.request.PageRequestDTO;
import com.promotion.pages.dto.response.PageResponseDTO;

import com.promotion.pages.model.Meta;
import com.promotion.pages.model.Page;
import com.promotion.pages.model.Tag;
import com.promotion.pages.repository.PageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ModelMapper modelMapper;

    
    public PageResponseDTO createPage(PageRequestDTO pageRequestDTO) {
        Page page = new Page();
        page.setUrl(pageRequestDTO.getUrl());

        if (pageRequestDTO.getMetas() != null) {
            List<Meta> metas = pageRequestDTO.getMetas().stream()
                    .map(metaDTO -> {
                        Meta meta = modelMapper.map(metaDTO, Meta.class);
                        meta.setPage(page);
                        return meta;
                    })
                    .collect(Collectors.toList());
            page.setMetas(metas);
        }

        if (pageRequestDTO.getTags() != null) {
            List<Tag> tags = pageRequestDTO.getTags().stream()
                    .map(tagDTO -> {
                        Tag tag = modelMapper.map(tagDTO, Tag.class);
                        tag.setPage(page);
                        return tag;
                    })
                    .collect(Collectors.toList());
            page.setTags(tags);
        }

        Page savedPage = pageRepository.save(page);
        return modelMapper.map(savedPage, PageResponseDTO.class);
    }

    
    public PageResponseDTO getPageByUrl(String url) {
        Page page = pageRepository.findByUrl(url)
                .orElseThrow(() -> new RuntimeException("페이지를 찾을 수 없습니다."));
        return modelMapper.map(page, PageResponseDTO.class);
    }

    
    public List<PageResponseDTO> getAllPages() {
        List<Page> pages = pageRepository.findAll();
        return pages.stream()
                .map(page -> modelMapper.map(page, PageResponseDTO.class))
                .collect(Collectors.toList());
    }

    
    public PageResponseDTO updatePage(Long id, PageRequestDTO pageRequestDTO) {
        Page page = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("페이지를 찾을 수 없습니다."));

        page.setUrl(pageRequestDTO.getUrl());

        // 메타 업데이트
        if (pageRequestDTO.getMetas() != null) {
            page.getMetas().clear();
            List<Meta> metas = pageRequestDTO.getMetas().stream()
                    .map(metaDTO -> {
                        Meta meta = modelMapper.map(metaDTO, Meta.class);
                        meta.setPage(page);
                        return meta;
                    })
                    .collect(Collectors.toList());
            page.getMetas().addAll(metas);
        }

        // 태그 업데이트
        if (pageRequestDTO.getTags() != null) {
            page.getTags().clear();
            List<Tag> tags = pageRequestDTO.getTags().stream()
                    .map(tagDTO -> {
                        Tag tag = modelMapper.map(tagDTO, Tag.class);
                        tag.setPage(page);
                        return tag;
                    })
                    .collect(Collectors.toList());
            page.getTags().addAll(tags);
        }

        Page updatedPage = pageRepository.save(page);
        return modelMapper.map(updatedPage, PageResponseDTO.class);
    }

    
    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
