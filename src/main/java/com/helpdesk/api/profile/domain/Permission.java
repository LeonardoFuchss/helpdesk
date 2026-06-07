package com.helpdesk.api.profile.domain;

public enum Permission {
    // Usuários
    USER_CREATE,
    USER_READ,
    USER_UPDATE,
    USER_DELETE,

    // Perfis
    PROFILE_CREATE,
    PROFILE_READ,
    PROFILE_UPDATE,
    PROFILE_DELETE,

    // Chamados
    TICKET_CREATE,
    TICKET_READ,
    TICKET_UPDATE,
    TICKET_DELETE,
    TICKET_ASSIGN,
    TICKET_CLOSE,
    TICKET_REOPEN,

//    // Comentários
//    COMMENT_CREATE,
//    COMMENT_UPDATE,
//    COMMENT_DELETE,
//
//    // Categorias
//    CATEGORY_CREATE,
//    CATEGORY_READ,
//    CATEGORY_UPDATE,
//    CATEGORY_DELETE,
//
//    // Relatórios
//    REPORT_VIEW,
//
//    // Administração
//    SYSTEM_ADMIN
}
