/**
 * 
 */
package com.crazyapps.crazynudgemail;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

/**
 * @author id0
 * 
 */
public class DatePickerActivity extends Activity {

	public static final String	RESULT	= "RESULT";
	private CalendarPickerView	calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_view);

		final Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);

		calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
		calendar.init(new Date(), nextMonth.getTime()) //
				.inMode(SelectionMode.SINGLE) //
				.withSelectedDate(new Date());

		calendar.setOnDateSelectedListener(new OnDateSelectedListener() {

			@Override
			public void onDateUnselected(Date date) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDateSelected(Date date) {

				Intent returnIntent = new Intent();
				returnIntent.putExtra(RESULT, date);
				setResult(RESULT_OK, returnIntent);
				finish();

			}
		});
	}

}
