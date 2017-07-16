package hurstel.aurore.testandroidlunabee.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hurstel.aurore.testandroidlunabee.Adapter.UserAdapter;
import hurstel.aurore.testandroidlunabee.Class.User;
import hurstel.aurore.testandroidlunabee.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<User> userList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = initUserList();

        final EditText searchEditText = (EditText) findViewById(R.id.search_bar);
        final ImageView search = (ImageView) findViewById(R.id.search);

        final LinearLayout userDoesNotExist = (LinearLayout) findViewById(R.id.user_does_not_exist);
        userDoesNotExist.setVisibility(View.GONE);

        final ListView userListView = (ListView) findViewById(R.id.user_listview);

        userAdapter = new UserAdapter(userList, getBaseContext());
        userListView.setAdapter(userAdapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = searchEditText.getText().toString();

                if (!editTextContent.equals("")) {
                    if (userExists(editTextContent)) {
                        Intent intent = new Intent(getBaseContext(), UserActivity.class);
                        intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_NO_ANIMATION);

                        intent.putExtra("firstName", editTextContent);

                        getBaseContext().startActivity(intent);
                    } else {
                        userDoesNotExist.setVisibility(View.VISIBLE);

                        final TextView userNotFoundFirstName = (TextView) findViewById(R.id.user_not_found);
                        userNotFoundFirstName.setText(editTextContent);
                    }
                }

                // Close the keyboard
                if (v != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
    }

    private ArrayList<User> initUserList() {
        ArrayList<User> tempUserList = new ArrayList<>();

        tempUserList.add(new User("FirstName1", "LastName1", "https://randomuser.me/api/portraits/women/31.jpg", "user1@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName2", "LastName2", "https://randomuser.me/api/portraits/women/86.jpg", "user2@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName3", "LastName3", "https://randomuser.me/api/portraits/women/6.jpg", "user3@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName4", "LastName4", "https://randomuser.me/api/portraits/women/29.jpg", "user4@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName5", "LastName5", "https://randomuser.me/api/portraits/women/52.jpg", "user5@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName6", "LastName6", "https://randomuser.me/api/portraits/women/3.jpg", "user6@email.com", "Female", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName7", "LastName7", "https://randomuser.me/api/portraits/men/10.jpg", "user7@email.com", "Male", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName8", "LastName8", "https://randomuser.me/api/portraits/men/30.jpg", "user8@email.com", "Male", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName9", "LastName9", "https://randomuser.me/api/portraits/men/50.jpg", "user9@email.com", "Male", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName10", "LastName10", "https://randomuser.me/api/portraits/men/92.jpg", "user10@email.com", "Male", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName11", "LastName11", "https://randomuser.me/api/portraits/men/34.jpg", "user11@email.com", "Male", "01-01-01", "06 00 00 00 00"));
        tempUserList.add(new User("FirstName12", "LastName12", "https://randomuser.me/api/portraits/men/7.jpg", "user12@email.com", "Male", "01-01-01", "06 00 00 00 00"));

        return tempUserList;
    }

    public static User getUserByFirstName(String firstName) {
        for (User user : userList) {
            if (user.getFirstName().equals(firstName))
                return user;
        }
        return null;
    }

    private boolean userExists(String firstName) {
        return (getUserByFirstName(firstName) != null);
    }

    @Override
    public void onBackPressed() {
    }
}
