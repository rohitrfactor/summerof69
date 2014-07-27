package com.example.tut;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.tut.A1Activity.DemoCollectionPagerAdapter;
import com.example.tut.A1Activity.DemoObjectFragment;
import com.example.tut.A1Activity.DemoObjectFragment.dailytimeAdapter;
import com.example.tut.A1Activity.DemoObjectFragment.dailytimetable;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class C2Activity extends FragmentActivity {
   
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments representing
     * each object in a collection. We use a {@link android.support.v4.app.FragmentStatePagerAdapter}
     * derivative, which will destroy and re-create fragments as needed, saving and restoring their
     * state in the process. This is important to conserve memory and is a best practice when
     * allowing navigation between objects in a potentially large collection.
     */
    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the object collection.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        // Create an adapter that when requested, will return a fragment representing an object in
        // the collection.
        // 
        // ViewPager and its adapters use support library fragments, so we must use
        // getSupportFragmentManager.
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());

        // Set up action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home button should show an "Up" caret, indicating that touching the
        // button will take the user one step up in the application's hierarchy.
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		int red=0;
		
		if (Calendar.MONDAY == day) {
	        red=0;
	    } else if (Calendar.TUESDAY == day) {
	        red = 1;
	    } else if (Calendar.WEDNESDAY == day) {
	        red=2;
	    } else if (Calendar.THURSDAY == day) {
	        red=3;
	    } else if (Calendar.FRIDAY == day) {
	        red=4;
	    } else if (Calendar.SATURDAY == day) {
	        red=5;
	    } else if (Calendar.SUNDAY == day) {
	        red=6;
	    }
        
        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
        mViewPager.setCurrentItem(red);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This is called when the Home (Up) button is pressed in the action bar.
                // Create a simple intent that starts the hierarchical parent activity and
                // use NavUtils in the Support Package to ensure proper handling of Up.
                Intent upIntent = new Intent(this, Btech1yearHome.class);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is not part of the application's task, so create a new task
                    // with a synthesized back stack.
                    TaskStackBuilder.from(this)
                            // If there are ancestor activities, they should be added here.
                            .addNextIntent(upIntent)
                            .startActivities();
                    finish();
                } else {
                    // This activity is part of the application's task, so simply
                    // navigate up to the hierarchical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
     * representing an object in the collection.
     */
    public static class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        public DemoCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment();
            Bundle args = new Bundle();
            args.putInt(DemoObjectFragment.ARG_OBJECT, (i + 1)); // Our object is just an integer :-P
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // For this contrived example, we have a 100-object collection.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	String r="null";
        	switch(position){
        	case 0:
        		r="Monday";
        		break;
        	case 1:
        		r="Tuesday";
        		break;
        	case 2:
        		r="Wednesday";
        		break;
        	case 3:
        		r="Thrusday";
        		break;
        	case 4:
        		r="Friday";
        		break;
        	}
            return r;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DemoObjectFragment extends Fragment {

        public static final String ARG_OBJECT = "object";
        int position1;
        
      /*  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.co1_fragment_main, container, false);
            Bundle args = getArguments();
            //((TextView) rootView.findViewById(android.R.id.text1)).setText(
              //      Integer.toString(args.getInt(ARG_OBJECT)));
            //tableListAdapter = new dailytimeAdapter();
            
            String[] codeLearnChapters = new String[] { "Android Introduction","Android Setup/Installation","Android Hello World",
            		"Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android",
            		"radio","pakistan","lesson","india","russia","america","United Arab Emirates",
            		"Khalistan","New Delhi"};
            String[] sim = new String[] {"lesson","passion","aggression","Android Introduction","Android Setup/Installation","Android Hello World",
            		"Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android",
            		"radio","pakistan","lesson","india","russia","america","United Arab Emirates",
            		"Khalistan","New Delhi" };
           String[] codeLearn = new String[] {"null"};
            switch(args.getInt(ARG_OBJECT)%2){
            case 0:
            	codeLearn = codeLearnChapters;
            	break;
            case 1:
            	codeLearn = sim;
            	break;
            };
            
            ListView codeLearnLessons = (ListView)rootView.findViewById(R.id.listView3);
            codeLearnLessons.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,codeLearn));
            
            
            
            return rootView;
         }   */
        
        
        
		public class dailytimetable {
			String SubjectName;
			String Time1;
			String Time2;
			String Location;
			String Type;
		}
		dailytimeAdapter tableListAdapter;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_a1, container,
					false);
			Bundle args = getArguments();
			
			switch(args.getInt(ARG_OBJECT)){
            case 0:
            	position1 = 0;
            	break;
            case 1:
            	position1 = 1;
            	break;
            case 2:
            	position1 = 2;
            	break;
            case 3:
            	position1 = 3;
            	break;
            case 4 :
               position1 = 4;
               break;   
            	
            };
           
            tableListAdapter = new dailytimeAdapter(getActivity());
            
            ListView codeLearnLessons = (ListView)rootView.findViewById(R.id.listView3);
            codeLearnLessons.setAdapter(tableListAdapter);
			return rootView;
		}
		
		public class dailytimeAdapter extends BaseAdapter {
            
			private Context mcontext;
			public dailytimeAdapter(Context context)
			{  mcontext = context;
			
			}
	    	List<dailytimetable> dailyList = getDataForListView(position1);
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return dailyList.size();
			}

			@Override
			public dailytimetable getItem(int arg0) {
				// TODO Auto-generated method stub
				return dailyList.get(arg0);
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				
				if(arg1==null)
				{
					LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					arg1 = inflater.inflate(R.layout.list_item, arg2,false);
				}
				
				TextView subjectName = (TextView)arg1.findViewById(R.id.subjectname);
				TextView location = (TextView)arg1.findViewById(R.id.location);
				TextView type = (TextView)arg1.findViewById(R.id.type);
				TextView time1 = (TextView)arg1.findViewById(R.id.time1);
				TextView time2 = (TextView)arg1.findViewById(R.id.time2);
				
				dailytimetable chapter = dailyList.get(arg0);
				
				subjectName.setText(chapter.SubjectName);
				location.setText(chapter.Location);
				type.setText(chapter.Type);
				time1.setText(chapter.Time1);
				time2.setText(chapter.Time2);
									
				return arg1;
			}
			
			public dailytimetable getdailytimetable(int position)
			{
				return dailyList.get(position);
			}

	    }
	    
	   
	    
	    public List<dailytimetable> getDataForListView(int position)
	    {
	    	List<dailytimetable> dailyList = new ArrayList<dailytimetable>();
	    	List<dailytimetable> dailyList1 = new ArrayList<dailytimetable>();
	    	List<dailytimetable> dailyList2 = new ArrayList<dailytimetable>();
	    	List<dailytimetable> dailyList3 = new ArrayList<dailytimetable>();
	    	List<dailytimetable> dailyList4 = new ArrayList<dailytimetable>();
	    	List<dailytimetable> retu = new ArrayList<dailytimetable>();
	    		
	    	dailytimetable chapter = new dailytimetable();
    		chapter.SubjectName = "Math";
    		chapter.Location = "A-316";
    		chapter.Type = "Tutorial";
    		chapter.Time1 = "8:30";
    		chapter.Time2 = "9:25";
    		dailyList.add(chapter);
    		
    		dailytimetable ch = new dailytimetable();
    		ch.SubjectName ="Physics";
    		ch.Location = "A-226";
    		ch.Type ="Lecture";
    		ch.Time1 = "9:25";
    		ch.Time2 = "10:20";
    		dailyList.add(ch);
    		
    		dailytimetable br = new dailytimetable();
    		br.SubjectName = "Snacks Time";
            br.Location = "Market";
            br.Type="";
            br.Time1 = "10:20";
            br.Time2 = "10:40";
            dailyList.add(br);
    				
    		dailytimetable chapter2 = new dailytimetable();
    		chapter2.SubjectName = "BEE";
    		chapter2.Location = "A-226";
    		chapter2.Type = "Lecture";
    		chapter2.Time1 = "10:40";
    		chapter2.Time2 = "11:35";
    		dailyList.add(chapter2);
    		dailytimetable chapter3 = new dailytimetable();
    		chapter3.SubjectName = "Lunch";
    		chapter3.Location = "Hostel";
    		chapter3.Type = "";
    		chapter3.Time1 = "11:35";
    		chapter3.Time2 = "12:50";
    		dailyList.add(chapter3);
    		dailytimetable chapter4 = new dailytimetable();
    		chapter4.SubjectName = "Engg. Graphics";
    		chapter4.Location = "EH F.Floor";
    		chapter4.Type = "";
    		chapter4.Time1 = "12:50";
    		chapter4.Time2 = "3:35";
    		dailyList.add(chapter4);
    		dailytimetable chapter5 = new dailytimetable();
    		chapter5.SubjectName = "EE";
    		chapter5.Location = "A-332";
    		chapter5.Type = "Lecture";
    		chapter5.Time1 = "3:40";
    		chapter5.Time2 = "4:30";
    		dailyList.add(chapter5);
    		dailytimetable chapter6 = new dailytimetable();
    		chapter6.SubjectName = "Physical";
    		chapter6.Location = "Sports Complex";
    		chapter6.Type = "";
    		chapter6.Time1 = "4:35";
    		chapter6.Time2 = "6:00";
    		dailyList.add(chapter6);
    			
    	
    		
    		dailytimetable random2 = new dailytimetable();
    		random2.SubjectName = "EE";
    		random2.Location = "A-311";
    		random2.Time1 = "10:40";
    		random2.Time2 = "11:35";
    		random2.Type = "";
    		dailyList1.add(random2);
    		
    		dailytimetable random3 = new dailytimetable();
    		random3.SubjectName = "Math";
    		random3.Location = "A-311";
    		random3.Time1 = "11:35";
    		random3.Time2 = "12:30";
    		random3.Type = "Tut";
    		dailyList1.add(random3);
    		
    		dailytimetable random4 = new dailytimetable();
    		random4.SubjectName = "Lunch";
    		random4.Location = "Hostel";
    		random4.Time1 = "12:30";
    		random4.Time2 = "1:45";
    		random4.Type = "";
    		dailyList1.add(random4);
    		
    		dailytimetable random5 = new dailytimetable();
    		random5.SubjectName = "Engg. Graphics";
    		random5.Location = "EH F.Floor";
    		random5.Type = "";
    		random5.Time1 ="1:45";
    		random5.Time2 ="4:30";
    		dailyList1.add(random5);
    		
    		dailytimetable random6 = new dailytimetable();
    		random6.SubjectName ="Physics";
    		random6.Location ="A-317";
    		random6.Type ="Tut";
    		random6.Time1 = "4:35";
    		random6.Time2 ="6:00";
    		dailyList1.add(random6);
    		

    		
    		dailytimetable wed = new dailytimetable();
    		wed.SubjectName="BEE";
    		wed.Location="A-317";
    		wed.Type="Tut";
    		wed.Time1="8:30";
    		wed.Time2="10:20";
    		dailyList2.add(wed);
    		
    		
    		dailytimetable wed3 = new dailytimetable();
    		wed3.SubjectName="Snacks";
    		wed3.Location="Market";
    		wed3.Type="";
    		wed3.Time1="10:20";
    		wed3.Time2="10:40";
    		dailyList2.add(wed3);
    		
    		dailytimetable wed4 = new dailytimetable();
    		wed4.SubjectName="Chemistry";
    		wed4.Location="Lab UG";
    		wed4.Type="Lab";
    		wed4.Time1="10:40";
    		wed4.Time2="12:30";
    		dailyList2.add(wed4);
    		
    		
    		dailytimetable wed6 = new dailytimetable();
    		wed6.SubjectName="Lunch";
    		wed6.Location="Hostel";
    		wed6.Type="";
    		wed6.Time1="12:30";
    		wed6.Time2="1:45";
    		dailyList2.add(wed6);
    		
    		dailytimetable wed7 = new dailytimetable();
    		wed7.SubjectName="Math";
    		wed7.Location="A-226";
    		wed7.Type="Lecture";
    		wed7.Time1="1:45";
    		wed7.Time2="2:40";
    		dailyList2.add(wed7);
    		
    		dailytimetable wed27 = new dailytimetable();
    		wed27.SubjectName="BEC";
    		wed27.Location="A-226";
    		wed27.Type="Lecture";
    		wed27.Time1="2:40";
    		wed27.Time2="3:35";
    		dailyList2.add(wed27);
    		
    		dailytimetable wed217 = new dailytimetable();
    		wed217.SubjectName="Chemistry";
    		wed217.Location="A-226";
    		wed217.Type="Lecture";
    		wed217.Time2="4:30";
    		wed217.Time1="3:35";
    		dailyList2.add(wed217);
    		
    		
    		dailytimetable t27 = new dailytimetable();
    		t27.SubjectName="Chemistry";
    		t27.Location="A-321";
    		t27.Type="Lecture";
    		t27.Time1="8:30";
    		t27.Time2="9:25";
    		dailyList3.add(t27);
    		
    		dailytimetable wd = new dailytimetable();
    		wd.SubjectName="Chemistry";
    		wd.Location="A-316";
    		wd.Type="Tut";
    		wd.Time1="9:25";
    		wd.Time2="10:20";
    		dailyList3.add(wd);
    		
    		
    		dailytimetable ed3 = new dailytimetable();
    		ed3.SubjectName="Snacks";
    		ed3.Location="Market";
    		ed3.Type="";
    		ed3.Time1="10:20";
    		ed3.Time2="10:40";
    		dailyList3.add(ed3);
    		
    		
    		
    		dailytimetable thru = new dailytimetable();
    		thru.SubjectName="Physics";
    		thru.Location="A-321";
    		thru.Type="Lecure";
    		thru.Time1="10:40";
    		thru.Time2="11:35";
    		dailyList3.add(thru);
    		
    		dailytimetable thru1 = new dailytimetable();
    		thru1.SubjectName="EE";
    		thru1.Location="A-316";
    		thru1.Type="Tut";
    		thru1.Time1="11:35";
    		thru1.Time2="12:30";
    		dailyList3.add(thru1);
    		
    		dailytimetable thru2 = new dailytimetable();
    		thru2.SubjectName="Lunch";
    		thru2.Location="Hostel";
    		thru2.Type="";
    		thru2.Time1="12:30";
    		thru2.Time2="1:45";
    		dailyList3.add(thru2);
    		
    		dailytimetable thru3 = new dailytimetable();
    		thru3.SubjectName="Workshop";
    		thru3.Location="";
    		thru3.Type="";
    		thru3.Time1="1:45";
    		thru3.Time2="4:30";
    		dailyList3.add(thru3);
    		
    		
    		
    		dailytimetable fri = new dailytimetable();
    		fri.SubjectName="BEC";
    		fri.Location="A-315";
    		fri.Type="Lecture";
    		fri.Time1="8:30";
    		fri.Time2="10:20";
    		dailyList4.add(fri);
    		
    		
    		dailytimetable frid1 = new dailytimetable();
    		frid1.SubjectName="Snacks";
    		frid1.Location="Market";
    		frid1.Type="";
    		frid1.Time1="10:20";
    		frid1.Time2="10:40";
    		dailyList4.add(frid1);
    		
    		dailytimetable fri3 = new dailytimetable();
    		fri3.SubjectName="BEE";
    		fri3.Location="A-311";
    		fri3.Type="Lecture";
    		fri3.Time1="10:40";
    		fri3.Time2="11:35";
    		dailyList4.add(fri3);
    		
    		
    		
    		dailytimetable wfre = new dailytimetable();
    		wfre.SubjectName="EE";
    		wfre.Location="A-311";
    		wfre.Type="Lecture";
    		wfre.Time1="11:35";
    		wfre.Time2="12:30";
    		dailyList4.add(wfre);
    		
    		
    		dailytimetable fri4 = new dailytimetable();
    		fri4.SubjectName="Lunch";
    		fri4.Location="Hostel";
    		fri4.Type="";
    		fri4.Time1="12:30";
    		fri4.Time2="1:45";
    		dailyList4.add(fri4);
    		
    		dailytimetable fri5 = new dailytimetable();
    		fri5.SubjectName="Math";
    		fri5.Location="A-311";
    		fri5.Type="Lecture";
    		fri5.Time1="1:45";
    		fri5.Time2="2:40";
    		dailyList4.add(fri5);
    		
    		dailytimetable fri6 = new dailytimetable();
    		fri6.SubjectName="Physics";
    		fri6.Location="A-311";
    		fri6.Type="Lecture";
    		fri6.Time2="3:35";
    		fri6.Time1="2:40";
    		dailyList4.add(fri6);
    		
    		dailytimetable fri7 = new dailytimetable();
    		fri7.SubjectName="BEC";
    		fri7.Location="A-311";
    		fri7.Type="Lecture";
    		fri7.Time1="3:35";
    		fri7.Time2="4:40";
    		dailyList4.add(fri7);
	    		
	    		
	    		switch(position) {
	    		case 1 :
	    			retu = dailyList;
	    			break;
	    		case 2:
	    			retu = dailyList1;
	    			break;
	    		case 3:
	    			retu = dailyList2;
	    			break;
	    		case 4:
	    			retu = dailyList3;
	    			break;
	    		case 0:
	    			retu = dailyList4;
	    			break;
	    		}
	    		return retu;
				
	    }

  
    }
  
}
