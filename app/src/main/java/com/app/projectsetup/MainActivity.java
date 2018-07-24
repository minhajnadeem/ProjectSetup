package com.app.projectsetup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.projectsetup.interfaces.CustomDialogInterface;
import com.app.projectsetup.utils.CustomDialogs;

public class MainActivity extends AppCompatActivity {

    private CustomDialogs mCustomDialogs;
    private CustomDialogInterface mDialogInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void showMessageDialog(View view) {
        CustomDialogs.MessageDialog messageDialog = mCustomDialogs.new MessageDialog(this);
        messageDialog.show("Hello world.");
    }

    public void showAlertDialog(View view) {
        CustomDialogs.AlertDialog  alertDialog = mCustomDialogs.new AlertDialog(this,mDialogInterface);
        alertDialog.show("Heads up alert!");
    }
}
