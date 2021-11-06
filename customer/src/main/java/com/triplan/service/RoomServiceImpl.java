package com.triplan.service;

import com.triplan.domain.RoomVO;
import com.triplan.mapper.RoomMapper;
import com.triplan.service.inf.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;

    @Override
    public void roomInsert(RoomVO roomVO) {
        roomMapper.insert(roomVO);
    }

    @Override
    public RoomVO roomSelect(Integer roomId) {
        return roomMapper.select(roomId);
    }

    @Override
    public void roomUpdate(RoomVO roomVO) {
        roomMapper.update(roomVO);
    }

    @Override
    public void roomDelete(Integer roomId) {
        roomMapper.delete(roomId);
    }
}
