package ume_studios.example.com.hirakana;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.content.Context;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HiraKana - Main Menu");
    }

    //Vibrate Method
    //Causes button presses to vibrate for 25ms
    public void vibrate(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(25);
    }

    //Launches the Instructions activity
    public void toInstructions(View view){
        Intent intent = new Intent(this, InstructionActivity.class);
        vibrate();
        startActivity(intent);
    }

    //Launches the Hiragana activity
    public void toHiragana(View view){
        Intent intent = new Intent(this, HiraganaActivity.class);
        vibrate();
        startActivity(intent);
    }

    //Launches the Katakana activity
    public void toKatakana(View view){
        Intent intent = new Intent(this, KatakanaActivity.class);
        vibrate();
        startActivity(intent);
    }

    //Launches the HiraKana activity
    public void toHirakana(View view){
        Intent intent = new Intent(this, HirakanaActivity.class);
        vibrate();
        startActivity(intent);
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
        return super.onOptionsItemSelected(item);
    }
}
