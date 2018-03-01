package harshal.com.demoapp.businesslogic;

import android.view.View;


public interface IClickListener {
    public void onClick(View v, int position);

    public void onLongClick(View v, int position);

}
