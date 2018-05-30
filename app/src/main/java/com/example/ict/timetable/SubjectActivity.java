package com.example.ict.timetable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ict.timetable.utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();
        setUpListview();

    }
    private void setupUIViews(){
        toolbar =(Toolbar)findViewById(R.id.toolbarSubject);
        listView= (ListView)findViewById(R.id.lvSubject);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setUpListview(){
        subjects = getResources().getStringArray(R.array.Subjects);

        SubjectAdapter subjectAdapter = new SubjectAdapter(this, R.layout.subject_single_item, subjects);
        listView.setAdapter(subjectAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:break;
                    case 1:break;
                    case 2:break;

                }
            }
        });

    }
    public class SubjectAdapter extends ArrayAdapter {
        private int resource;
        private String[] subject = new String[]{};
        private LayoutInflater layoutInflater;

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subject = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivlogo = (LetterImageView) convertView.findViewById(R.id.ivSubject);
                holder.tvsubject = (TextView) convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.ivlogo.setOval(true);
            holder.ivlogo.setLetter(subject[position].charAt(0));
            holder.tvsubject.setText(subject[position]);

            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivlogo;
            private TextView tvsubject;
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
