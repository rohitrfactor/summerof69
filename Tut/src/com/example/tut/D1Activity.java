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

public class D1Activity extends FragmentActivity {
   
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
    		chapter.SubjectName = "BEc";
    		chapter.Location = "A-303";
    		chapter.Type = "Tutorial";
    		chapter.Time1 = "8:30";
    		chapter.Time2 = "10:20";
    		dailyList.add(chapter);
    		
    		dailytimetable br = new dailytimetable();
    		br.SubjectName = "Snacks Time";
            br.Location = "Market";
            br.Type="";
            br.Time1 = "10:20";
            br.Time2 = "10:40";
            dailyList.add(br);
    				
    		dailytimetable chapter2 = new dailytimetable();
    		chapter2.SubjectName = "Physics";
    		chapter2.Location = "A-303";
    		chapter2.Type = "Lecture";
    		chapter2.Time1 = "10:40";
    		chapter2.Time2 = "11:35";
    		dailyList.add(chapter2);
    		
    		dailytimetable chapte2 = new dailytimetable();
    		chapte2.SubjectName = "Math";
    		chapte2.Location = "A-315";
    		chapte2.Type = "Tut";
    		chapte2.Time2 = "12:30";
    		chapte2.Time1 = "11:35";
    		dailyList.add(chapte2);
    		
    		dailytimetable chapter3 = new dailytimetable();
    		chapter3.SubjectName = "Lunch";
    		chapter3.Location = "Hostel";
    		chapter3.Type = "";
    		chapter3.Time1 = "12:30";
    		chapter3.Time2 = "1:45";
    		dailyList.add(chapter3);
    		dailytimetable chapter4 = new dailytimetable();
    		chapter4.SubjectName = "BEE";
    		chapter4.Location = "A-322";
    		chapter4.Type = "Lecture";
    		chapter4.Time1 = "1:45";
    		chapter4.Time2 = "2:40";
    		dailyList.add(chapter4);
    		
    		dailytimetable chaptr2 = new dailytimetable();
    		chaptr2.SubjectName = "EE";
    		chaptr2.Location = "A-315";
    		chaptr2.Type = "Tut";
    		chaptr2.Time1 = "2:40";
    		chaptr2.Time2 = "3:35";
    		dailyList.add(chaptr2);
    		dailytimetable chapter5 = new dailytimetable();
    		chapter5.SubjectName = "Chemistry";
    		chapter5.Location = "A-315";
    		chapter5.Type = "Tut";
    		chapter5.Time1 = "3:35";
    		chapter5.Time2 = "4:30";
    		dailyList.add(chapter5);
    		
    			
    	
    		dailytimetable  random= new dailytimetable();
    		random.SubjectName = "Math";
    		random.Location = "A-332";
    		random.Type = "Lecture";
    		random.Time1 = "8:30";
    		random.Time2 = "9:25";
    		dailyList1.add(random);
    		
    		dailytimetable random1 = new dailytimetable();
    		random1.SubjectName = "BEC";
    		random1.Location = "A-332";
    		random1.Time1 = "9:25";
    		random1.Time2 = "10:20";
    		random1.Type = "Lecture";
    		dailyList1.add(random1);
    		
    		dailytimetable random2 = new dailytimetable();
    		random2.SubjectName = "Snacks";
    		random2.Location = "Market";
    		random2.Time1 = "10:20";
    		random2.Time2 = "10:40";
    		random2.Type = "";
    		dailyList1.add(random2);
    		
    		dailytimetable random3 = new dailytimetable();
    		random3.SubjectName = "EE";
    		random3.Location = "A-321";
    		random3.Time1 = "10:40";
    		random3.Time2 = "11:35";
    		random3.Type = "Tut";
    		dailyList1.add(random3);
    		
    		dailytimetable chap = new dailytimetable();
    		chap.SubjectName = "Chemistry";
    		chap.Location = "A-321";
    		chap.Type = "Lecture";
    		chap.Time1 = "11:35";
    		chap.Time2 = "12:30";
    		dailyList1.add(chap);
    		
    		dailytimetable random4 = new dailytimetable();
    		random4.SubjectName = "Lunch";
    		random4.Location = "Hostel";
    		random4.Time1 = "12:30";
    		random4.Time2 = "1:45";
    		random4.Type = "";
    		dailyList1.add(random4);
    		
    		dailytimetable random5 = new dailytimetable();
    		random5.SubjectName = "Physics";
    		random5.Location = "A-321";
    		random5.Type = "Lecture";
    		random5.Time1 ="1:45";
    		random5.Time2 ="2:40";
    		dailyList1.add(random5);
    		
    		dailytimetable random6 = new dailytimetable();
    		random6.SubjectName ="Physics";
    		random6.Location ="A-315";
    		random6.Type ="Tut";
    		random6.Time1 = "2:40";
    		random6.Time2 ="4:30";
    		dailyList1.add(random6);
    		

    		
    		dailytimetable chapter6 = new dailytimetable();
    		chapter6.SubjectName = "Physical";
    		chapter6.Location = "Sports Complex";
    		chapter6.Type = "";
    		chapter6.Time1 = "4:35";
    		chapter6.Time2 = "6:00";
    		dailyList1.add(chapter6);
    		
    		dailytimetable wed = new dailytimetable();
    		wed.SubjectName="Workshop";
    		wed.Location="";
    		wed.Type="";
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
    		wed4.SubjectName="Workshop";
    		wed4.Location="";
    		wed4.Type="";
    		wed4.Time1="10:40";
    		wed4.Time2="11:35";
    		dailyList2.add(wed4);
    		
    		dailytimetable wed5 = new dailytimetable();
    		wed5.SubjectName="EE";
    		wed5.Location="A-311";
    		wed5.Type="Lecture";
    		wed5.Time1="11:35";
    		wed5.Time2="12:30";
    		dailyList2.add(wed5);
    		
    		dailytimetable wed6 = new dailytimetable();
    		wed6.SubjectName="Lunch";
    		wed6.Location="Hostel";
    		wed6.Type="";
    		wed6.Time1="12:30";
    		wed6.Time2="1:45";
    		dailyList2.add(wed6);
    		
    		dailytimetable wed7 = new dailytimetable();
    		wed7.SubjectName="Math";
    		wed7.Location="A-311";
    		wed7.Type="Lecture";
    		wed7.Time1="1:45";
    		wed7.Time2="2:40";
    		dailyList2.add(wed7);
    		
    		dailytimetable wed8 = new dailytimetable();
    		wed8.SubjectName="BEE";
    		wed8.Location="A-317";
    		wed8.Type="Tut";
    		wed8.Time2="4:30";
    		wed8.Time1="2:40";
    		dailyList2.add(wed8);
    		
    		dailytimetable thru = new dailytimetable();
    		thru.SubjectName="Chemistry";
    		thru.Location="Lab UG";
    		thru.Type="Lab";
    		thru.Time1="10:40";
    		thru.Time2="12:30";
    		dailyList3.add(thru);
    		
    		
    		
    		dailytimetable thru2 = new dailytimetable();
    		thru2.SubjectName="Lunch";
    		thru2.Location="Hostel";
    		thru2.Type="";
    		thru2.Time1="12:30";
    		thru2.Time2="1:45";
    		dailyList3.add(thru2);
    		
    		dailytimetable thru3 = new dailytimetable();
    		thru3.SubjectName="Math";
    		thru3.Location="A-321";
    		thru3.Type="Lecture";
    		thru3.Time1="1:45";
    		thru3.Time2="2:40";
    		dailyList3.add(thru3);
    		
    		dailytimetable thru4 = new dailytimetable();
    		thru4.SubjectName="Physics";
    		thru4.Location="A-322";
    		thru4.Type="Lecture";
    		thru4.Time1="2:40";
    		thru4.Time2="3:35";
    		dailyList3.add(thru4);
    		
    		dailytimetable thru5 = new dailytimetable();
    		thru5.SubjectName="Engg. Graphics";
    		thru5.Location="EH F.Floor";
    		thru5.Type="";
    		thru5.Time1="3:35";
    		thru5.Time2="6:00";
    		dailyList3.add(thru5);
    		
    		
    		
    		
    		dailytimetable fri = new dailytimetable();
    		fri.SubjectName="Engg. Graphics";
    		fri.Location="EH F.Floor";
    		fri.Type="";
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
    		fri3.SubjectName="Engg. Graphics";
    		fri3.Location="EH F.Floor";
    		fri3.Type="";
    		fri3.Time1="10:40";
    		fri3.Time2="11:35";
    		dailyList4.add(fri3);
    		
    		dailytimetable fri4 = new dailytimetable();
    		fri4.SubjectName = "BEC";
    		fri4.Location = "A-321";
    		fri4.Time2="12:30";
    		fri4.Time1="11:35";
    		dailyList4.add(fri4);
    		
    		dailytimetable fri41 = new dailytimetable();
    		fri41.SubjectName = "EE";
    		fri41.Location = "A-321";
    		fri41.Time1="12:30";
    		fri41.Time2="1:45";
    		dailyList4.add(fri41);
    		
    		dailytimetable fri5 = new dailytimetable();
    		fri5.SubjectName="Lunch";
    		fri5.Location="Hostel";
    		fri5.Type="";
    		fri5.Time1="1:45";
    		fri5.Time2="2:40";
    		dailyList4.add(fri5);
    		
    		dailytimetable friT = new dailytimetable();
    		friT.SubjectName = "Chemisry";
    		friT.Location = "A-321";
    		friT.Time1="2:40";
    		friT.Time2="3:35";
    		dailyList4.add(friT);
    		
    		dailytimetable friT1 = new dailytimetable();
    		friT1.SubjectName = "BEE";
    		friT1.Location = "A-321";
    		friT1.Time2="4:30";
    		friT1.Time1="3:35";
    		dailyList4.add(friT1);
	    		
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
