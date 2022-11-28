package com.bmt.lab3.adapter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bmt.lab3.CategoryFragments;
import com.bmt.lab3.OnSaleFragments;
import com.bmt.lab3.TopPickFragments;
import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                Log.e("FRAGMENTS","ONSALE");
                return new OnSaleFragments();
            case 1:
                Log.e("FRAGMENTS","TOPIC");
                return new TopPickFragments();
            default:
                Log.e("FRAGMENTS","CATEGORY");
                return new CategoryFragments();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
