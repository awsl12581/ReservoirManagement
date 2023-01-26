package com.liguo.reservoirmanagement.pojo;

import lombok.Data;

/**
 * @author nongChaTea
 * @date 2022/5/23 20:26
 */
@Data
public class CommonInfo extends ReservoirInfo{

    private double lat;
    private double lng;
    private String record;

}
