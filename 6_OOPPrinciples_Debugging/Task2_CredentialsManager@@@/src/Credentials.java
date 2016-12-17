public class Credentials {
	protected String userName;
	protected String[] password;

	public Credentials(String userName, String[] password) {
		this.userName = userName;
		this.password = password;
	}
	

	String changePass(String newPassword) {
		String result = "";
		for (int i = 0; i <= password.length; i++) {
			if (password[i] == newPassword) {
				result = "CHPASS fail";
			} else if (i == password.length) {
				password[i] = newPassword;
				result = "CHPASS success";
			}
		}
		return result;
	}

	String checkPassword(String inputPassword, String inputUserName) {
		String result = "";
		if (userName == inputUserName) {
			for (int i = password.length - 1; i < password.length; i++) {
				if (password[i] == inputPassword) {
					result = "AUTH success";
				} else {

				}
				result = "AUTH fail";
			}
		}
		return result;
	}
}
