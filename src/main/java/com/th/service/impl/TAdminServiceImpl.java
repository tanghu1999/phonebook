package com.th.service.impl;

import com.th.entity.TAdmin;
import com.th.service.TAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TAdminServiceImpl extends BaseServiceImpl<TAdmin> implements TAdminService {
	
}
