package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.free.hindi.jokes.R;
import com.free.hindi.jokes.JokesListActivity;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by sneha on 28/3/15.
 */
public class ListAdapter extends ParseQueryAdapter<ParseObject> {

    int i = 0;
    String img;
    protected String itemId;

    public ListAdapter(Context context, QueryFactory<ParseObject> item, String mimage) {
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery<ParseObject> create() {
                ParseQuery query = new ParseQuery(JokesListActivity.mimage);
                return query;
            }
        });
        img = mimage;
    }


    public View getItemView(final ParseObject parseObject, View v, ViewGroup parent) {
        super.getItemView(parseObject, v, parent);
        if (v == null) {
            v = View.inflate(getContext(), R.layout.item_list_jokes, null);
        }

        ImageView mealImage = (ImageView) v.findViewById(R.id.favorite_star);

        if (img.equals("boysgirls")) {
            mealImage.setImageResource(R.drawable.boysgirls);
        }
        if (img.equals("friends")) {
            mealImage.setImageResource(R.drawable.friends);
        }
        if (img.equals("rajini")) {
            mealImage.setImageResource(R.drawable.rajini);
        }
        if (img.equals("relationship")) {
            mealImage.setImageResource(R.drawable.relation);
        }

        TextView titleTextView = (TextView) v.findViewById(R.id.text1);
        titleTextView.setText(parseObject.getString("JokeName"));

        itemId = parseObject.getObjectId();
        System.out.println(itemId);
        return v;
    }


}
