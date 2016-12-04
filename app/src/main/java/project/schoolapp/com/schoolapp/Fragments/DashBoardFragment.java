package project.schoolapp.com.schoolapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.schoolapp.com.schoolapp.MainActivity;
import project.schoolapp.com.schoolapp.R;


public class DashBoardFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    private int[] tabIcons = {
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_gallery
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x = inflater.inflate(R.layout.fragment_tab, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        ((MainActivity) getActivity()).fab.show();
        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
               // setupTabIcons();
                //setUpTabs(viewPager);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    ((MainActivity) getActivity()).fab.show();
                } else {
                    ((MainActivity) getActivity()).fab.hide();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return x;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
   /*
   *  private void setUpTabs (ViewPager viewPager) {
        TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabs);
        if (tabs != null) {
            tabs.setupWithViewPager(viewPager);
            for (int i = 0; i < 3; i++) {
                TabLayout.Tab tab = tabs.getTabAt(i);
                if (tab != null){
                    ImageView myCustomIcon = (ImageView) LayoutInflater.from(tabs.getContext()).inflate(R.layout.custom_tab_layout, null);


    myCustomIcon.setImageResource(R.drawable.image1);

    tab.setCustomView(myCustomIcon);
}
}
        }
        }*/

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new first();
                case 1:
                    return new second();
                case 2:
                    return new third();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }


        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Homework";
                case 1:
                    return "Attendance";
                case 2:
                    return "Notice";
            }

            return null;

        }
    }

}