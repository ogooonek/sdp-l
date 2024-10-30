package presenter;

import model.UserCredentials;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;

        this.view.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = view.getUsername();
        String password = view.getPassword();
        UserCredentials user = new UserCredentials(username, password);

        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            view.showMessage("Login successful!");
        } else {
            view.showMessage("Invalid credentials.");
        }
    }
}
