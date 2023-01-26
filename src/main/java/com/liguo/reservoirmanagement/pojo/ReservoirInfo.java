package com.liguo.reservoirmanagement.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * reservoir_info
 * @author 
 */
@Data
public class ReservoirInfo implements Serializable {
    private Integer id;

    @JsonProperty("reservoir_name")
    private String reservoirName;

    private String address;

    @JsonProperty("completion_date")
    private String completionDate;

    private String describe;

    private static final long serialVersionUID = 1L;
}