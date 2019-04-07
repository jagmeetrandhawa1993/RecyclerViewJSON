package com.example.recyclerviewjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerviewjson.Adapter.StudentAdapter;
import com.example.recyclerviewjson.Model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Object> mRecyclerViewItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);



        RecyclerView.Adapter adapter = new StudentAdapter(this, mRecyclerViewItems);
        mRecyclerView.setAdapter(adapter);

        addMenuItemsFromJson();
    }



    private void addMenuItemsFromJson()  {
        try {
            String jsonDataString = readJsonDataFromFile();
            JSONArray menuItemsJsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < menuItemsJsonArray.length(); i++) {

                JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

                String menuItemId = menuItemObject.getString("sid");
                String menuItemName = menuItemObject.getString("sname");
                String menuItemGender = menuItemObject.getString("gender");


                Student student = new Student(menuItemId, menuItemName,
                        menuItemGender);
                mRecyclerViewItems.add(student);
            }
        } catch (JSONException exception) {
            Log.e(MainActivity.class.getName(), "Unable to parse JSON file.", exception);
        }
    }

    public String readJsonDataFromFile() {
        String json;
        try {
            InputStream is = getAssets().open("studentdetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
