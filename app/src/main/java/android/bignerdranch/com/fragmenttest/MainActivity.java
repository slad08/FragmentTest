package android.bignerdranch.com.fragmenttest;

import android.app.Activity;
import android.bignerdranch.com.fragmenttest.fragment.OneFragment;
import android.bignerdranch.com.fragmenttest.fragment.TwoFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends FragmentActivity {

    private OneFragment oneFragment ;
    private TwoFragment twoFragment ;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private Switch isStackBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        isStackBack = (Switch) findViewById(R.id.switchBackStack);
    }
    public void  onClickFragment(View view){
        transaction = manager.beginTransaction();

        switch (view.getId()){
            case R.id.btnAdd:
            if(manager.findFragmentByTag(oneFragment.TAG)==null) {
                transaction.add(R.id.container, oneFragment, oneFragment.TAG);
            }
                break;
            case  R.id.btnDel:
                if(manager.findFragmentByTag(oneFragment.TAG)!=null) {
                    transaction.remove(oneFragment);
                }
                if(manager.findFragmentByTag(twoFragment.TAG)!=null) {
                    transaction.remove(twoFragment);
                }
                break;
            case R.id.btnReplace:
                if(manager.findFragmentByTag(oneFragment.TAG)!=null) {
                    transaction.replace(R.id.container, twoFragment,twoFragment.TAG);
                }
                if(manager.findFragmentByTag(twoFragment.TAG)!=null) {
                    transaction.replace(R.id.container, oneFragment,oneFragment.TAG);
                }
        }

        if (isStackBack.isChecked()) {
            transaction.addToBackStack(null);

        }
        transaction.commit();

    }
}
