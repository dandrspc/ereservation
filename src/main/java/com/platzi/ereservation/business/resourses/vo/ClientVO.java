package com.platzi.ereservation.business.resourses.vo;
import lombok.Data;


/**
 * A class that reprresents a client table
 * @author dandrspc
 */
@Data
public class ClientVO {

    private String clientId;
    private String name;
    private String lastName;
    private String identification;
    private String phoneNumber;
    private String address;
    private String email;
}
