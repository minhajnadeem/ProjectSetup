package com.app.projectsetup.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.projectsetup.R;
import com.app.projectsetup.interfaces.CustomDialogInterface;

/**
 * Created by minhaj nadeem on 22/07/2018.
 */
public class CustomDialogs {

    private Context mContext;

    public CustomDialogs(Context context){
        mContext  = context;
    }

    /**
     * message dialog
     */
    public class MessageDialog extends Dialog {

        private Context mContext;
        private ImageView ivCancel;
        private TextView tvMessage;
        private Button btnOk;

        public MessageDialog(Context context){
            this(context,R.style.DialogStyle);
            mContext = context;
        }

        public MessageDialog(@NonNull Context context, int themeResId) {
            super(context, themeResId);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_message);

            ivCancel = findViewById(R.id.ivCancel);
            tvMessage = findViewById(R.id.tvMessage);
            btnOk = findViewById(R.id.btnOk);

            ivCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

        public void show(String message){
            show();
            tvMessage.setText(message);
        }
    }

    /**
     * alert dialog
     */
    public class AlertDialog extends Dialog {

        private Context mContext;
        private ImageView ivCancel;
        private TextView tvMessage;
        private Button positiveBtn, negativeBtn;
        private CustomDialogInterface mDialogInterface;

        public AlertDialog(Context context, CustomDialogInterface dialogInterface){
            this(context,R.style.DialogStyle);
            mContext = context;
            mDialogInterface = dialogInterface;
        }
        public AlertDialog(@NonNull Context context, int themeResId) {
            super(context, themeResId);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_alert_layout);

            ivCancel = findViewById(R.id.ivCancel);
            tvMessage = findViewById(R.id.tvMessage);
            positiveBtn = findViewById(R.id.btnOk);
            negativeBtn = findViewById(R.id.btnNo);

            ivCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            positiveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDialogInterface.onPositiveButtonClick();
                    dismiss();
                }
            });
            negativeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDialogInterface.onNegativeButtonClick();
                    dismiss();
                }
            });
        }

        public void show(String message){
            show();
            tvMessage.setText(message);
        }
    }
}
