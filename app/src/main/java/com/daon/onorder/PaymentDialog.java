package com.daon.onorder;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PaymentDialog extends Dialog {
    private Context context;
    private PaymentDialogClickListener paymentDialogClickListener;
    private TextView tvTitle, tvNegative, tvPositive;

    public PaymentDialog(@NonNull Context context, PaymentDialogClickListener paymentDialogClickListener) {
        super(context);
        this.context = context;
        this.paymentDialogClickListener = paymentDialogClickListener;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_paymentlayout);

        tvPositive = findViewById(R.id.option_codetype_dialog_positive);
        tvNegative = findViewById(R.id.option_codetype_dialog_negative);

        tvPositive.setOnClickListener(v -> {
            // 저장버튼 클릭
            this.paymentDialogClickListener.onPositiveClick();
            dismiss();
        });
        tvNegative.setOnClickListener(v -> {
            // 취소버튼 클릭
            this.paymentDialogClickListener.onNegativeClick();
            dismiss();
        });

    }
}
