package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.AboutTableType;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.mapper.TagMapper;
import com.triplan.service.inf.ItemGroupService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupMapper itemGroupMapper;
    private final ItemMapper itemMapper;
    private final TagMapper tagMapper;
    private final AttachmentMapper attachmentMapper;

    @Override
    @Transactional
    public void ItemGroupRegisterAddTags(ItemGroupRequestDTO itemGroupRequestDTO, List<MultipartFile> files) {

        ItemGroupVO itemGroupVO = itemGroupRequestDTO.toItemGroupVO();
        itemGroupMapper.insert(itemGroupVO);
        tagMapper.RegisterAddTagIdList(itemGroupVO.getItemGroupId(),itemGroupRequestDTO.getTagIdList());

        if (files.isEmpty()) return;

        AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ITEM, itemGroupVO.getItemGroupId());

        if (attachmentVO != null) {
            itemGroupVO.setItemImg(attachmentVO.getUrl());

            try {
                attachmentMapper.insert(attachmentVO);
                itemGroupMapper.update(itemGroupVO);
            } catch (Exception e){
                e.printStackTrace();
                AttachmentUtil.deleteAttachment(attachmentVO);
            }
        }
    }

    @Override
    @Transactional
    public void updateItemGroupTags(Integer itemGroupId, ItemGroupRequestDTO itemGroupRequestDTO, List<MultipartFile> files) {
        ItemGroupVO itemGroupVO = itemGroupRequestDTO.toItemGroupVO();

        if (!files.isEmpty()) {
            // 기존 파일 삭제
            AttachmentVO oldAttachmentVO = attachmentMapper.select(AboutTableType.ITEM, itemGroupVO.getItemGroupId());
            AttachmentUtil.deleteAttachment(oldAttachmentVO);
            attachmentMapper.delete(AboutTableType.ITEM, itemGroupVO.getItemGroupId());
            itemGroupVO.setItemImg("");

            // 새 파일 등록
            AttachmentVO newAttachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ITEM, itemGroupVO.getItemGroupId());

            if (newAttachmentVO != null) {
                itemGroupVO.setItemImg(newAttachmentVO.getUrl());

                try {
                    attachmentMapper.insert(newAttachmentVO);
                } catch (Exception e){
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(newAttachmentVO);
                }
            }
        }

        itemGroupVO.setItemGroupId(itemGroupId);
        itemGroupMapper.update(itemGroupVO);
        tagMapper.delete(itemGroupId);
        tagMapper.RegisterAddTagIdList(itemGroupVO.getItemGroupId(),itemGroupRequestDTO.getTagIdList());
    }

    @Override
    public void deleteItemGroup(Integer itemGroupId) {
        itemGroupMapper.delete(itemGroupId);
        AttachmentVO attachmentVO = attachmentMapper.select(AboutTableType.ITEM, itemGroupId);
        AttachmentUtil.deleteAttachment(attachmentVO);

        attachmentMapper.delete(AboutTableType.ITEM, itemGroupId);
    }

    @Override
    public ItemGroupResponseDTO getItemList(Integer itemGroupId) {

        List<ItemVO> itemVO = itemMapper.getItemByItemGroupId(itemGroupId);

        if(itemVO.get(0).getItemCategory().equals(ItemCategory.ROOM)){
            System.out.println("room");
            List<ItemRoomResponseDTO> itemRoomResponseDTO = itemVO.stream()
                    .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemRoomList(itemRoomResponseDTO);
            itemGroupResponseDTO.setTagIdList(tagMapper.getIdList(itemGroupId));

            return itemGroupResponseDTO;
        }
        else if(itemVO.get(0).getItemCategory().equals(ItemCategory.FLIGHT)){
            System.out.println("flight");
            List<ItemFlightResponseDTO> itemFlightResponseDTO = itemVO.stream()
                    .map(ItemFlightResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemFlightList(itemFlightResponseDTO);
            itemGroupResponseDTO.setTagIdList(tagMapper.getIdList(itemGroupId));

            return itemGroupResponseDTO;
        }
        else return null;

    }


    @Override
    public Pagination<ItemGroupVO> itemGroupListBySellerId(Integer sellerId, Integer pageSize, Integer currentPage) {
        List<ItemGroupVO> itemGroupList = itemGroupMapper.getItemGroupBySellerId(sellerId, pageSize, currentPage);
        int totalReviews = itemGroupMapper.count(sellerId);
        return new Pagination<>(pageSize, currentPage, totalReviews, itemGroupList);
    }
}
