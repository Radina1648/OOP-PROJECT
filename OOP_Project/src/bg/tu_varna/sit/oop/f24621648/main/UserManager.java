package bg.tu_varna.sit.oop.f24621648.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {

	private Map<String,User> users = new HashMap<>();
	private User loggedUser = null;

	public UserManager() {
		users.put("admin",new User("admin", "i<3Java", true));
	}

	public String login(String username, String password) {

		if (loggedUser != null) {
			return "You are already logged in.";
		}

		User user = users.get(username);

		if (user == null) {
			return "User not found.";
		}

		if (!user.getPassword().equals(password)) {
			return "Invalid password.";
		}

		loggedUser = user;
		return "Login successful.";
	}

	public String logout() {
		if (loggedUser == null) {
			return "No user is currently logged in.";
		}

		loggedUser = null;
		return "Successfully logged out.";
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public String addUser(String username, String password) {

		if (loggedUser == null || !loggedUser.isAdmin()) {
			return "Only admin can add users.";
		}

		if (users.containsKey(username)) {
			return "User already exists.";
		}

		users.put(username, new User(username, password, false));
		return "User added successfully.";
	}

	public String removeUser(String username) {

		if (loggedUser == null || !loggedUser.isAdmin()) {
			return "Only admin can remove users.";
		}

		if (!users.containsKey(username)) {
			return "User not found.";
		}

		if (username.equals("admin")) {
			return "Admin cannot be removed.";
		}

		users.remove(username);
		return "User removed successfully.";
	}
}