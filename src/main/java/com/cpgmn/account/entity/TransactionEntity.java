package com.cpgmn.account.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @NonNull
    @Builder.Default
    UUID id = UUID.randomUUID();
    BigDecimal amount;
    @NonNull
    @CreationTimestamp
    @Column(name = "transaction_date")
    LocalDateTime transactionDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    AccountEntity account;
}
