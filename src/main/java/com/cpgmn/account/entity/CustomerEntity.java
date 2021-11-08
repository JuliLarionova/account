package com.cpgmn.account.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @NonNull
    @Builder.Default
    UUID id = UUID.randomUUID();
    @NonNull
    String name;
    String surname;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    Set<AccountEntity> accounts;
}
