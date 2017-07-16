package hurstel.aurore.testandroidlunabee.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hurstel.aurore.testandroidlunabee.Class.User;
import hurstel.aurore.testandroidlunabee.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class UserActivity extends Activity {

    private String firstName;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);

        firstName = (String) getIntent().getSerializableExtra("firstName");
        user = MainActivity.getUserByFirstName(firstName);

        final TextView pageName = (TextView) findViewById(R.id.page_name);
        final ImageView backArrow = (ImageView) findViewById(R.id.back);

        final ImageView picture = (ImageView) findViewById(R.id.picture);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView gender = (TextView) findViewById(R.id.gender);
        final TextView dob = (TextView) findViewById(R.id.dob);
        final TextView cell = (TextView) findViewById(R.id.cell);

        pageName.setText(user.getFirstName() + " " + user.getLastName());

        Picasso.with(getBaseContext()).load(user.getPictureAdress()).into(picture);
        email.setText(user.getEmail());
        gender.setText(user.getGender());
        dob.setText(user.getDob());
        cell.setText(user.getCell());

        backArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_NO_ANIMATION);

                getBaseContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
