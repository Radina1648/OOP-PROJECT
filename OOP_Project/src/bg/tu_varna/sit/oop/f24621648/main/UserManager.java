package bg.tu_varna.sit.oop.f24621648.main;

/**
 * Клас за управление на потребителите.
 */

import java.util.HashMap;
import java.util.Map;

public class UserManager {

	private Map<String,User> users = new HashMap<>();
	private User loggedUser = null;

	/**
	 * Създава UserManager и добавя admin потребител.
	 */

	public UserManager() {
		users.put("admin",new User("admin", "i<3Java", true));
	}

	/**
	 * Проверява login информацията.
	 *
	 * @param username потребителско име
	 * @param password парола
	 * @return резултат от login операцията
	 */

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

	/**
	 * Излиза от текущия профил.
	 *
	 * @return резултат от logout операцията
	 */

	public String logout() {
		if (loggedUser == null) {
			return "No user is currently logged in.";
		}

		loggedUser = null;
		return "Successfully logged out.";
	}

	/**
	 * Връща текущо влязлия потребител.
	 *
	 * @return влязлия потребител
	 */

	public User getLoggedUser() {
		return loggedUser;
	}

	/**
	 * Добавя нов потребител.
	 *
	 * @param username потребителско име
	 * @param password парола
	 * @return резултат от операцията
	 */

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

	/**
	 * Премахва потребител.
	 *
	 * @param username потребителско име
	 * @return резултат от операцията
	 */

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