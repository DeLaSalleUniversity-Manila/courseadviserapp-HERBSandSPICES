package com.example.user.courseadviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CourseAdviser extends AppCompatActivity {

    private CourseList coursesList = new CourseList();


    public void Clicked(View view){
        Spinner spinner = (Spinner) findViewById(R.id.TermsListComboBox);

        TextView ViewList = (TextView) findViewById(R.id.CoursesListingOutput);

        String TermSelected = String.valueOf(spinner.getSelectedItem());

        List<String> TermCourseList = coursesList.getCourses(TermSelected);

        StringBuilder FormatCourse = new StringBuilder();

        for (String course: TermCourseList)
            FormatCourse.append(course).append('\n');

        ViewList.setText(FormatCourse);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_adviser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_adviser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
