package customlistview.zenoyuki.com.customlistview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zyuki on 11/12/2015.
 * This is not the ideal way to create custom Adapters
 */
public class CustomListViewAdapter extends BaseAdapter {

    //Initialize variables to be used within the Constructor and onwards
    private Context mContext;
    private ArrayList<HashMap<String, String>> books; //An arraylist of hashmaps. Initializations look like this
    private static LayoutInflater inflater = null; //Retrieves (gets, inflates) XML files within the resource folder

    //Constructor
    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        mContext = context;
        books = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Gets LayoutInflater ready...?
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(convertView == null) {
            view = inflater.inflate(R.layout.list_row, null);

            //Because this is a Java class and not an "Activity", we must specify which "view" to retrieve the ID from?
            //This means we must call findViewById via "view.", which is the list_row view
            TextView title = (TextView)view.findViewById(R.id.title_ID);
            TextView author = (TextView)view.findViewById(R.id.author_ID);
            TextView pages = (TextView)view.findViewById(R.id.pages_ID);
            ImageView image = (ImageView)view.findViewById(R.id.image_ID);

            HashMap<String, String> mBook = books.get(position);

            title.setText(mBook.get("title"));
            author.setText(mBook.get("author"));
            pages.setText(mBook.get("pages"));
            image.setImageDrawable(ContextCompat.getDrawable(mContext.getApplicationContext(), R.drawable.ic_launcher));
        }

        return view;
    }
}