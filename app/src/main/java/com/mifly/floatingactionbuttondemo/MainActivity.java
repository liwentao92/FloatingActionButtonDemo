package com.mifly.floatingactionbuttondemo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu menuRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuRed = (FloatingActionMenu) findViewById(R.id.menu_red);

        final FloatingActionButton programFab1 = new FloatingActionButton(this);
        programFab1.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab1.setLabelText("哈哈哈哈哈哈哈哈");
        programFab1.setImageResource(R.drawable.ic_edit);
        menuRed.addMenuButton(programFab1);


        programFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                programFab1.setLabelColors(ContextCompat.getColor(MainActivity.this, R.color.grey),
                        ContextCompat.getColor(MainActivity.this, R.color.light_grey),
                        ContextCompat.getColor(MainActivity.this, R.color.white_transparent));
                programFab1.setLabelTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            }
        });

        menuRed.setClosedOnTouchOutside(true);


        menuRed.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuRed.isOpened()) {
                    Toast.makeText(MainActivity.this, menuRed.getMenuButtonLabelText(), Toast.LENGTH_SHORT).show();
                }

                menuRed.toggle(true);
            }
        });

    }


  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {

          if (menuRed.isOpened()){
              menuRed.close(true);
          }else {
              System.exit(0);// 否则退出程序
          }
          return true;
      }
      return super.onKeyDown(keyCode, event);
  }

}
