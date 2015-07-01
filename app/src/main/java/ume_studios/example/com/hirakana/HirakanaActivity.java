package ume_studios.example.com.hirakana;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.Random;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/*****************
 * Class Breakdown
 * ***************
 * -Android onCreate methods
 * -AlertDialog Difficulty method
 * -Global Variables
 * -Getter/Setter methods (difficulty, key, highest)
 * -newCard() method
 * -drawLetter() method
 * -btnMethods A-Z, Delete, Submit
 */
public class HirakanaActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirakana);
        newCard();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hirakana, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_difficulty:
                changeDifficulty();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Method to run the dialog box for changing the game difficulty
     */
    public void changeDifficulty(){
        //Create the alert builder, and set the view to the dialog XML file
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = HirakanaActivity.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.difficulty_dialog,null);

        //Set the view into the builder, and set the title for the dialog
        builder.setView(v);
        builder.setTitle("Difficulty Level");

        //Initialize the seekBar
        SeekBar seek = (SeekBar)v. findViewById(R.id.seekDiff);
        seek.setMax(14);
        seek.setProgress(getDifficulty());

        //Set-up the textviews
        TextView diffCurrent = (TextView)v. findViewById(R.id.txtCurrent);
        diffCurrent.setText("Current Difficulty level: " + levels[getDifficulty()]);
        final TextView diffNew = (TextView)v. findViewById(R.id.txtNew);

        //SeekBar listener
        seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                diffNew.setText("New Difficulty level: " + levels[progress]);
                setHighest(progress);
                setDifficulty(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Confirm Button
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        newCard();
                        dialog.dismiss();
                    }
                });

        //Cancel Button
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Global Variables
     */
    //String to hold the keyboard input
    private String key;

    //String to hold letter value of the flashcard
    private String flash;

    //int to keep track of what letter is being selected
    private int i = 0;

    //Array to hold the keyboard input
    private String[] letters = {"","",""};

    //Int to hold number of times the answer is wrong
    private int numWrong;

    //Int to hold the current difficulty level 1 - 15
    private int difficulty;

    //Int to hold the highest character value for the selected difficulty
    private int high = 142;

    //Array to hold the text for the different difficulty levels
    private String[] levels = {
            "All Characters",
            "Vowels",
            "Vowels+K",
            "Vowels+KS",
            "Vowels+KST",
            "Vowels+KSTN",
            "Vowels+KSTNH",
            "Vowels+KSTNHM",
            "Vowels+KSTNHMR",
            "Vowels+KSTNHMRYW",
            "Vowels+KSTNHMRYWG",
            "Vowels+KSTNHMRYWGZ",
            "Vowels+KSTNHMRYWGZD",
            "Vowels+KSTNHMRYWGZDB",
            "Vowels+KSTNHMRYWGZDBP"
    };

    /**
     * setter method for the difficulty level
     */
    public void setDifficulty(int progress){
        this.difficulty = progress;
    }

    /**
     * getter method for the difficulty level
     */
    public int getDifficulty(){
        return difficulty;
    }

    /**
     * setter method to set the selected key
     */
    public void setKey(String letter){
        this.key = letter;

        //if the submit or delete keys are pressed
        if (key.equals("delete") || (key.equals("submit"))){
            //do not set key
        }else{
            try {
                //put key into appropriate array slot
                letters[i] = key;
            }
            //error handling for exceeding array dimensions
            catch (ArrayIndexOutOfBoundsException e){
            }
            //increaes the counter
            i++;
        }
    }

    /**
     * getter method to retrieve the selected key
     */
    public String getKey(){
        return key;
    }

    /**
     * setter method to figure out what the user's difficulty level is, and adjust the
     * upper limit of the random integer equation
     */
    public void setHighest(int highest){
        if (highest == 0){
            this.high = 142;
        }
        else if (highest == 1){
            this.high = 10;
        }
        else if (highest == 2){
            this.high = 20;
        }
        else if (highest == 3){
            this.high = 30;
        }
        else if (highest == 4){
            this.high = 40;
        }
        else if (highest == 5){
            this.high = 50;
        }
        else if (highest == 6){
            this.high = 60;
        }
        else if (highest == 7){
            this.high = 70;
        }
        else if (highest == 8){
            this.high = 80;
        }
        else if (highest == 9){
            this.high = 90;
        }
        else if (highest == 10){
            this.high = 100;
        }
        else if (highest == 11){
            this.high = 110;
        }
        else if (highest == 12){
            this.high = 120;
        }
        else if (highest == 13){
            this.high = 130;
        }
        else if (highest == 14){
            this.high = 140;
        }
    }

    /**
     * getter method to return the random int equation upper limit
     */
    public int getHighest(){
        return high;
    }

    /**
     * Method for randomizing and displaying flashcard
     */
    public void newCard(){
        Random rand = new Random();
        numWrong = 0;
        ImageView hira = (ImageView) findViewById(R.id.imgFlash);
        //random = high - low + 1 + low
        int random = rand.nextInt((getHighest()-1)+1)+1;
        //gives properties to each of the random integers
        /**
         * Groupings for variables
         * 1-10: A-O
         * 10-20: Ka - Ko
         * 20-30: Sa - So
         * 30-40: Ta - To
         * 40-50: Na - No
         * 50-60: Ha - Ho
         * 60-70: Ma - Mo
         * 70-80: Ra - Ro
         * 80-90: Ya, Yu, Yo, Wa, Wo
         * 90-100: Ga - Go
         * 100-110: Za - Zo
         * 110-120: Da - Do
         * 120-130: Ba - Bo
         * 130-140: Pa - Po
         * 141,142: N
         */
        switch (random){
            case 1: flash = "a";
                hira.setImageResource(R.drawable.hira_a);
                break;
            case 2: flash = "a";
                hira.setImageResource(R.drawable.kata_a);
                break;
            case 3: flash = "i";
                hira.setImageResource(R.drawable.hira_i);
                break;
            case 4: flash = "i";
                hira.setImageResource(R.drawable.kata_i);
                break;
            case 5: flash = "e";
                hira.setImageResource(R.drawable.hira_e);
                break;
            case 6: flash = "e";
                hira.setImageResource(R.drawable.kata_e);
                break;
            case 7: flash = "u";
                hira.setImageResource(R.drawable.hira_u);
                break;
            case 8: flash = "u";
                hira.setImageResource(R.drawable.kata_u);
                break;
            case 9: flash = "o";
                hira.setImageResource(R.drawable.hira_o);
                break;
            case 10: flash = "o";
                hira.setImageResource(R.drawable.kata_o);
                break;
            case 11: flash = "ka";
                hira.setImageResource(R.drawable.hira_ka);
                break;
            case 12: flash = "ka";
                hira.setImageResource(R.drawable.kata_ka);
                break;
            case 13: flash = "ki";
                hira.setImageResource(R.drawable.hira_ki);
                break;
            case 14: flash = "ki";
                hira.setImageResource(R.drawable.kata_ki);
                break;
            case 15: flash = "ke";
                hira.setImageResource(R.drawable.hira_ke);
                break;
            case 16: flash = "ke";
                hira.setImageResource(R.drawable.kata_ke);
                break;
            case 17: flash = "ku";
                hira.setImageResource(R.drawable.hira_ku);
                break;
            case 18: flash = "ku";
                hira.setImageResource(R.drawable.kata_ku);
                break;
            case 19: flash = "ko";
                hira.setImageResource(R.drawable.hira_ko);
                break;
            case 20: flash = "ko";
                hira.setImageResource(R.drawable.kata_ko);
                break;
            case 21: flash = "sa";
                hira.setImageResource(R.drawable.hira_sa);
                break;
            case 22: flash = "sa";
                hira.setImageResource(R.drawable.kata_sa);
                break;
            case 23: flash = "shi";
                hira.setImageResource(R.drawable.hira_shi);
                break;
            case 24: flash = "shi";
                hira.setImageResource(R.drawable.kata_shi);
                break;
            case 25: flash = "se";
                hira.setImageResource(R.drawable.hira_se);
                break;
            case 26: flash = "se";
                hira.setImageResource(R.drawable.kata_se);
                break;
            case 27: flash = "su";
                hira.setImageResource(R.drawable.hira_su);
                break;
            case 28: flash = "su";
                hira.setImageResource(R.drawable.kata_su);
                break;
            case 29: flash = "so";
                hira.setImageResource(R.drawable.hira_so);
                break;
            case 30: flash = "so";
                hira.setImageResource(R.drawable.kata_so);
                break;
            case 31: flash = "ta";
                hira.setImageResource(R.drawable.hira_ta);
                break;
            case 32: flash = "ta";
                hira.setImageResource(R.drawable.kata_ta);
                break;
            case 33: flash = "chi";
                hira.setImageResource(R.drawable.hira_chi);
                break;
            case 34: flash = "chi";
                hira.setImageResource(R.drawable.kata_chi);
                break;
            case 35: flash = "te";
                hira.setImageResource(R.drawable.hira_te);
                break;
            case 36: flash = "te";
                hira.setImageResource(R.drawable.kata_te);
                break;
            case 37: flash = "tsu";
                hira.setImageResource(R.drawable.hira_tsu);
                break;
            case 38: flash = "tsu";
                hira.setImageResource(R.drawable.kata_tsu);
                break;
            case 39: flash = "to";
                hira.setImageResource(R.drawable.hira_to);
                break;
            case 40: flash = "to";
                hira.setImageResource(R.drawable.kata_to);
                break;
            case 41: flash = "na";
                hira.setImageResource(R.drawable.hira_na);
                break;
            case 42: flash = "na";
                hira.setImageResource(R.drawable.kata_na);
                break;
            case 43: flash = "ni";
                hira.setImageResource(R.drawable.hira_ni);
                break;
            case 44: flash = "ni";
                hira.setImageResource(R.drawable.kata_ni);
                break;
            case 45: flash = "ne";
                hira.setImageResource(R.drawable.hira_ne);
                break;
            case 46: flash = "ne";
                hira.setImageResource(R.drawable.kata_ne);
                break;
            case 47: flash = "nu";
                hira.setImageResource(R.drawable.hira_nu);
                break;
            case 48: flash = "nu";
                hira.setImageResource(R.drawable.kata_nu);
                break;
            case 49: flash = "no";
                hira.setImageResource(R.drawable.hira_no);
                break;
            case 50: flash = "no";
                hira.setImageResource(R.drawable.kata_no);
                break;
            case 51: flash = "ha";
                hira.setImageResource(R.drawable.hira_ha);
                break;
            case 52: flash = "ha";
                hira.setImageResource(R.drawable.kata_ha);
                break;
            case 53: flash = "hi";
                hira.setImageResource(R.drawable.hira_hi);
                break;
            case 54: flash = "hi";
                hira.setImageResource(R.drawable.kata_hi);
                break;
            case 55: flash = "he";
                hira.setImageResource(R.drawable.hira_he);
                break;
            case 56: flash = "he";
                hira.setImageResource(R.drawable.kata_he);
                break;
            case 57: flash = "fu";
                hira.setImageResource(R.drawable.hira_fu);
                break;
            case 58: flash = "fu";
                hira.setImageResource(R.drawable.kata_fu);
                break;
            case 59: flash = "ho";
                hira.setImageResource(R.drawable.hira_ho);
                break;
            case 60: flash = "ho";
                hira.setImageResource(R.drawable.kata_ho);
                break;
            case 61: flash = "ma";
                hira.setImageResource(R.drawable.hira_ma);
                break;
            case 62: flash = "ma";
                hira.setImageResource(R.drawable.kata_ma);
                break;
            case 63: flash = "mi";
                hira.setImageResource(R.drawable.hira_mi);
                break;
            case 64: flash = "mi";
                hira.setImageResource(R.drawable.kata_mi);
                break;
            case 65: flash = "me";
                hira.setImageResource(R.drawable.hira_me);
                break;
            case 66: flash = "me";
                hira.setImageResource(R.drawable.kata_me);
                break;
            case 67: flash = "mu";
                hira.setImageResource(R.drawable.hira_mu);
                break;
            case 68: flash = "mu";
                hira.setImageResource(R.drawable.kata_mu);
                break;
            case 69: flash = "mo";
                hira.setImageResource(R.drawable.hira_mo);
                break;
            case 70: flash = "mo";
                hira.setImageResource(R.drawable.kata_mo);
                break;
            case 71: flash = "ra";
                hira.setImageResource(R.drawable.hira_ra);
                break;
            case 72: flash = "ra";
                hira.setImageResource(R.drawable.kata_ra);
                break;
            case 73: flash = "ri";
                hira.setImageResource(R.drawable.hira_ri);
                break;
            case 74: flash = "ri";
                hira.setImageResource(R.drawable.kata_ri);
                break;
            case 75: flash = "re";
                hira.setImageResource(R.drawable.hira_re);
                break;
            case 76: flash = "re";
                hira.setImageResource(R.drawable.kata_re);
                break;
            case 77: flash = "ru";
                hira.setImageResource(R.drawable.hira_ru);
                break;
            case 78: flash = "ru";
                hira.setImageResource(R.drawable.kata_ru);
                break;
            case 79: flash = "ro";
                hira.setImageResource(R.drawable.hira_ro);
                break;
            case 80: flash = "ro";
                hira.setImageResource(R.drawable.kata_ro);
                break;
            case 81: flash = "ya";
                hira.setImageResource(R.drawable.hira_ya);
                break;
            case 82: flash = "ya";
                hira.setImageResource(R.drawable.kata_ya);
                break;
            case 83: flash = "yu";
                hira.setImageResource(R.drawable.hira_yu);
                break;
            case 84: flash = "yu";
                hira.setImageResource(R.drawable.kata_yu);
                break;
            case 85: flash = "yo";
                hira.setImageResource(R.drawable.hira_yo);
                break;
            case 86: flash = "yo";
                hira.setImageResource(R.drawable.kata_yo);
                break;
            case 87: flash = "wa";
                hira.setImageResource(R.drawable.hira_wa);
                break;
            case 88: flash = "wa";
                hira.setImageResource(R.drawable.kata_wa);
                break;
            case 89: flash = "wo";
                hira.setImageResource(R.drawable.hira_wo);
                break;
            case 90: flash = "wo";
                hira.setImageResource(R.drawable.kata_wo);
                break;
            case 91: flash = "ga";
                hira.setImageResource(R.drawable.hira_ga);
                break;
            case 92: flash = "ga";
                hira.setImageResource(R.drawable.kata_ga);
                break;
            case 93: flash = "gi";
                hira.setImageResource(R.drawable.hira_gi);
                break;
            case 94: flash = "gi";
                hira.setImageResource(R.drawable.kata_gi);
                break;
            case 95: flash = "ge";
                hira.setImageResource(R.drawable.hira_ge);
                break;
            case 96: flash = "ge";
                hira.setImageResource(R.drawable.kata_ge);
                break;
            case 97: flash = "gu";
                hira.setImageResource(R.drawable.hira_gu);
                break;
            case 98: flash = "gu";
                hira.setImageResource(R.drawable.kata_gu);
                break;
            case 99: flash = "go";
                hira.setImageResource(R.drawable.hira_go);
                break;
            case 100: flash = "go";
                hira.setImageResource(R.drawable.kata_go);
                break;
            case 101: flash = "za";
                hira.setImageResource(R.drawable.hira_za);
                break;
            case 102: flash = "za";
                hira.setImageResource(R.drawable.kata_za);
                break;
            case 103: flash = "ji";
                hira.setImageResource(R.drawable.hira_ji);
                break;
            case 104: flash = "ji";
                hira.setImageResource(R.drawable.kata_ji);
                break;
            case 105: flash = "ze";
                hira.setImageResource(R.drawable.hira_ze);
                break;
            case 106: flash = "ze";
                hira.setImageResource(R.drawable.kata_ze);
                break;
            case 107: flash = "zu";
                hira.setImageResource(R.drawable.hira_zu);
                break;
            case 108: flash = "zu";
                hira.setImageResource(R.drawable.kata_zu);
                break;
            case 109: flash = "zo";
                hira.setImageResource(R.drawable.hira_zo);
                break;
            case 110: flash = "zo";
                hira.setImageResource(R.drawable.kata_zo);
                break;
            case 111: flash = "da";
                hira.setImageResource(R.drawable.hira_da);
                break;
            case 112: flash = "da";
                hira.setImageResource(R.drawable.kata_da);
                break;
            case 113: flash = "ji";
                hira.setImageResource(R.drawable.hira_ji);
                break;
            case 114: flash = "ji";
                hira.setImageResource(R.drawable.kata_ji);
                break;
            case 115: flash = "de";
                hira.setImageResource(R.drawable.hira_de);
                break;
            case 116: flash = "de";
                hira.setImageResource(R.drawable.kata_de);
                break;
            case 117: flash = "zu";
                hira.setImageResource(R.drawable.hira_zu);
                break;
            case 118: flash = "zu";
                hira.setImageResource(R.drawable.kata_zu);
                break;
            case 119: flash = "do";
                hira.setImageResource(R.drawable.hira_do);
                break;
            case 120: flash = "do";
                hira.setImageResource(R.drawable.kata_do);
                break;
            case 121: flash = "ba";
                hira.setImageResource(R.drawable.hira_ba);
                break;
            case 122: flash = "ba";
                hira.setImageResource(R.drawable.kata_ba);
                break;
            case 123: flash = "bi";
                hira.setImageResource(R.drawable.hira_bi);
                break;
            case 124: flash = "bi";
                hira.setImageResource(R.drawable.kata_bi);
                break;
            case 125: flash = "be";
                hira.setImageResource(R.drawable.hira_be);
                break;
            case 126: flash = "be";
                hira.setImageResource(R.drawable.kata_be);
                break;
            case 127: flash = "bu";
                hira.setImageResource(R.drawable.hira_bu);
                break;
            case 128: flash = "bu";
                hira.setImageResource(R.drawable.kata_bu);
                break;
            case 129: flash = "bo";
                hira.setImageResource(R.drawable.hira_bo);
                break;
            case 130: flash = "bo";
                hira.setImageResource(R.drawable.kata_bo);
                break;
            case 131: flash = "pa";
                hira.setImageResource(R.drawable.hira_pa);
                break;
            case 132: flash = "pa";
                hira.setImageResource(R.drawable.kata_pa);
                break;
            case 133: flash = "pi";
                hira.setImageResource(R.drawable.hira_pi);
                break;
            case 134: flash = "pi";
                hira.setImageResource(R.drawable.kata_pi);
                break;
            case 135: flash = "pe";
                hira.setImageResource(R.drawable.hira_pe);
                break;
            case 136: flash = "pe";
                hira.setImageResource(R.drawable.kata_pe);
                break;
            case 137: flash = "pu";
                hira.setImageResource(R.drawable.hira_pu);
                break;
            case 138: flash = "pu";
                hira.setImageResource(R.drawable.kata_pu);
                break;
            case 139: flash = "po";
                hira.setImageResource(R.drawable.hira_po);
                break;
            case 140: flash = "po";
                hira.setImageResource(R.drawable.kata_po);
                break;
            case 141: flash = "n";
                hira.setImageResource(R.drawable.hira_n);
                break;
            case 142: flash = "n";
                hira.setImageResource(R.drawable.kata_n);
                break;
        }
    }

    /**
     * Method to draw the letters after the keyboard has been clicked
     */
    public void drawLetter(){
        ImageView guess = (ImageView) findViewById(R.id.letterOne);
        //Depending on the counter, change which ImageView gets drawn on
        if (i == 1){
            guess = (ImageView) findViewById(R.id.letterOne);
        }else if (i == 2){
            guess = (ImageView) findViewById(R.id.letterTwo);
        }else if (i == 3){
            guess = (ImageView) findViewById(R.id.letterThree);
        }

        //Different cases based on which key was clicked
        if (getKey().equals("a")){
            guess.setImageResource(R.drawable.eng_a);
        }else if (getKey().equals("b")){
            guess.setImageResource(R.drawable.eng_b);
        }else if (getKey().equals("c")){
            guess.setImageResource(R.drawable.eng_c);
        }else if (getKey().equals("d")){
            guess.setImageResource(R.drawable.eng_d);
        }else if (getKey().equals("e")){
            guess.setImageResource(R.drawable.eng_e);
        }else if (getKey().equals("f")){
            guess.setImageResource(R.drawable.eng_f);
        }else if (getKey().equals("g")){
            guess.setImageResource(R.drawable.eng_g);
        }else if (getKey().equals("h")){
            guess.setImageResource(R.drawable.eng_h);
        }else if (getKey().equals("i")){
            guess.setImageResource(R.drawable.eng_i);
        }else if (getKey().equals("j")){
            guess.setImageResource(R.drawable.eng_j);
        }else if (getKey().equals("k")){
            guess.setImageResource(R.drawable.eng_k);
        }else if (getKey().equals("m")){
            guess.setImageResource(R.drawable.eng_m);
        }else if (getKey().equals("n")){
            guess.setImageResource(R.drawable.eng_n);
        }else if (getKey().equals("o")){
            guess.setImageResource(R.drawable.eng_o);
        }else if (getKey().equals("p")){
            guess.setImageResource(R.drawable.eng_p);
        }else if (getKey().equals("r")){
            guess.setImageResource(R.drawable.eng_r);
        }else if (getKey().equals("s")){
            guess.setImageResource(R.drawable.eng_s);
        }else if (getKey().equals("t")){
            guess.setImageResource(R.drawable.eng_t);
        }else if (getKey().equals("u")){
            guess.setImageResource(R.drawable.eng_u);
        }else if (getKey().equals("w")){
            guess.setImageResource(R.drawable.eng_w);
        }else if (getKey().equals("y")){
            guess.setImageResource(R.drawable.eng_y);
        }else if (getKey().equals("z")){
            guess.setImageResource(R.drawable.eng_z);
        }
    }

    /**
     * Methods for responding to button hits
     * Each method associated with a button in the activity layout file
     */
    public void clickBtnA(View v){
        setKey("a");
        drawLetter();
    }
    public void clickBtnB(View v){
        setKey("b");
        drawLetter();
    }
    public void clickBtnC(View v) {
        setKey("c");
        drawLetter();
    }
    public void clickBtnD(View v){
        setKey("d");
        drawLetter();
    }
    public void clickBtnE(View v){
        setKey("e");
        drawLetter();
    }
    public void clickBtnF(View v){
        setKey("f");
        drawLetter();
    }
    public void clickBtnG(View v){
        setKey("g");
        drawLetter();
    }
    public void clickBtnH(View v){
        setKey("h");
        drawLetter();
    }
    public void clickBtnI(View v){
        setKey("i");
        drawLetter();
    }
    public void clickBtnJ(View v){
        setKey("j");
        drawLetter();
    }
    public void clickBtnK(View v){
        setKey("k");
        drawLetter();
    }
    public void clickBtnL(View v){
    }
    public void clickBtnM(View v){
        setKey("m");
        drawLetter();
    }
    public void clickBtnN(View v){
        setKey("n");
        drawLetter();
    }
    public void clickBtnO(View v){
        setKey("o");
        drawLetter();
    }
    public void clickBtnP(View v){
        setKey("p");
        drawLetter();
    }
    public void clickBtnQ(View v){
        setKey("q");
    }
    public void clickBtnR(View v){
        setKey("r");
        drawLetter();
    }
    public void clickBtnS(View v){
        setKey("s");
        drawLetter();
    }
    public void clickBtnT(View v){
        setKey("t");
        drawLetter();
    }
    public void clickBtnU(View v){
        setKey("u");
        drawLetter();
    }
    public void clickBtnV(View v){
    }
    public void clickBtnW(View v){
        setKey("w");
        drawLetter();
    }
    public void clickBtnX(View v){
    }
    public void clickBtnY(View v){
        setKey("y");
        drawLetter();
    }
    public void clickBtnZ(View v){
        setKey("z");
        drawLetter();
    }

    /**
     * Method to control what happens when the delete button is selected
     */
    public void clickBtnDel(View v){
        setKey("delete");
        if (i > 3){
            i = 3;
        }
        //Removes the drawings of incorrect letters
        ImageView guess;
        if (i == 1){
            guess = (ImageView)findViewById(R.id.letterOne);
            guess.setImageResource(R.drawable.blank);
        }else if (i == 2) {
            guess = (ImageView) findViewById(R.id.letterTwo);
            guess.setImageResource(R.drawable.blank);
        }if (i == 3) {
            guess = (ImageView) findViewById(R.id.letterThree);
            guess.setImageResource(R.drawable.blank);
        }
        //Decrease the global counter
        if (i > 0) {
            i--;
        }else{
            i = 0;
        }
        //Remove the value associated with the counter spot in the array
        letters[i] = "";
    }

    /**
     * Method to control what happens when the submit button is selected
     */
    public void clickBtnSubmit(View v){
        setKey("submit");

        //Loop through the array, and use string buffer to create a string of letters
        StringBuffer result = new StringBuffer();
        for (int j = 0; j < letters.length; j++){
            result.append(letters[j]);
        }
        String joinedLetters = result.toString();
        TextView txtWrong = (TextView)findViewById(R.id.txtWrong);
        ImageView wrong = (ImageView) findViewById(R.id.imgWrong);
        //if the word was correct
        if (joinedLetters.equals(flash)) {
            i = 0;
            letters[0] = "";
            letters[1] = "";
            letters[2] = "";
            //Clear all of the letters in the guessboxes
            ImageView guess = (ImageView) findViewById(R.id.letterOne);
            guess.setImageResource(R.drawable.blank);
            guess = (ImageView) findViewById(R.id.letterTwo);
            guess.setImageResource(R.drawable.blank);
            guess = (ImageView) findViewById(R.id.letterThree);
            guess.setImageResource(R.drawable.blank);

            //Clears the x sign
            wrong.setImageResource(R.drawable.blank);
            txtWrong.setText("");
            //Draw a new card
            newCard();
        }else{
            //Draws a red x
            wrong.setImageResource(R.drawable.x);
            numWrong++;
            //if the answer is wrong three times, show the correct answer
            if (numWrong == 3){
                txtWrong.setText("Answer: "+flash);
            }
        }
    }
}