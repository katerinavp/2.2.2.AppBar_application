package com.example.a222androidpetukhova_appbar_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DeadlineActivity extends AppCompatActivity {

    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndtDateCalendar;
    private Button mBtnOK;
    private long mStartDate;
    private String mStartDateTxt = "";
    private long mEndDate;
    private String mEndDateTxt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);
        initViews();

    }

    private void initViews() {
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndtDateCalendar = findViewById(R.id.endtDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);

        // Скроем календари при запуске приложения
        mStartDateCalendar.setVisibility(View.GONE);
        mEndtDateCalendar.setVisibility(View.GONE);
        setOnClickListener();
    }

    private void setOnClickListener() {
        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndtDateCalendar.setVisibility(View.GONE);
            }
        });

        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEndtDateCalendar.setVisibility(View.VISIBLE);
                mStartDateCalendar.setVisibility(View.GONE);
            }
        });
        setOnDateChangeListener();
    }

    private void setOnDateChangeListener() {
        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i + "-" + (i1 + 1) + "-" + i2;
                mChooseStartDate.setText("Дата-время старта задачи: " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mEndtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i + "-" + (i1 + 1) + "-" + i2;
                mChooseEndDate.setText("Дата-время окончания задачи: " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);

            }
        });
        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mStartDateTxt.isEmpty() && mEndDateTxt.isEmpty())) {
                    Toast.makeText(DeadlineActivity.this, "Выберите дату старта задачи и дату окончания задачи ", Toast.LENGTH_LONG).show();

                }

                if ((!(mStartDateTxt.isEmpty()) && mEndDateTxt.isEmpty())) {
                    Toast.makeText(DeadlineActivity.this, "Выберите дату окончания задачи ", Toast.LENGTH_LONG).show();
                }
                if (((mStartDateTxt.isEmpty()) && !(mEndDateTxt.isEmpty()))) {
                    Toast.makeText(DeadlineActivity.this, "Выберите дату окончания задачи ", Toast.LENGTH_LONG).show();
                } else if ((!(mStartDateTxt.isEmpty()) && !(TextUtils.isEmpty(mEndDateTxt)))) {
                    if (mStartDate > mEndDate) {
                        Toast.makeText(DeadlineActivity.this, "Ошибка: дата окончания задачи не может быть раньше даты старта задачи", Toast.LENGTH_LONG).show();
                        mChooseStartDate.setText("Дата-время старта задачи:");
                        mChooseEndDate.setText("Дата-время окончания задачи:");
                    } else {
                        Toast.makeText(DeadlineActivity.this, "старт: " + mStartDateTxt + " окончаниe: " + mEndDateTxt, Toast.LENGTH_LONG).show();
                        mChooseStartDate.setText("Дата-время старта задачи: " + "");
                        mChooseEndDate.setText("Дата-время окончания задачи: " + "");
                        mEndDateTxt = "";
                        mStartDateTxt ="";

                    }

                }
            }

        });
    }
}




