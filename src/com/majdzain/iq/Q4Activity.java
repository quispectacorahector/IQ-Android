           package com.majdzain.iq;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Q4Activity extends Activity {
	private boolean result;
	private String result1 = "no";
	private int eq = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qu4);
		final Button back = (Button) findViewById(R.id.anse);
		final Button next = (Button) findViewById(R.id.nextq4);
		final RadioButton a = (RadioButton) findViewById(R.id.q4a);
		final RadioButton b = (RadioButton) findViewById(R.id.q4b);
		final RadioButton c = (RadioButton) findViewById(R.id.q4c);
		final RadioButton d = (RadioButton) findViewById(R.id.q4d);
		final MediaPlayer soundnext = MediaPlayer.create(Q4Activity.this , R.raw.button6);
		final MediaPlayer soundback = MediaPlayer.create(Q4Activity.this , R.raw.button1);
		final MediaPlayer soundradio = MediaPlayer.create(Q4Activity.this , R.raw.button9);
		next.setSoundEffectsEnabled(false);
		back.setSoundEffectsEnabled(false);
		a.setSoundEffectsEnabled(false);
		b.setSoundEffectsEnabled(false);
		c.setSoundEffectsEnabled(false);
		d.setSoundEffectsEnabled(false);
		final Intent intentlogin = getIntent();
		a.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundradio.start();
				b.setChecked(false);
				c.setChecked(false);
				d.setChecked(false);
			}
		});
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundradio.start();
				a.setChecked(false);
				c.setChecked(false);
				d.setChecked(false);
			}
		});
		c.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundradio.start();
				a.setChecked(false);
				b.setChecked(false);
				d.setChecked(false);
			}
		});
		d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundradio.start();
				a.setChecked(false);
				b.setChecked(false);
				c.setChecked(false);
			}
		});
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundback.start();
				Intent i = new Intent(Q4Activity.this , MainActivity.class);
				startActivity(i);
			}
		});

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
                    soundnext.start();
					if (a.isChecked()) {
						result = false;
						result1 = "yes";

					} else if (b.isChecked()) {
						result = false;
						result1 = "yes";
					} else if (c.isChecked()) {
						result = false;
						result1 = "yes";
					} else if (d.isChecked()) {
						result = true;
						result1 = "yes";
					}				
					if (result1 == "no") {
				    } else {
					if (result == true)
					{
						eq = eq + 1;
					}
					Intent i = new Intent(Q4Activity.this, Q5Activity.class);
					String name = intentlogin.getExtras().getString("name");
					int age = intentlogin.getExtras().getInt("age");
					int smart = intentlogin.getExtras().getInt("smart");
					eq = eq + intentlogin.getExtras().getInt("eq");
					i.putExtra("name", name);
					i.putExtra("age", age);
					i.putExtra("smart", smart);
					i.putExtra("eq", eq);
					startActivity(i);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qu4, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}