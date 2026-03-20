package bg.tu_varna.sit.oop.f24621648;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	private List<User> users = new ArrayList<>();
	private User loggedUser = null;

	public UserManager() {
		users.add(new User("admin", "i<3Java", true));
	}

	public String login(String username, String password) {

		if (loggedUser != null) {
			return "You are already logged in.";
		}

		for (User u : users) {
			if (u.getUsername().equals(username) &&
					u.getPassword().equals(password)) {

				loggedUser = u;
				return "Welcome, " + username + "!";
			}
		}

		return "Invalid username or password.";
	}

	public String logout() {

		if (loggedUser == null) {
			return "No user logged in.";
		} else {
			loggedUser = null;
			return "Logged out.";
		}
	}

	public User getLoggedUser() {
		return loggedUser;
	}
}