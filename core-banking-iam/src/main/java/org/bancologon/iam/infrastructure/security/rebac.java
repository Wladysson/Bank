package com.corebanking.iam.security;

public final class RBAC {

    private RBAC() {}

    // Roles
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String AUDITOR = "AUDITOR";
    public static final String CREATE_ACCOUNT = "CREATE_ACCOUNT";
    public static final String VIEW_ACCOUNT = "VIEW_ACCOUNT";
    public static final String TRANSFER_FUNDS = "TRANSFER_FUNDS";
    public static final String VIEW_AUDIT_LOGS = "VIEW_AUDIT_LOGS";
}