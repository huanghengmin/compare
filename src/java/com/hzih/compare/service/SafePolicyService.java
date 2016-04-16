package com.hzih.compare.service;

import com.hzih.compare.domain.SafePolicy;

public interface SafePolicyService {

	SafePolicy getData();

    public String select() throws Exception;

    public String update(SafePolicy safePolicy) throws Exception;

    public String selectPasswordRules() throws Exception;
}
