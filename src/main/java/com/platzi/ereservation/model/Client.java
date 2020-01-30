package com.platzi.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

/**
 * A class that reprresents a client table
 * @author dandrspc
 */
@Data
@Entity
@Table(name = "clients")
@NamedQuery(name = "Client.findByIdentification", query = "SELECT c FROM Client c WHERE c.identification = ?1")
public class Client {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String clientId;
    private String name;
    private String lastName;
    private String identification;
    private String phoneNumber;
    private String address;
    private String email;
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
}
