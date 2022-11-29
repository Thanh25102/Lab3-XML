package com.bmt.lab3;

import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.bmt.lab3.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

//    ExecutorService executor = Executors.newFixedThreadPool(4);
//    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
//    VitaminParser vitaminParser = VitaminParser.getInstance();

    public ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.baseline_reorder_black_36);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Restaurant");
//        VitaminRepository vitaminRepository = new VitaminRepository(vitaminParser,executor,mainThreadHandler);
//
//        vitaminRepository.makeVitaminRequest(VitaminURL.ALL,(callBack)->{
//            if(callBack instanceof Result.Success){
//                List<Vitamin> data = ((Result.Success<Vitamin>) callBack).datas;
//                Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();
//            } else {
//                Exception exception = ((Result.Error<Vitamin>) callBack).exception;
//                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
//            }
//        });

//        Toast.makeText(this, "calling ... 1", Toast.LENGTH_SHORT).show();
//        Executors.newSingleThreadExecutor().execute(()->{
//            // Background work
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            mainThreadHandler.post(()->{
//                // UI work
//            });
//        });
//        Toast.makeText(this, "calling ... 2", Toast.LENGTH_SHORT).show();

        viewPager2 = findViewById(R.id.content);
        viewPager2.setAdapter(new ViewPagerAdapter(this));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu1).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu2).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu3).setChecked(true);
                        break;
                }
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu1:
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.menu2:
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.menu3:
                    viewPager2.setCurrentItem(2);
                    break;
            }
            return true;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
