package pe.edu.upc.shareit;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {

    TextView shareTextView;
    EditText shareEditText;
    Button updateButton;
    ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        shareTextView = (TextView) findViewById(R.id.shareTextView);
        shareEditText = (EditText) findViewById(R.id.shareEditText);
        updateButton = (Button) findViewById(R.id.updateButton);


        updateButton.setOnClickListener(this);

        // realiza un CAST respecto a los .... //colococar la clase q cumple la actividad
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        if(shareItem==null){
            shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
            setShareIntent();
        }
        return true;
    }

    private void setShareIntent (){
        if(shareActionProvider != null){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plane");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Content Sharing App");
            shareIntent.putExtra(Intent.EXTRA_TEXT,shareTextView.getText().toString());
            shareActionProvider.setShareIntent(shareIntent);
        }
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.updateButton){
            shareTextView.setText("I want to shared that" + shareEditText.getText().toString());
            setShareIntent();
        }
    }
}
