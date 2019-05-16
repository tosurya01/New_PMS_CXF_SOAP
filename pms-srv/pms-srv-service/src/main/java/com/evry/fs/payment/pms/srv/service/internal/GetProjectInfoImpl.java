package com.evry.fs.payment.pms.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.ProjectDao;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.service.GetProjectInfo;
@Component("getProjectInfo")
public class GetProjectInfoImpl implements GetProjectInfo {
	@Autowired
	ProjectDao projectDao;
	public GetProjectInfoResponse getProjectInfo(GetProjectInfoRequest getProjectInfoRequest) {
		return projectDao.getProjectInfo(getProjectInfoRequest);
	}

}
