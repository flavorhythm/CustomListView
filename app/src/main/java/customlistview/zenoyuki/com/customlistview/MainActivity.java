package customlistview.zenoyuki.com.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView theList;
    private CustomListViewAdapter adapter;

    //private TextView view = (TextView)findViewById(R.id.title_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[] {
                 "See dog run"
                ,"Run dog run"
                ,"See dog skip"
                ,"Run skip run"
                ,"Babylon"
                ,"Space 2001"
        };

        final String[] bookPages = new String[] {
                 "300"
                ,"250"
                ,"400"
                ,"190"
                ,"270"
                ,"100"
        };

        final String[] bookAuthors = new String[] {
                 "John Powers"
                ,"Jason Derulo"
                ,"Bob Jenkins"
                ,"Fiona Glennan"
                ,"Zachary Zanzibar"
                ,"Bruno Mars"
        };

        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();

        for(int i = 0; i < bookTitles.length; i++) {
            HashMap<String, String> data = new HashMap<>();

            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", bookAuthors[i]);

            bookList.add(data);
        }

        theList = (ListView)findViewById(R.id.list_ID);

        adapter = new CustomListViewAdapter(getApplicationContext(), bookList);
        theList.setAdapter(adapter);

        theList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position;
                String itemClickedID = theList.getItemAtPosition(pos).toString();

                Toast.makeText(getApplicationContext(), "ID Clicked: " + itemClickedID, Toast.LENGTH_LONG).show();
            }
        });
    }
}
