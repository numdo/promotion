package com.promotion.pages.dto.response;


import com.promotion.pages.dto.request.MetaRequestDTO;
import com.promotion.pages.dto.request.TagRequestDTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO {
    private Long id;
    private String url;
    private List<MetaRequestDTO> metas;
    private List<TagRequestDTO> tags;
}

