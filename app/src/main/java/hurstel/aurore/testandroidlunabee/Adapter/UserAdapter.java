package hurstel.aurore.testandroidlunabee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import hurstel.aurore.testandroidlunabee.Activity.UserActivity;
import hurstel.aurore.testandroidlunabee.Class.User;
import hurstel.aurore.testandroidlunabee.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.user_adapter, parent, false);
        }

        TextView firstName = (TextView) convertView.findViewById(R.id.first);
        TextView lastName = (TextView) convertView.findViewById(R.id.last);
        ImageView picture = (ImageView) convertView.findViewById(R.id.picture);

        firstName.setText(users.get(position).getFirstName());
        lastName.setText(users.get(position).getLastName());
        Picasso.with(context).load(users.get(position).getPictureAdress()).into(picture);

        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_NO_ANIMATION);

                intent.putExtra("firstName", users.get(position).getFirstName());

                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
