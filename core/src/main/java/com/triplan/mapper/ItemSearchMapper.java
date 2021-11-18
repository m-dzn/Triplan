package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemScheduleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ItemSearchMapper {
    List<ItemScheduleVO> getList();

    List<ItemGroupVO> getFilterAsDateDistinct(@Param("startDate") LocalDateTime startDate,
                                              @Param("endDate") LocalDateTime endDate,
                                              @Param("underPrice") Integer underPrice,
                                              @Param("overPrice") Integer overPrice,
                                              @Param("tags") List<Integer> tags,
                                              @Param("pageSize") Integer pageSize,
                                              @Param("currentPage") Integer currentPage,
                                              @Param("Data") Integer Data);

    Integer getCount(@Param("startDate") LocalDateTime startDate,
                     @Param("endDate") LocalDateTime endDate,
                     @Param("underPrice") Integer underPrice,
                     @Param("overPrice") Integer overPrice,
                     @Param("tags") List<Integer> tags,
                     @Param("Data") Integer Data);

    List<ItemGroupVO> getFilterAndSort(@Param("startDate") LocalDateTime startDate,
                                       @Param("endDate") LocalDateTime endDate,
                                       @Param("underPrice") Integer underPrice,
                                       @Param("overPrice") Integer overPrice,
                                       @Param("tags") List<Integer> tags,
                                       @Param("sortType") String sortType,
                                       @Param("pageSize") Integer pageSize,
                                       @Param("currentPage") Integer currentPage,
                                       @Param("Data") Integer Data);


    List<ItemGroupVO> getSort(List<ItemGroupVO> sortItemGroupId);
}
