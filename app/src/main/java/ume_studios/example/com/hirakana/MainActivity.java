package ume_studios.example.com.hirakana;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HiraKana - Main Menu");
    }

    public void toInstructions(View view){
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }

    public void toHiragana(View view){
        Intent intent = new Intent(this, HiraganaActivity.class);
        startActivity(intent);
    }

    public void toKatakana(View view){
        Intent intent = new Intent(this, KatakanaActivity.class);
        startActivity(intent);
    }

    public void toHirakana(View view){
        Intent intent = new Intent(this, HirakanaActivity.class);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
