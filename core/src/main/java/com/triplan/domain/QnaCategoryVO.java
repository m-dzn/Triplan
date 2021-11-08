package com.triplan.domain;

import com.triplan.enumclass.Inquirer;
import lombok.Data;

@Data
public class QnaCategoryVO {
    private Integer qnaCategoryId;
    private Inquirer inquirer;
    private String categoryName;
}