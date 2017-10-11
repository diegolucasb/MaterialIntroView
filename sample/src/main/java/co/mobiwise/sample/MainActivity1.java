package co.mobiwise.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

import co.mobiwise.materialintro.animation.MaterialIntroListener;
import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.shape.LayoutType;
import co.mobiwise.materialintro.view.MaterialIntroView;

public class MainActivity1 extends AppCompatActivity
        {

    private FloatingActionButton fab;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;

    View[] views = new View[3];
    String[] texts = new String[3];
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        views[0] = fab;
        views[1] = fab1;
        views[2] = fab2;

        texts[0] = "Explaining text that will be presenter to user";
        texts[1] = "Another explanation to show something important about this FloatActionButton";
        texts[2] = "I think you already got the idea, right?";

        callView();

    }

    private void callView(){
        if(index > 2){
            return;
        }


        String usageId = new Random().nextInt()+ "";

        new MaterialIntroView.Builder(this, LayoutType.LAYOUT_ARROW)
                .enableDotAnimation(false)
                .setFocusGravity(FocusGravity.CENTER)
                .setFocusType(Focus.NORMAL)
                .setDelayMillis(200)
                .enableFadeAnimation(true)
                .performClick(true)
                .setInfoText(texts[index])
                .setTarget(views[index])
                .setUsageId(usageId) //THIS SHOULD BE UNIQUE ID
                .setListener(new MaterialIntroListener() {
                    @Override
                    public void onUserClicked(String materialIntroViewId) {
                        index++;
                        callView();
                    }
                })
                .show();
    }


}
