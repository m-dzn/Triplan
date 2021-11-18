package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.response.Pagination;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemGroupService {

    void ItemGroupRegisterAddTags(ItemGroupRequestDTO itemGroupRequestDTO, List<MultipartFile> files);

    void updateItemGroupTags(Integer itemGroupId, ItemGroupRequestDTO itemGroupRequestDTO, List<MultipartFile> files);

    void deleteItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId);

    Pagination<ItemGroupVO> itemGroupListBySellerId(Integer sellerId, Integer pageSize, Integer currentPage);
}
