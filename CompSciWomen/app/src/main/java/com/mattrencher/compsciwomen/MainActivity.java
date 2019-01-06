package com.mattrencher.compsciwomen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // global variables
    // string array w/ names
    String[] scientistArray = {"Grace Hopper",
            "Ursula Burns",
            "Susan Landau",
            "Ellen Ochoa",
            "Manuela Veloso",
            "Duy-LoanLe",
            "Jane Xu",
            "Sister Mary Keller",
            "Shirley Jackson",
            "Padmasree Warrior"};

    // Integer array of scientist pictures index
    int[] scientistIndex = {R.drawable.grace_hopper,
            R.drawable.ursula_burns,
            R.drawable.susan_landau,
            R.drawable.ellen_ochoa,
            R.drawable.manuela_veloso,
            R.drawable.duy_loanle,
            R.drawable.jane_xu,
            R.drawable.mary_keller,
            R.drawable.shirley_jackson,
            R.drawable.padmasree_warrior};

    // String array with personal info of each women scientist
    String[] scientistInfoArray={"Created first compiler",
            "CEO Xerox",
            "Sun Microsystems Engineer",
            "Scientist at NASA Ames Research",
            "Expert in robotics at Carnegie Mellon",
            "CTO, Texas Instruments",
            "Scientist at IBM Watson Research",
            "Created Basic programming language",
            "President Rensselaer Polytechnic Inst.",
            "CTO Cisco"};

    // array size
    int scientistArraySize = scientistArray.length;

    // declaring linear layout
    LinearLayout scientistLL;

    // declare image button, make images touch sensitive (show descrip)
    ImageButton scientistIB;

    // declare textview
    TextView outputTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining declared objects
        scientistLL = (LinearLayout) findViewById(R.id.womenLL);
        outputTV = (TextView) findViewById(R.id.outTV);

        // storing images in the LL
        // as individual ImageButtons
        for (int i=0; i < scientistArraySize; i++)
        {
            // defining the declared imgbutton
            scientistIB = new ImageButton(this);

            // getting the corresponding picture
            scientistIB.setImageResource(scientistIndex[i]);

            // loading the ImageButton into the linearLayout
            scientistLL.addView(scientistIB);

            // assign scientist info to each ImageButton
            scientistIB.setContentDescription(scientistArray[i] + "\n" + scientistInfoArray[i]);

            // setting up a listener to the ImageButton so when it is
            // swiped and then clicken the desc is shown on the TV
            scientistIB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View clickedButton) {
                    // storing the scientist desc in to a string variable
                    String scientistDesc=(String) clickedButton.getContentDescription();

                    // displaying the personal info in the TV
                    outputTV.setText(scientistDesc);

                }
            });

        } // end of for loop
    }
}
