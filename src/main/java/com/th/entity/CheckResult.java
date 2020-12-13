package com.th.entity;

import io.jsonwebtoken.Claims;


public class CheckResult {

    private int errCode;

    private boolean success;

    private Claims claims; //Claims: Claims包含您想要签署的任何信息

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

}
