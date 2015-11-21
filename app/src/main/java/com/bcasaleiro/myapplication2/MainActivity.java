package com.bcasaleiro.myapplication2;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView.Adapter rvAdapter;

    private ArrayList<Item> myItems;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        myItems = new ArrayList<>();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        RecyclerView recyclerView;
        ItemsAdapter rvAdapter;
        ArrayList<Item> myItems;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
            myItems = new ArrayList<>();
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<Item> myItems = new ArrayList<>();
            //View view = inflater.inflate(R.layout.fragment_main, container, false);
            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

            rvAdapter = new ItemsAdapter();

            ((ItemsAdapter) rvAdapter).addItem(new Item("O casaleiro é fixe"), 0);
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O casaleiro é fixe"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter)rvAdapter).addItemToEnd(new Item("O mendes é conas"));
            ((ItemsAdapter) rvAdapter).addItemToEnd(new Item("O mendes é conas"));

            recyclerView.setAdapter(rvAdapter);


            return rootView;
        }

        public class ItemsAdapter extends RecyclerView.Adapter<ViewHolderItem> {

            private View view;

            @Override
            public ViewHolderItem onCreateViewHolder(ViewGroup viewGroup, int position) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_items, viewGroup, false);
                return new ViewHolderItem(view);
            }

            @Override
            public void onBindViewHolder(ViewHolderItem viewHolderItem, int position) {
                viewHolderItem.setNameTextView(this.getItem(position).getString());
            }

            @Override
            public int getItemCount() {
                return myItems.size();
            }

            public Item getItem(int position) {
                return myItems.get(position);
            }

            public void addItem(Item task, int position) {
                myItems.add(position, task);
                notifyItemInserted(position);
            }

            public void addItemToEnd(Item item) {
                myItems.add(myItems.size(), item);
                notifyItemInserted(myItems.size() - 1);
            }

            public Item popItem(int position) {
                Item item = myItems.get(position);
                myItems.remove(position);
                notifyItemRemoved(position);

                return item;
            }

            public Item popItem(Item item) {
                int position = myItems.indexOf(item);
                Item auxItem = myItems.get(position);
                myItems.remove(position);
                notifyItemRemoved(position);

                return auxItem;
            }

            public void moveItem(int fromPos, int toPos) {
                Item item = myItems.get(fromPos);
                myItems.remove(fromPos);
                myItems.add(toPos, item);

                notifyItemMoved(fromPos, toPos);
            }
        }

        public class ViewHolderItem extends RecyclerView.ViewHolder{

            private View parent;
            private TextView nameTextView;

            public ViewHolderItem(View itemView) {
                super(itemView);
                this.parent = itemView;
                this.nameTextView = (TextView) parent.findViewById(R.id.task_name);

            }

            public TextView getNameTextView() {
                return nameTextView;
            }

            public void setNameTextView(String nameTextView) {
                this.nameTextView.setText(nameTextView);
            }
        }

    }

    public void setUpRecyclerView(RecyclerView recyclerView) {

    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Friends";
                case 1:
                    return "Challenges";
                case 2:
                    return "History";
            }
            return null;
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
