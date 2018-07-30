package com.app.projectsetup;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.app.projectsetup.interfaces.CustomDialogInterface;
import com.app.projectsetup.utils.CustomDialogs;

public class MainActivity extends AppCompatActivity {

    private CustomDialogs mCustomDialogs;
    private CustomDialogInterface mDialogInterface;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        mDrawerLayout = findViewById(R.id.drawer_layout);

        mCustomDialogs = new CustomDialogs(this);

        mDialogInterface = new CustomDialogInterface() {
            @Override
            public void onButtonClick() {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegativeButtonClick() {
                Toast.makeText(MainActivity.this, "negative click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPositiveButtonClick() {
                Toast.makeText(MainActivity.this, "positive click", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setupToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    public void showMessageDialog(View view) {
        CustomDialogs.MessageDialog messageDialog = mCustomDialogs.new MessageDialog(this);
        messageDialog.show("Hello world.");
    }

    public void showAlertDialog(View view) {
        CustomDialogs.AlertDialog  alertDialog = mCustomDialogs.new AlertDialog(this,mDialogInterface);
        alertDialog.show("Heads up alert!");
    }

    public void newActivity(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
