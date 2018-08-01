package in.raji.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.raji.myapplication.databinding.ActivityMainBinding;
import in.raji.myapplication.model.Item;
import in.raji.myapplication.retroapi.ResponseListener;
import in.raji.myapplication.viewmodel.ItemViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        binding.setItem(itemViewModel);
        itemViewModel.getItem().observe(this, new Observer<Item>() {
            @Override
            public void onChanged(@Nullable Item item) {
                binding.setItem(itemViewModel);

            }
        });
    }


    public void loadData(View view) {
        binding.progressBar2.setVisibility(View.VISIBLE);
        itemViewModel.loadData(new ResponseListener() {
            @Override
            public void onResponse(Object response) {
                binding.progressBar2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Object error) {
                binding.progressBar2.setVisibility(View.INVISIBLE);

            }
        });
    }

}
