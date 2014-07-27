package com.example.tut;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class Btech1yearHome extends Activity {
	public static int pyara=10;
	
	
	private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] myearTitles;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_btech1year_home);

		mTitle = mDrawerTitle = getTitle();
        myearTitles = getResources().getStringArray(R.array.year_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, myearTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                Btech1yearHome.this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.content_frame, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.btech1year_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	 /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	pyara = position;
            selectItem(position);
            
            mDrawerList.setItemChecked(position, true);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        /*Fragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(PlaceholderFragment.ARG_PLANET_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
       */  
    	
    	//rohit start a selected fragment if selected else start home fragment setup each time
    	//btech 1st year
    	switch(pyara){	
        case 0 :
    	Intent inten1 = new Intent(Btech1yearHome.this, Btech1yearHome.class);
    	inten1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten1);
        break;
    	case 1:
        Intent inten2 = new Intent(Btech1yearHome.this, Btech2yearHome.class);
        inten2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten2);
    	break;
    	case 2:
        Intent inten3 = new Intent(Btech1yearHome.this, Btech3yearHome.class);
        inten3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten3);
        break;
    	case 3:
        Intent inten4 = new Intent(Btech1yearHome.this, Btech4yearHome.class);
        inten4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten4);
        break;
    	case 4:
        Intent inten5 = new Intent(Btech1yearHome.this, Mca1year.class);
        inten5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten5);
        break;
    	case 5:
        Intent inten6 = new Intent(Btech1yearHome.this, Mca2year.class);
        inten6.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten6);
        break;
    	case 6:
        Intent inten7 = new Intent(Btech1yearHome.this, Mca3year.class);
        inten7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten7);
    	break;
    	default :
    }
        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
       // setTitle(myearTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
     
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public static final String ARG_PLANET_NUMBER = "planet_number";
		

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_btech1year_home,
					container, false);
			
			rootView.findViewById(R.id.a1)
			 .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a1 = new Intent(getActivity(), A1Activity.class);
                    startActivity(a1);
                }
            });
			
			rootView.findViewById(R.id.a2)
			 .setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent a2 = new Intent(getActivity(), A2Activity.class);
                   startActivity(a2);
               }
           });
			
			rootView.findViewById(R.id.b1)
			 .setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent b1 = new Intent(getActivity(), B1Activity.class);
                   startActivity(b1);
               }
           });
			rootView.findViewById(R.id.b2)
			 .setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent b2 = new Intent(getActivity(), B2Activity.class);
                   startActivity(b2);
               }
           });
			
			rootView.findViewById(R.id.c1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent c1 = new Intent(getActivity(), C1Activity.class);
                  startActivity(c1);
              }
          });
			rootView.findViewById(R.id.c2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent c2 = new Intent(getActivity(), C2Activity.class);
                  startActivity(c2);
              }
          });
			
			rootView.findViewById(R.id.d1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent d1 = new Intent(getActivity(), D1Activity.class);
                  startActivity(d1);
              }
          });
			rootView.findViewById(R.id.d2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent d2 = new Intent(getActivity(), D2Activity.class);
                  startActivity(d2);
              }
          });
			
			rootView.findViewById(R.id.e1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent e1 = new Intent(getActivity(), E1Activity.class);
                  startActivity(e1);
              }
          });
			rootView.findViewById(R.id.e2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent e2 = new Intent(getActivity(), E2Activity.class);
                  startActivity(e2);
              }
          });
			rootView.findViewById(R.id.f1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent f1 = new Intent(getActivity(), F1Activity.class);
                  startActivity(f1);
              }
          });
			rootView.findViewById(R.id.f2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent f2 = new Intent(getActivity(), F2Activity.class);
                  startActivity(f2);
              }
          });
			
			rootView.findViewById(R.id.g1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent g1 = new Intent(getActivity(), G1Activity.class);
                  startActivity(g1);
              }
          });
			rootView.findViewById(R.id.g2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent g2 = new Intent(getActivity(), G2Activity.class);
                  startActivity(g2);
              }
          });
			
			rootView.findViewById(R.id.h1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent h1 = new Intent(getActivity(), H1Activity.class);
                  startActivity(h1);
              }
          });
			rootView.findViewById(R.id.h2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent h2 = new Intent(getActivity(), H2Activity.class);
                  startActivity(h2);
              }
          });
			
			rootView.findViewById(R.id.i1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i1 = new Intent(getActivity(), I1Activity.class);
                  startActivity(i1);
              }
          });
			rootView.findViewById(R.id.i2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i2 = new Intent(getActivity(), I2Activity.class);
                  startActivity(i2);
              }
          });
			
			rootView.findViewById(R.id.j1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent j1 = new Intent(getActivity(), J1Activity.class);
                  startActivity(j1);
              }
          });
			rootView.findViewById(R.id.j2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent j2 = new Intent(getActivity(), J2Activity.class);
                  startActivity(j2);
              }
          });
			
			rootView.findViewById(R.id.k1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent k1 = new Intent(getActivity(), K1Activity.class);
                  startActivity(k1);
              }
          });
			rootView.findViewById(R.id.k2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent k2 = new Intent(getActivity(), K2Activity.class);
                  startActivity(k2);
              }
          });
			
			rootView.findViewById(R.id.l1)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent l1 = new Intent(getActivity(), L1Activity.class);
                  startActivity(l1);
              }
          });
			rootView.findViewById(R.id.l2)
			 .setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent l2 = new Intent(getActivity(), L2Activity.class);
                  startActivity(l2);
              }
          });
			
			return rootView;
		}
	}

}
