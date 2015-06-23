package com.bryhas.project.mailrutest.data;

/**
 * @author Andrew
 *
 */

public class UserRepository {

	public static IUser getTestUser() {
		return User.get()
			.setLoginName("tsiberbiller")
			.setPassword("heilmeinfuhrer")
			.setEmail("tsiberbiller@mail.ru")
			.build();
	}

}
