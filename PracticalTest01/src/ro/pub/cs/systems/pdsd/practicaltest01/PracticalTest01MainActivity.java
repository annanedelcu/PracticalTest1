package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	
	protected EditText left, right;
	protected ButtonClickListener l = new ButtonClickListener();
	
	
	protected class ButtonClickListener implements OnClickListener{
		
		@Override
		@SuppressWarnings("all")
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.leftButton:
				left.setText(String.valueOf(Integer.parseInt(left.getText().toString()) + 1));
				break;
				
			case R.id.rightButton:
				right.setText(String.valueOf(Integer.parseInt(right.getText().toString()) + 1));
				break;
				
			case R.id.navButton:
		          Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
		          intent.putExtra("number_of_clicks",
		            String.valueOf(
		              Integer.parseInt(left.getText().toString())
		              + Integer.parseInt(right.getText().toString())
		            ));
		          startActivityForResult(intent, 1);
		          break;
			}
		}
		
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        left = (EditText) findViewById(R.id.leftText);
        
        Button leftButton = (Button)findViewById(R.id.leftButton);
        
        leftButton.setOnClickListener(l);
        
        right = (EditText) findViewById(R.id.rightText);
        
        Button rightButton = (Button)findViewById(R.id.rightButton);
        
        rightButton.setOnClickListener(l);
        
        Button navButton = (Button)findViewById(R.id.navButton);
        
        navButton.setOnClickListener(l);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
    }
}
