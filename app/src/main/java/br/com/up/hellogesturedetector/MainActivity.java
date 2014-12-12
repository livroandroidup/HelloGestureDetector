package br.com.up.hellogesturedetector;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Exemplos de Gestos
 *
 * @author rlecheta
 *
 */
public class MainActivity extends ListActivity {

    private static final String[] ops = new String[] { "Fling / swipe","Pinch / zoom" };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout,ops);
        this.setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                startActivity(new Intent(this, FlingGestureDetectorActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ZoomGestureDetectorActivity.class));
                break;
            default:
                finish();
        }
    }
}