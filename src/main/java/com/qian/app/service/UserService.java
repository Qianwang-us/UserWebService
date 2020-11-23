package com.qian.app.service;

import com.qian.app.ui.model.request.UserDetailsRequestModel;
import com.qian.app.ui.model.response.UserRest;

public interface UserService {

	public UserRest createUser(UserDetailsRequestModel userDetails);
}
