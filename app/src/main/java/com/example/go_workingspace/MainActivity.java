package com.example.go_workingspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.go_workingspace.Data.Contract;
import com.example.go_workingspace.Data.DbHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new DbHelper(this);
        if(Contract.Entry.currentId != -1){
            setContentView(R.layout.activity_main);
            /*String[] projection = {
                    Contract.Entry._ID,
                    Contract.Entry.COLUMN_NAME,
                    Contract.Entry.COLUMN_USERNAME,
                    Contract.Entry.COLUMN_EMAIL
            }; // Add Columns you want to display

            String selection = Contract.Entry._ID + "+?";

            String[] selectionArgs = {
                    String.valueOf(Contract.Entry.currentId)
            };

            Cursor cursor = (Cursor) getContentResolver().query(
                    Contract.Entry.OWNER_CONTENT_URI, projection,
                    selection,
                    selectionArgs,
                    null);

            cursor.moveToNext();

            String name = cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_EMAIL));

            TextView navName = findViewById(R.id.nav_name);
            TextView navEmail = findViewById(R.id.User_email);

            navName.setText(name);
            navEmail.setText(email);*/


            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);
        }
        else{
            Intent signIn = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(signIn);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void goToWorkingspacesList(View view)
    {
        Intent list = new Intent(MainActivity.this, ListActivity.class);
        startActivity(list);
    }

    public void goToProfile(View view)
    {
        Intent Profile = new Intent(MainActivity.this, Userprofile.class);
        startActivity(Profile );
    }

    public void goToBook(View view)
    {
        Intent bookForm = new Intent(MainActivity.this, BookForm.class);
        startActivity(bookForm);
    }

    public void goToCwsProfile(View view)
    {
        Intent cwsProfile = new Intent(MainActivity.this, CwsProfileActivity.class);
        startActivity(cwsProfile);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            Intent main = new Intent(MainActivity.this, MainActivity.class);
            startActivity(main);
        }
        else if (id == R.id.nav_profile)
        {
            Intent user = new Intent(MainActivity.this, Userprofile.class);
            startActivity(user);
        }
        else if (id == R.id.nav_list)
        {
            Intent list = new Intent(MainActivity.this, ListActivity.class);
            startActivity(list);
        }
        else if (id == R.id.nav_Book)
        {
            Intent book = new Intent(MainActivity.this, BookForm.class);
            startActivity(book);
        }
        else if (id == R.id.nav_share) {
            Contract.Entry.currentId = -1;
            Intent signIn = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(signIn);
        }
        else if (id == R.id.nav_help)
        {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
