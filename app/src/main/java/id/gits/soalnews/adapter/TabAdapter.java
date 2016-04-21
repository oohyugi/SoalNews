package id.gits.soalnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.gits.soalnews.fragment.beritaBaruFragment;
import id.gits.soalnews.fragment.beritaHotFragment;
import id.gits.soalnews.fragment.beritaPopulerFragment;

/**
 * Created by yogi on 19/04/16.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    int numbOfTabs;


    public TabAdapter(FragmentManager fm, int numbOfTabsSum){
        super(fm);
        this.numbOfTabs=numbOfTabsSum;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new beritaBaruFragment();
            case 1:
                return new beritaPopulerFragment();
            case 2:
                return new beritaHotFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}
