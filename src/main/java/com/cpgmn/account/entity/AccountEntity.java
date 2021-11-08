package com.cpgmn.account.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class AccountEntity {
    @Id
    @NonNull
    @Builder.Default
    private UUID id = UUID.randomUUID();
    @NonNull
    private BigDecimal balance;
    @NonNull
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    CustomerEntity customer;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    Set<TransactionEntity> transactions = new HashSet<>();
}
