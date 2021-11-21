package com.triplan.service;

import com.triplan.domain.AttachmentVO;
import com.triplan.domain.FlightVO;
import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.AboutTableType;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.AttachmentMapper;
import com.triplan.mapper.FlightMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.mapper.RoomMapper;
import com.triplan.service.inf.ItemService;
import com.triplan.util.AttachmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final FlightMapper flightMapper;
    private final RoomMapper roomMapper;
    private final AttachmentMapper attachmentMapper;


    @Override
    public void itemRemove(Integer itemId) {
        itemMapper.delete(itemId);
        List<AttachmentVO> list = attachmentMapper.select(AboutTableType.ITEM, itemId);
        AttachmentUtil.deleteAttachments(list);

        attachmentMapper.delete(AboutTableType.ITEM, itemId);
    }

    @Override
    public Integer countItem(Integer sellerId) {
        return itemMapper.count(sellerId);
    }

    @Override
    public List<ItemVO> itemListBySellerId(Integer sellerId) {
        List<ItemVO> listVO = itemMapper.getItemBySellerId(sellerId);
        return listVO;
    }

    @Override
    public ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId) {

        ItemVO itemVO = itemMapper.getItemByItemId(room,itemId);
        if(Objects.isNull(itemVO)){
            return null;
        }
        RoomVO roomVO = roomMapper.getRoomByItemId(itemId);

        ItemRoomResponseDTO itemRoomResponseDTO = ItemRoomResponseDTO.of(itemVO);
        itemRoomResponseDTO.setRoomVO(roomVO);

        return itemRoomResponseDTO;
    }

    @Override
    public ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId) {

        ItemVO itemVO = itemMapper.getItemByItemId(flight,itemId);
        if(Objects.isNull(itemVO)){
            return null;
        }
        FlightVO flightVO = flightMapper.getFlightByItemId(itemId);

        ItemFlightResponseDTO itemFlightResponseDTO = ItemFlightResponseDTO.of(itemVO);
        itemFlightResponseDTO.setFlightVO(flightVO);

        return itemFlightResponseDTO;
    }

    @Override
    @Transactional
    public void insertItemRoom(ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room, List<MultipartFile> files) {

        ItemVO itemVO = itemRoomRequestDTO.toItemVO();
        RoomVO roomVO = itemRoomRequestDTO.toRoomVO();


        if (files == null || files.isEmpty()) return;

        AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ROOM, itemVO.getItemId());

        if (attachmentVO != null) {
            itemVO.setDetailImg(attachmentVO.getUrl());

            try {
                attachmentMapper.insert(attachmentVO);
                itemMapper.update(itemVO);
            } catch (Exception e) {
                e.printStackTrace();
                AttachmentUtil.deleteAttachment(attachmentVO);
            }
        }

        if (itemVO.getItemCategory().equals(room)) {
            itemMapper.insert(itemVO);
            roomVO.setItemId(itemVO.getItemId());
            roomMapper.insert(roomVO);

        }
    }

    @Override
    @Transactional
    public void insertItemFlight(ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight, List<MultipartFile> files)
        {

            ItemVO itemVO = itemFlightRequestDTO.toItemVO();
            FlightVO flightVO = itemFlightRequestDTO.toFlightVO();

            if (files == null || files.isEmpty()) return;

            AttachmentVO attachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ITEM, itemVO.getItemId());

            if (attachmentVO != null) {
                itemVO.setDetailImg(attachmentVO.getUrl());

                try {
                    attachmentMapper.insert(attachmentVO);
                    itemMapper.update(itemVO);
                } catch (Exception e) {
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(attachmentVO);
                }
            }

            if (itemVO.getItemCategory().equals(flight)) {
                itemMapper.insert(itemVO);
                flightVO.setItemId(itemVO.getItemId());
                flightMapper.insert(flightVO);
            }
        }

    @Override
    @Transactional
    public void updateRoomItem(Integer itemId, ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room, List<MultipartFile> files) {

        ItemVO itemVO = itemRoomRequestDTO.toItemVO();
        RoomVO roomVO = itemRoomRequestDTO.toRoomVO();

        if (files != null && !files.isEmpty()) {
            // 기존 파일 삭제
            List<AttachmentVO> filesToDelete = attachmentMapper.select(AboutTableType.ROOM, itemVO.getItemId());
            AttachmentUtil.deleteAttachments(filesToDelete);
            attachmentMapper.delete(AboutTableType.ROOM, itemVO.getItemId());
            itemVO.setDetailImg("");

            // 새 파일 등록
            AttachmentVO newAttachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ROOM, itemVO.getItemId());

            if (newAttachmentVO != null) {
                itemVO.setDetailImg(newAttachmentVO.getUrl());

                try {
                    attachmentMapper.insert(newAttachmentVO);
                } catch (Exception e){
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(newAttachmentVO);
                }
            }

        }

        if(itemVO.getItemCategory().equals(room)) {

            itemVO.setItemId(itemId);
            itemMapper.update(itemVO);
            roomVO.setItemId(itemVO.getItemId());
            roomMapper.updateByItemId(roomVO);

        }

    }

    @Override
    @Transactional
    public void updateFlightItem(Integer itemId, ItemFlightRequestDTO itemFlightRequestDTO,ItemCategory flight, List<MultipartFile> files) {

        ItemVO itemVO = itemFlightRequestDTO.toItemVO();
        FlightVO flightVO = itemFlightRequestDTO.toFlightVO();

        if (files != null && !files.isEmpty()) {
            // 기존 파일 삭제
            List<AttachmentVO> filesToDelete = attachmentMapper.select(AboutTableType.ITEM, itemVO.getItemId());
            AttachmentUtil.deleteAttachments(filesToDelete);
            attachmentMapper.delete(AboutTableType.ITEM, itemVO.getItemId());
            itemVO.setDetailImg("");

            // 새 파일 등록
            AttachmentVO newAttachmentVO = AttachmentUtil.getAttachment(files.get(0), AboutTableType.ITEM, itemVO.getItemId());

            if (newAttachmentVO != null) {
                itemVO.setDetailImg(newAttachmentVO.getUrl());

                try {
                    attachmentMapper.insert(newAttachmentVO);
                } catch (Exception e){
                    e.printStackTrace();
                    AttachmentUtil.deleteAttachment(newAttachmentVO);
                }
            }

        }

        if(itemVO.getItemCategory().equals(flight)) {

            itemVO.setItemId(itemId);
            itemMapper.update(itemVO);
            flightVO.setItemId(itemVO.getItemId());
            flightMapper.updateByItemId(flightVO);
        }

    }

    // Seller Page 상품관리
    @Override
    public Pagination<ItemRoomResponseDTO> getItemRoomList(Integer sellerId, ItemCategory room, Integer pageSize, Integer currentPage) {

        List<ItemVO> itemVOS = itemMapper.getItemRoomBySellerId(sellerId ,room, pageSize, currentPage);

        List<ItemRoomResponseDTO> responseDTOS = itemVOS.stream()
                .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

        for(ItemRoomResponseDTO itemRoomResponseDTO : responseDTOS) {
            RoomVO roomVO = roomMapper.getRoomByItemId(itemRoomResponseDTO.getItemId());

            itemRoomResponseDTO.setRoomVO(roomVO);
        }

        int totalReviews = itemMapper.countRoom(sellerId, room);

        return new Pagination<>(pageSize, currentPage, totalReviews, responseDTOS);
    }

    @Override
    public Pagination<ItemFlightResponseDTO> getItemFlightList(Integer sellerId, ItemCategory flight, Integer pageSize, Integer currentPage) {

        List<ItemVO> itemVOS = itemMapper.getItemFlightBySellerId(sellerId ,flight, pageSize, currentPage);

        List<ItemFlightResponseDTO> responseDTOS = itemVOS.stream()
                .map(ItemFlightResponseDTO::of).collect(Collectors.toList());

        for(ItemFlightResponseDTO itemFlightResponseDTO : responseDTOS) {
            FlightVO flightVO = flightMapper.getFlightByItemId(itemFlightResponseDTO.getItemId());

            itemFlightResponseDTO.setFlightVO(flightVO);
        }

        int totalReviews = itemMapper.countFlight(sellerId, flight);

        return new Pagination<>(pageSize, currentPage, totalReviews, responseDTOS);
    }

}
