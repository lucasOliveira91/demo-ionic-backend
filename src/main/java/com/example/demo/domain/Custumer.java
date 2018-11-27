package com.example.demo.domain;

import com.example.demo.domain.enums.CustumerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.example.demo.domain.enums.Role;

/**
 * Created by loliveira on 17/11/18.
 */
@Entity
@Data
@AllArgsConstructor
public class Custumer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfCnpj;
    private Integer custumerType;

    @JsonIgnore
    private String password;

    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> celPhones = new HashSet<>();

    @OneToMany(mappedBy = "custumer", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "custumer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles")
    private Set<Integer> roles = new HashSet<>();

    public Custumer() {
        addRole(Role.CUSTUMER);
    }

    public Custumer(Integer id, String name, String email, String cpfCnpj, CustumerType custumerType, String password) {
        addRole(Role.CUSTUMER);

        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.custumerType = custumerType != null ? custumerType.getId() : null;
        this.password = password;
    }

    public Set<Role> getRoles () {
        return roles.stream().map(r -> Role.toEnum(r)).collect(Collectors.toSet());
    }

    public void addRole(Role role){
        roles.add(role.getId());
    }
}
