package com.matheus.matheuslog.domain.model;

import com.matheus.matheuslog.domain.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Deliver {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Receiver receiver;

    private BigDecimal fee;

    @OneToMany(mappedBy = "deliver", cascade = CascadeType.ALL)
    private List<Occurence> occurences = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DeliverStatus status;

    private OffsetDateTime orderDate;

    private OffsetDateTime finalDate;

    public Occurence addOcurrence(String description) {
        Occurence occurence = new Occurence();
        occurence.setDescription(description);
        occurence.setRegisterDate(OffsetDateTime.now());
        occurence.setDeliver(this);

        this.getOccurences().add(occurence);

        return occurence;
    }

    public void complete() {
        if (shouldNotBeCompleted()) throw new DomainException("Deliver can't be completed");
        setStatus(DeliverStatus.DONE);
        setFinalDate(OffsetDateTime.now());
    }

    public boolean shouldBeCompleted() {
        return DeliverStatus.PENDING.equals(getStatus());
    }

    public boolean shouldNotBeCompleted() {
        return !shouldBeCompleted();
    }
}
