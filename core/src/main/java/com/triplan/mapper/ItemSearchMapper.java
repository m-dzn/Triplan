package com.triplan.mapper;

import com.triplan.domain.ItemScheduleVO;
import com.triplan.dto.response.AccommodationCardResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ItemSearchMapper {
    List<ItemScheduleVO> getList();

    List<AccommodationCardResponseDTO> getFilterAndSort(@Param("startDate") LocalDateTime startDate,
                                                        @Param("endDate") LocalDateTime endDate,
                                                        @Param("underPrice") Integer underPrice,
                                                        @Param("overPrice") Integer overPrice,
                                                        @Param("tags") List<Integer> tags,
                                                        @Param("sortType") String sortType,
                                                        @Param("pageSize") Integer pageSize,
                                                        @Param("currentPage") Integer currentPage);

    Integer getCount(@Param("startDate") LocalDateTime startDate,
                     @Param("endDate") LocalDateTime endDate,
                     @Param("underPrice") Integer underPrice,
                     @Param("overPrice") Integer overPrice,
                     @Param("tags") List<Integer> tags);

}
