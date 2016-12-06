package android.bignerdranch.com.fragmenttest.fragment;

import android.bignerdranch.com.fragmenttest.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TwoFragment extends Fragment {
    public static final String TAG = "TwoFragmentTag";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two_fragment,null);
    }
}
