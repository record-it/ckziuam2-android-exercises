package pl.zsl.androidapp.form;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import pl.zsl.androidapp.R;

public class PersonCursorAdapter extends CursorAdapter {

    public PersonCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_person, null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView = view.findViewById(R.id.rowName);
        TextView emailView = view.findViewById(R.id.rowEmail);
        nameView.setText(cursor.getString(1));
        emailView.setText(cursor.getString(2));
    }
}
