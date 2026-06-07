package com.helpdesk.api.ticket.domain;

import com.helpdesk.api.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private String status;
    @ManyToOne
    private User assignee;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}
