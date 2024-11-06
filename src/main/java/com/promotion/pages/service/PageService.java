package com.promotion.pages.service;

import com.promotion.pages.dto.request.PageRequestDTO;
import com.promotion.pages.dto.response.PageResponseDTO;

import com.promotion.pages.model.Meta;
import com.promotion.pages.model.Page;
import com.promotion.pages.model.Section;
import com.promotion.pages.repository.PageRepository;
import com.promotion.pages.repository.SectionRepository;
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
    private SectionRepository sectionRepository;

    @Autowired
    private ModelMapper modelMapper;


    public PageResponseDTO createPage(PageRequestDTO pageRequestDTO) {
        Page page = new Page();
        page.setUrl(pageRequestDTO.getUrl());

        // 메타 설정
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

        // 섹션 설정
        if (pageRequestDTO.getSections() != null) {
            List<Section> sections = pageRequestDTO.getSections().stream()
                    .map(sectionDTO -> {
                        Section section = modelMapper.map(sectionDTO, Section.class);
                        section.setPage(page);
                        return section;
                    })
                    .collect(Collectors.toList());
            page.setSections(sections);
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

        // 섹션 업데이트
        if (pageRequestDTO.getSections() != null) {
            page.getSections().clear();
            List<Section> sections = pageRequestDTO.getSections().stream()
                    .map(sectionDTO -> {
                        Section section = modelMapper.map(sectionDTO, Section.class);
                        section.setPage(page);
                        return section;
                    })
                    .collect(Collectors.toList());
            page.getSections().addAll(sections);
        }

        Page updatedPage = pageRepository.save(page);
        return modelMapper.map(updatedPage, PageResponseDTO.class);
    }


    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
