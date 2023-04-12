package com.github.cao.awa.kalmia.client;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.github.cao.awa.kalmia.client.client.ClientNetworkIo;
import com.github.cao.awa.kalmia.client.databinding.ActivityMainBinding;
import com.github.cao.awa.kalmia.network.packet.factor.unsolve.UnsolvedPacketFactor;
import com.github.zhuaidadaya.rikaishinikui.handler.universal.entrust.EntrustEnvironment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration configuration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        setSupportActionBar(this.binding.appBarMain.toolbar);

        this.binding.appBarMain.fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            EntrustEnvironment.thread(() -> {
                try {
                    UnsolvedPacketFactor.register();

                    new ClientNetworkIo().connect("172.27.176.1", 12345);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
        DrawerLayout drawerLayout = this.binding.drawerLayout;
        NavigationView navView = this.binding.navView;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        this.configuration = new AppBarConfiguration.Builder(
                Set.of(
                        R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
                )).setOpenableLayout(drawerLayout)
                .setFallbackOnNavigateUpListener(() -> false)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, this.configuration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, this.configuration) || super.onSupportNavigateUp();
    }
}
