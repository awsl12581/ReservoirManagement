package com.liguo.reservoirmanagement.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * reservoir_coordinates
 * @author 
 */
@Data
public class ReservoirCoordinates implements Serializable {
    private Integer id;

    private Integer reservoirId;

    private Double lat;

    private Double lng;

    private String record;

    private static final long serialVersionUID = 1L;
}