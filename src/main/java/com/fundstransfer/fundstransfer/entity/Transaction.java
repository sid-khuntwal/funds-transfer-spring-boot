package com.fundstransfer.fundstransfer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private User receiver;

    private int ammount;

}
