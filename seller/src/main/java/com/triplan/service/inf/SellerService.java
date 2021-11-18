package com.triplan.service.inf;

import com.triplan.domain.SellerVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SellerService {

    void register(SellerVO sellerVO, List<MultipartFile> files);

    SellerVO getSeller(Integer sellerId);

    void update(Integer sellerId, SellerVO sellerVO);

    void delete(Integer sellerId);

}
