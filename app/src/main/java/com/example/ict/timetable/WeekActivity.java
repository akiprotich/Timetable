package com.example.ict.timetable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ict.timetable.utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        setupUIViews();
        initToolbar();

        setupListView();
    }
    private void setupUIViews(){
        toolbar =(android.support.v7.widget.Toolbar)findViewById(R.id.toolbarWeek);
        listView= (ListView)findViewById(R.id.lvWeek);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setupListView(){
        String[] week = getResources().getStringArray(R.array.Week);
        WeekAdapter weekAdapter = new WeekAdapter(this,R.layout.week_activity_single_item, week);

        listView.setAdapter(weekAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{break;}
                    case 1:{break;}
                    case 2:{break;}
                    case 3:{break;}
                    case 4:{break;}
                    case 5:{break;}
                    case 6:{break;}
                    default:{break;}
                }
            }
        });

    }
    public class WeekAdapter extends ArrayAdapter  {
        private int resource;
        private String[] week = new String[]{};
        private LayoutInflater layoutInflater;

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView) convertView.findViewById(R.id.ivLetter);
                holder.tvWeek = (TextView) convertView.findViewById(R.id.tvWeek);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);

            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvWeek;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}