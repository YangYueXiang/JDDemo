package com.bwie.jddemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.view.fragment.FenleiFragment;
import com.bwie.view.fragment.FindFragment;
import com.bwie.view.fragment.HomeFragment;
import com.bwie.view.fragment.MyFragment;
import com.bwie.view.fragment.ShopCartFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.radio_shou)
    RadioButton radioShou;
    @BindView(R.id.radio_fen)
    RadioButton radioFen;
    @BindView(R.id.radio_fa)
    RadioButton radioFa;
    @BindView(R.id.radio_gou)
    RadioButton radioGou;
    @BindView(R.id.radio_my)
    RadioButton radioMy;
    @BindView(R.id.redio_group)
    RadioGroup redioGroup;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        redioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.radio_shou:
                        transaction.replace(R.id.frame_layout,new HomeFragment());
                        break;
                    case R.id.radio_fen:
                        transaction.replace(R.id.frame_layout,new FenleiFragment());
                        break;
                    case R.id.radio_fa:
                        transaction.replace(R.id.frame_layout,new FindFragment());
                        break;
                    case R.id.radio_gou:
                        transaction.replace(R.id.frame_layout,new ShopCartFragment());
                        break;
                    case R.id.radio_my:
                        transaction.replace(R.id.frame_layout,new MyFragment());
                        break;

                }
                transaction.commit();

            }
        });

    }
}
