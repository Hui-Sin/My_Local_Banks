package sg.edu.rp.c346.id20018354.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String wordClicked="";
    TextView DBSbank;
    TextView OCBCbank;
    TextView UOBbank;
    int choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBSbank = findViewById(R.id.textViewDBS);
        OCBCbank = findViewById(R.id.textViewOCBC);
        UOBbank = findViewById(R.id.textViewUOB);
        registerForContextMenu(DBSbank);
        registerForContextMenu(OCBCbank);
        registerForContextMenu(UOBbank);
        DBSbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=1;
                openContextMenu(DBSbank);
            }
        });
        OCBCbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=2;
                openContextMenu(OCBCbank);
            }
        });
        UOBbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=3;
                openContextMenu(UOBbank);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBSbank.setText("DBS");
            OCBCbank.setText("OCBC");
            UOBbank.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBSbank.setText("星展银行");
            OCBCbank.setText("华侨银行");
            UOBbank.setText("大华银行");
            return true;
        }
            return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.v("Context", "create context");
        menu.add(0, 0, 0, "Website / 网站" );
        menu.add(0, 1, 1, "Contact the bank / 联系银行");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 0&&choice==1) { //check whether the selected menu item ID is 0
            //code for action
            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            startActivity(intentView);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 1&&choice==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
            startActivity(intentDial);
            return true;  //menu item successfully handled
        }else if (item.getItemId() == 0&&choice==2) { //check whether the selected menu item ID is 0
            //code for action
            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
            startActivity(intentView);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 1&&choice==2) { //check if the selected menu item ID is 1
            //code for action
            Intent intentDial1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
            startActivity(intentDial1);
            return true;  //menu item successfully handled
        }
        else if (item.getItemId() == 0&&choice==3) { //check whether the selected menu item ID is 0
            //code for action
            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
            startActivity(intentView);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 1&&choice==3) { //check if the selected menu item ID is 1
            //code for action
            Intent intentDial1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121L));
            startActivity(intentDial1);
            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}