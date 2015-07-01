package ume_studios.example.com.hirakana;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class InstructionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        ImageView imgInstructions = (ImageView) findViewById(R.id.imgInstruction);
        imgInstructions.setImageResource(R.drawable.instructionsbg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.instruction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_showHiraTable:
                showHiraTable();
                return true;
            case R.id.action_showKataTable:
                showKataTable();
                return true;
            case R.id.action_showHirakanaTable:
                showHirakanaTable();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Methods to show the cheat tables
     */
    public void showHiraTable(){
        //Create the alert builder, and set the view to the dialog XML file
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = InstructionActivity.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.hiratable_dialog,null);
        //Set the view into the builder
        builder.setView(v);
        //Confirm Button
        builder.setPositiveButton("Done",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showKataTable(){
        //Create the alert builder, and set the view to the dialog XML file
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = InstructionActivity.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.katatable_dialog,null);
        //Set the view into the builder
        builder.setView(v);
        //Confirm Button
        builder.setPositiveButton("Done",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showHirakanaTable(){
        //Create the alert builder, and set the view to the dialog XML file
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = InstructionActivity.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.hirakanatable_dialog,null);
        //Set the view into the builder
        builder.setView(v);
        //Confirm Button
        builder.setPositiveButton("Done",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
