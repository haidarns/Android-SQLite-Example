package idn.hnslabs.sqliteexample;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class BaruActivity extends Activity {

    protected Cursor cursor;
    DataCenter dbHelper;
    Button ton1;
    EditText txtJam, txtMatkul, txtRuang;
    private Spinner spinDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baru);

        dbHelper = new DataCenter(this);

        spinDay = (Spinner) findViewById(R.id.spinDay);
        txtJam = (EditText) findViewById(R.id.editJam);
        txtMatkul = (EditText) findViewById(R.id.editMatkul);
        txtRuang = (EditText) findViewById(R.id.editRuang);

        ton1 = (Button) findViewById(R.id.button1);

        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata(hari, jam, matkul, ruangan) values('" +
                        spinDay.getSelectedItem().toString()+"','"+
                        txtJam.getText().toString() +"','" +
                        txtMatkul.getText().toString()+"','"+
                        txtRuang.getText().toString() +"')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_baru, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
